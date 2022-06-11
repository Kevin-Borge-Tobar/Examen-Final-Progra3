package com.progra3.petstore.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PetDto implements Serializable {
    private final Integer idPet;
    private final String name;
    private final double price;
    private final Date birthDay;
}
