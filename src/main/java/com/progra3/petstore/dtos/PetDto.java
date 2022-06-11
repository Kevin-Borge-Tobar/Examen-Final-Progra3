package com.progra3.petstore.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PetDto implements Serializable {
    private  Integer idPet;
    private String name;
    private  double price;
    private Date birthDay;
}
