package com.example.petappai.service;

import com.example.petappai.dto.PetNameTypeBreedDTO;
import com.example.petappai.entity.Pet;
import com.example.petappai.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Override
    public Pet createPet(Pet pet) {
        // Validate pet details before creating
        if (pet.getName() == null || pet.getName().isEmpty()) {
            throw new IllegalArgumentException("Pet name cannot be empty");
        }
        if (pet.getAge() < 0) {
            throw new IllegalArgumentException("Pet age cannot be negative");
        }
        return petRepository.save(pet);
    }

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Pet getPetById(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet not found with id: " + id));
    }

    @Override
    public Pet updatePet(Long id, Pet petDetails) {
        Pet existingPet = getPetById(id);

        // Validate and update fields
        if (petDetails.getName() != null && !petDetails.getName().isEmpty()) {
            existingPet.setName(petDetails.getName());
        }
        if (petDetails.getAnimalType() != null && !petDetails.getAnimalType().isEmpty()) {
            existingPet.setAnimalType(petDetails.getAnimalType());
        }
        if (petDetails.getBreed() != null && !petDetails.getBreed().isEmpty()) {
            existingPet.setBreed(petDetails.getBreed());
        }
        if (petDetails.getAge() >= 0) {
            existingPet.setAge(petDetails.getAge());
        }

        return petRepository.save(existingPet);
    }

    @Override
    @Transactional
    public void deletePetById(Long id) {
        if (!petRepository.existsById(id)) {
            throw new RuntimeException("Pet not found with id: " + id);
        }
        petRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deletePetsByName(String name) {
        petRepository.deleteByNameIgnoreCase(name);
    }

    @Override
    public List<Pet> getPetsByAnimalType(String animalType) {
        return petRepository.findByAnimalType(animalType);
    }

    @Override
    public List<Pet> getPetsByBreed(String breed) {
        return petRepository.findByBreedOrderByAgeAsc(breed);
    }

    @Override
    public List<PetNameTypeBreedDTO> getPetNamesAndBreeds() {
        return petRepository.findNamesAndBreeds();
    }

    @Override
    public Map<String, Object> getPetStatistics() {
        Map<String, Object> statistics = new HashMap<>();
        statistics.put("totalPets", petRepository.count());
        statistics.put("averageAge", petRepository.calculateAverageAge());
        statistics.put("oldestAge", petRepository.findOldestAge());
        return statistics;
    }
}