package com.example.petappai.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseholdInput {
    private String eircode;
    private int numberOfOccupants;
    private int maxOccupants;
    private boolean ownerOccupied;
}