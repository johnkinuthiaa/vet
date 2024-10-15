package com.crud.crud.controller;

import com.crud.crud.model.Pet;
import com.crud.crud.service.PetServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pets")
public class PetController {
    private final PetServiceInterface service;
    public PetController(PetServiceInterface service){
        this.service=service;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Pet>> findAllPets(){
        return ResponseEntity.ok(service.findAllPets());
    }
    @GetMapping("/get/{name}")
    public ResponseEntity<List<Pet>> getPetByName(@PathVariable("name")@RequestParam String name){
        return ResponseEntity.ok(service.getPetByName(name));
    }
    @GetMapping("/get/{breed}")
    public ResponseEntity<List<Pet>> getByBreed(@PathVariable("breed")@RequestParam String breed){
        return ResponseEntity.ok(service.getByBreed(breed));
    }
    @PostMapping("/add/new")
    public ResponseEntity< Pet> createNewPet(@RequestBody Pet pet){
        return ResponseEntity.ok(service.createNewPet(pet));
    }
    @PutMapping("/update/pet")
    public ResponseEntity< Pet> updateExistingPet(@RequestBody Pet pet, @RequestParam Long id){
        return ResponseEntity.ok(service.updateExistingPet(pet,id));
    }
    @DeleteMapping("/delete")
    public void deletePetById(@RequestParam Long id){
        service.deletePetById(id);
    }
    @DeleteMapping("/all")
    public void deleteAllPets(){
        service.deleteAllPets();
    }
}
