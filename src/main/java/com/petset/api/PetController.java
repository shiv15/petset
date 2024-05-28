package com.petset.api;

import com.petset.model.Pet;
import com.petset.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pets")
public class PetController {
    @Autowired
    private PetService petService;

    @PostMapping("/addPet")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPet(@RequestBody Pet pet) {
        this.petService.addPet(pet);
    }

    @PutMapping("/updatePet")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePet(@RequestBody Pet pet) {
        this.petService.updatePet(pet);
    }

    @DeleteMapping("/deletePet/{petId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePet(@PathVariable("petId") String petId) {
        this.petService.deletePet(petId);
    }

    @GetMapping("/getPet/{petId}")
    @ResponseStatus(HttpStatus.OK)
    public Pet getPet(@PathVariable("petId") String petId) {
        return this.petService.getPet(petId);
    }
}