package com.crud.crud.service;

import com.crud.crud.model.Pet;
import com.crud.crud.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetService implements PetServiceInterface{
    private final PetRepository repository;
    public PetService(PetRepository repository){
        this.repository=repository;
    }
    @Override
    public List<Pet> findAllPets(){
        return repository.findAll();
    }


    @Override
    public  List<Pet> getPetByName(String name){
        return repository.findAll().stream()
                .filter(pet -> pet.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
    @Override
    public List<Pet> getByBreed(String breed){
        return repository.findAll().stream()
                .filter(pet->pet.getBreed().toLowerCase().contains(breed.toLowerCase()))
                .collect(Collectors.toList());
    }
    @Override
    public Pet createNewPet(Pet pet){
        if(repository.findPetById(pet.getId()).isPresent()){
            throw new RuntimeException("pet already exists");
        }
        Pet pet1 =new Pet();
        pet1.setName(pet.getName());
        pet1.setBreed(pet.getBreed());
        pet1.setColor(pet.getColor());
        pet1.setDescription(pet.getDescription());
        pet1.setPrice(pet.getPrice());
        pet1.setCreatedOn(LocalDateTime.now());
        return repository.save(pet1);
    }
    @Override
    public Pet updateExistingPet(Pet pet,Long id){
        if(repository.findPetById(id).isPresent()){
            repository.deleteById(id);
        }
        Pet pet1 =new Pet();
        pet1.setId(id);
        pet1.setName(pet.getName());
        pet1.setBreed(pet.getBreed());
        pet1.setColor(pet.getColor());
        pet1.setDescription(pet.getDescription());
        pet1.setPrice(pet.getPrice());
        pet1.setCreatedOn(LocalDateTime.now());
        return repository.save(pet1);

    }
    @Override
    public void deletePetById(Long id){
        if(repository.findPetById(id).isPresent()){
            repository.deleteById(id);
        }
    }
    @Override
    public void deleteAllPets(){
        repository.deleteAll();
    }
}
