package com.example.petappai.service;

import com.example.petappai.dto.HouseholdWithoutPetsDTO;
import com.example.petappai.entity.Household;
import java.util.List;
import java.util.Map;

public interface HouseholdService {
    // Create Household
    Household createHousehold(Household household);

    // Read All Households
    List<Household> getAllHouseholds();

    // Read Household by ID - without pets details
    HouseholdWithoutPetsDTO getHouseholdByIdWithoutPets(Long id);

    // Read Household by ID - with pets details
    Household getHouseholdByIdWithPets(Long id);

    // Update Household Details
    Household updateHousehold(Long id, Household householdDetails);

    // Delete Household by ID
    void deleteHouseholdById(Long id);

    // Find Households with no pets
    List<Household> getHouseholdsWithNoPets();

    // Find Owner-Occupied Households
    List<Household> getOwnerOccupiedHouseholds();

    // Get Household Statistics
    Map<String, Object> getHouseholdStatistics();
}