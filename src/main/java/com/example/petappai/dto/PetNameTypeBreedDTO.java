package com.example.petappai.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetNameTypeBreedDTO {
    private String name;
    private String animalType;
    private String breed;
}