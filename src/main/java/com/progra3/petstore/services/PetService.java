package com.progra3.petstore.services;

import java.util.List;

import com.progra3.petstore.dtos.PetDto;
import com.progra3.petstore.entities.Pet;

public interface PetService {
	
	List<PetDto> listAll();
	PetDto findById(Integer id);
	PetDto createPet(PetDto petDto);
	PetDto updatePet(Integer id, PetDto petDto);
	 Pet deletePet(Integer id);

}
