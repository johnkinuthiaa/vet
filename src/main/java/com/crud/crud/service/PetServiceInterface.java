package com.crud.crud.service;

import com.crud.crud.model.Pet;

import java.util.List;

public interface PetServiceInterface {
    List<Pet> findAllPets();
    List<Pet> getPetByName(String name);
    List<Pet> getByBreed(String breed);
    Pet createNewPet(Pet pet);
    Pet updateExistingPet(Pet pet,Long id);
    void deletePetById(Long id);
    void deleteAllPets();
}
