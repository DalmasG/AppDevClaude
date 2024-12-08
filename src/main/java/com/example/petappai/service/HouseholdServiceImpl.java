package com.example.petappai.service;

import com.example.petappai.dto.HouseholdWithoutPetsDTO;
import com.example.petappai.entity.Household;
import com.example.petappai.repository.HouseholdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HouseholdServiceImpl implements HouseholdService {

    @Autowired
    private HouseholdRepository householdRepository;

    @Override
    public Household createHousehold(Household household) {
        // Validate household details before creating
        if (household.getNumberOfOccupants() > household.getMaxOccupants()) {
            throw new IllegalArgumentException("Number of occupants cannot exceed maximum occupants");
        }
        if (household.getEircode() == null || household.getEircode().isEmpty()) {
            throw new IllegalArgumentException("Eircode cannot be empty");
        }
        return householdRepository.save(household);
    }

    @Override
    public List<Household> getAllHouseholds() {
        return householdRepository.findAll();
    }

    @Override
    public HouseholdWithoutPetsDTO getHouseholdByIdWithoutPets(Long id) {
        Household household = householdRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Household not found with id: " + id));
        
        return new HouseholdWithoutPetsDTO(
            household.getId(),
            household.getEircode(),
            household.getNumberOfOccupants(),
            household.getMaxOccupants(),
            household.isOwnerOccupied()
        );
    }

    @Override
    public Household getHouseholdByIdWithPets(Long id) {
        return householdRepository.findByIdWithPets(id);
    }

    @Override
    public Household updateHousehold(Long id, Household householdDetails) {
        Household existingHousehold = householdRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Household not found with id: " + id));

        // Validate and update fields
        if (householdDetails.getEircode() != null && !householdDetails.getEircode().isEmpty()) {
            existingHousehold.setEircode(householdDetails.getEircode());
        }
        if (householdDetails.getNumberOfOccupants() >= 0 && 
            householdDetails.getNumberOfOccupants() <= existingHousehold.getMaxOccupants()) {
            existingHousehold.setNumberOfOccupants(householdDetails.getNumberOfOccupants());
        }
        if (householdDetails.getMaxOccupants() > 0) {
            existingHousehold.setMaxOccupants(householdDetails.getMaxOccupants());
        }
        existingHousehold.setOwnerOccupied(householdDetails.isOwnerOccupied());

        return householdRepository.save(existingHousehold);
    }

    @Override
    @Transactional
    public void deleteHouseholdById(Long id) {
        if (!householdRepository.existsById(id)) {
            throw new RuntimeException("Household not found with id: " + id);
        }
        householdRepository.deleteById(id);
    }

    @Override
    public List<Household> getHouseholdsWithNoPets() {
        return householdRepository.findHouseholdsWithNoPets();
    }

    @Override
    public List<Household> getOwnerOccupiedHouseholds() {
        return householdRepository.findByOwnerOccupiedTrue();
    }

    @Override
    public Map<String, Object> getHouseholdStatistics() {
        Map<String, Object> statistics = new HashMap<>();
        
        long emptyHouses = householdRepository.countByNumberOfOccupantsEquals(0);
        List<Household> fullHouses = householdRepository.findFullHouseholds();
        
        statistics.put("totalHouseholds", householdRepository.count());
        statistics.put("emptyHouses", emptyHouses);
        statistics.put("fullHouses", fullHouses.size());
        
        return statistics;
    }
}