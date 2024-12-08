package com.example.petappai.service;

import com.example.petappai.dto.PetNameTypeBreedDTO;
import com.example.petappai.entity.Pet;
import java.util.List;
import java.util.Map;

public interface PetService {
    // Create Pet
    Pet createPet(Pet pet);

    // Read All Pets
    List<Pet> getAllPets();

    // Read Pet by ID
    Pet getPetById(Long id);

    // Update Pet Details
    Pet updatePet(Long id, Pet petDetails);

    // Delete Pet by ID
    void deletePetById(Long id);

    // Delete Pets by Name
    void deletePetsByName(String name);

    // Find Pets by Animal Type
    List<Pet> getPetsByAnimalType(String animalType);

    // Find Pets by Breed
    List<Pet> getPetsByBreed(String breed);

    // Get name and breed only
    List<PetNameTypeBreedDTO> getPetNamesAndBreeds();

    // Get Pet Statistics
    Map<String, Object> getPetStatistics();
}