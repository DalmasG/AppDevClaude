package com.example.petappai.repository;

import com.example.petappai.dto.PetNameTypeBreedDTO;
import com.example.petappai.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    // Delete all pets by name (case-insensitive)
    void deleteByNameIgnoreCase(String name);

    // Find pets by animal type
    List<Pet> findByAnimalType(String animalType);

    // Find pets by breed, ordered by age
    List<Pet> findByBreedOrderByAgeAsc(String breed);

    // Get name, animal type, and breed
    @Query("SELECT new com.example.petappai.dto.PetNameTypeBreedDTO(p.name, p.animalType, p.breed) FROM Pet p")
    List<PetNameTypeBreedDTO> findNamesAndBreeds();

    // Pet statistics
    @Query("SELECT AVG(p.age) FROM Pet p")
    Double calculateAverageAge();

    @Query("SELECT MAX(p.age) FROM Pet p")
    Integer findOldestAge();
}