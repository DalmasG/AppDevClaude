package com.example.petappai.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseholdWithoutPetsDTO {
    private Long id;
    private String eircode;
    private int numberOfOccupants;
    private int maxOccupants;
    private boolean ownerOccupied;
}