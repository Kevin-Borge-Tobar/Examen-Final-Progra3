package com.progra3.petstore.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.progra3.petstore.dtos.PetDto;
import com.progra3.petstore.entities.Pet;
import com.progra3.petstore.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pet")
public class PetController {
	
	 private PetService service;

	 @Autowired
	public PetController(PetService service) {
		this.service = service;
	}

	@GetMapping
	public List<PetDto> findAll(){
		return service.listAll();
	}

	@GetMapping(value = "/{id}")
	public PetDto findPet(@PathVariable Integer id) {
		 return service.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Object>createPet(@RequestBody PetDto petDto) {
		return   ResponseEntity.ok(service.createPet(petDto));
	}

	@PutMapping
	public PetDto updatePet(Integer id, PetDto petDto) {
		 return service.updatePet(id, petDto);
		
	}

	//se modifico el return de este metodo a un booleano para poder identificar si la mascota fue elminada o no
	@DeleteMapping(value = "/{id}")
	public Boolean deletePet( @PathVariable Integer id) {
		 return service.deletePet(id);
	}
}
