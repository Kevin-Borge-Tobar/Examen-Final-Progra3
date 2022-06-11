package com.progra3.petstore.repositories;

import com.progra3.petstore.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository  extends JpaRepository<Pet, Integer> {
}
