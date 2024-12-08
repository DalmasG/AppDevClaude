package com.example.petappai.repository;

import com.example.petappai.entity.Household;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseholdRepository extends JpaRepository<Household, Long> {
    // Find households with no pets
    @Query("SELECT h FROM Household h WHERE h.pets IS EMPTY")
    List<Household> findHouseholdsWithNoPets();

    // Find owner-occupied households
    List<Household> findByOwnerOccupiedTrue();

    // Count empty houses (no occupants)
    long countByNumberOfOccupantsEquals(int occupants);

    // Find households with occupants equal to max occupants
    @Query("SELECT h FROM Household h WHERE h.numberOfOccupants = h.maxOccupants")
    List<Household> findFullHouseholds();

    // Get household by ID with pets
    @Query("SELECT h FROM Household h LEFT JOIN FETCH h.pets WHERE h.id = :id")
    Household findByIdWithPets(Long id);
}