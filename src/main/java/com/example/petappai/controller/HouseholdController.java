package com.example.petappai.controller;

import com.example.petappai.dto.HouseholdWithoutPetsDTO;
import com.example.petappai.entity.Household;
import com.example.petappai.service.HouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/households")
public class HouseholdController {

    @Autowired
    private HouseholdService householdService;

    @PostMapping
    public Household createHousehold(@RequestBody Household household) {
        return householdService.createHousehold(household);
    }

    @GetMapping
    public List<Household> getAllHouseholds() {
        return householdService.getAllHouseholds();
    }

    @GetMapping("/{id}/without-pets")
    public HouseholdWithoutPetsDTO getHouseholdWithoutPets(@PathVariable Long id) {
        return householdService.getHouseholdByIdWithoutPets(id);
    }

    @GetMapping("/{id}/with-pets")
    public Household getHouseholdWithPets(@PathVariable Long id) {
        return householdService.getHouseholdByIdWithPets(id);
    }

    @PutMapping("/{id}")
    public Household updateHousehold(@PathVariable Long id, @RequestBody Household householdDetails) {
        return householdService.updateHousehold(id, householdDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHouseholdById(@PathVariable Long id) {
        householdService.deleteHouseholdById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/no-pets")
    public List<Household> getHouseholdsWithNoPets() {
        return householdService.getHouseholdsWithNoPets();
    }

    @GetMapping("/owner-occupied")
    public List<Household> getOwnerOccupiedHouseholds() {
        return householdService.getOwnerOccupiedHouseholds();
    }

    @GetMapping("/statistics")
    public Map<String, Object> getHouseholdStatistics() {
        return householdService.getHouseholdStatistics();
    }
}