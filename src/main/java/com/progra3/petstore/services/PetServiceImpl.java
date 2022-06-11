package com.progra3.petstore.services;

import com.progra3.petstore.dtos.PetDto;
import com.progra3.petstore.entities.Pet;
import com.progra3.petstore.repositories.PetRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/***
 * Todos los metodos retornan objetos o listas de objetos de tipo DTO para poder hacer mas sencilla la manipulacion de los datos
 */

@Service
public class PetServiceImpl  implements  PetService{

    private PetRepository petRepository;
    private ModelMapper modelMapper;

    private PetDto petDto;

    @Autowired
    public PetServiceImpl(PetRepository petRepository, ModelMapper modelMapper) {
        this.petRepository = petRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PetDto> listAll() {

        List<PetDto>  petsDtos= petRepository.findAll()
                .stream().map(pet -> modelMapper
                        .map(pet, PetDto.class))
                .collect(Collectors.toList());

        return petsDtos;
    }


    @Override
    public PetDto findById(Integer id) {
         Pet pet = petRepository.findById(id).orElse(null);
         PetDto petDto = modelMapper.map(pet, PetDto.class);
         return petDto;

    }

    @Override
    public PetDto createPet(PetDto petDto) {
        this.petDto = petDto;
        Pet savedPet = parsePetDto();
        if(savedPet.validPet()){
            petRepository.save(savedPet);
            return modelMapper.map(savedPet, PetDto.class);
        } else {
            return null;
        }
    }


    @Override
    public PetDto updatePet(Integer id, PetDto petDto) {
        this.petDto = petDto;
        Pet updatedPet = parsePetDto();
        updatedPet = petRepository.findById(id).orElse(null);
        if (updatedPet!= null || updatedPet.validPet()) {
            updatedPet.setName(petDto.getName());
            updatedPet.setPrice(petDto.getPrice());
            updatedPet.setBirthDay(petDto.getBirthDay());
            petRepository.save(updatedPet);
            return modelMapper.map(updatedPet, PetDto.class);
        }else {
            return null;
        }
    }

    @Override
    public Boolean deletePet(Integer id) {
        Pet pet = petRepository.findById(id).orElse(null);
        Boolean removed;
        if (pet != null) {
            return removed = false;
        }else{
            petRepository.delete(pet);
            return removed = true;
        }
    }

    private Pet parsePetDto(){
        Pet pet  = new Pet();
        pet.setIdPet(this.petDto.getIdPet());
        pet.setName(this.petDto.getName());
        pet.setPrice(this.petDto.getPrice());
        pet.setBirthDay(this.petDto.getBirthDay());
        return  pet;
    }
}
