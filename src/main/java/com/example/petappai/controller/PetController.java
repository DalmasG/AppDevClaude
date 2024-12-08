package com.example.petappai.controller;

import com.example.petappai.dto.PetNameTypeBreedDTO;
import com.example.petappai.entity.Pet;
import com.example.petappai.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping
    public Pet createPet(@RequestBody Pet pet) {
        return petService.createPet(pet);
    }

    @GetMapping
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @GetMapping("/{id}")
    public Pet getPetById(@PathVariable Long id) {
        return petService.getPetById(id);
    }

    @PutMapping("/{id}")
    public Pet updatePet(@PathVariable Long id, @RequestBody Pet petDetails) {
        return petService.updatePet(id, petDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePetById(@PathVariable Long id) {
        petService.deletePetById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/name/{name}")
    public ResponseEntity<Void> deletePetsByName(@PathVariable String name) {
        petService.deletePetsByName(name);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/type/{animalType}")
    public List<Pet> getPetsByAnimalType(@PathVariable String animalType) {
        return petService.getPetsByAnimalType(animalType);
    }

    @GetMapping("/breed/{breed}")
    public List<Pet> getPetsByBreed(@PathVariable String breed) {
        return petService.getPetsByBreed(breed);
    }

    @GetMapping("/names-breeds")
    public List<PetNameTypeBreedDTO> getPetNamesAndBreeds() {
        return petService.getPetNamesAndBreeds();
    }

    @GetMapping("/statistics")
    public Map<String, Object> getPetStatistics() {
        return petService.getPetStatistics();
    }
}