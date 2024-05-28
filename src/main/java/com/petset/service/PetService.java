package com.petset.service;

import com.petset.dao.PetRepository;
import com.petset.model.Pet;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PetService {

    private PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public void addPet(Pet pet) {
        try {
            this.validatePet(pet);
            Pet petToSave = new Pet();
            petToSave.setPetId(pet.getPetId());
            petToSave.setName(pet.getName());
            petToSave.setPetType(pet.getPetType());
            petToSave.setAge(pet.getAge());
            petToSave.setBreed(pet.getBreedId());
            petToSave.setOwners(pet.getOwners());
            // TODO: should be the current user in session.
            petToSave.setCreatedBy("admin");
            petToSave.setCreatedOn(LocalDateTime.now());
            this.petRepository.save(petToSave);
        } catch (Exception exp) {
            throw new RuntimeException(exp);
        }
    }

    public Pet getPet(String petId) {
        try {
            Optional<Pet> pet = this.petRepository.findById(petId);
            return pet.orElse(null);
        } catch (Exception exp) {
            throw new RuntimeException(exp);
        }
    }

    public void deletePet(String petId) {
        try {
            this.petRepository.deleteById(petId);
        } catch (Exception exp) {
            throw new RuntimeException(exp);
        }
    }

    public void updatePet(Pet pet) {
        try {
            Optional<Pet> petInDb = this.petRepository.findById(pet.getPetId());
            if (petInDb.isEmpty()) {
                throw new RuntimeException("Pet not found with id: " + pet.getPetId());
            }
            this.validatePet(pet);
            Pet petToSave = new Pet();
            petToSave.setPetId(pet.getPetId());
            petToSave.setName(pet.getName());
            petToSave.setPetType(pet.getPetType());
            petToSave.setAge(pet.getAge());
            petToSave.setBreed(pet.getBreedId());
            petToSave.setLastUpdatedBy("admin");
            petToSave.setLastUpdatedOn(LocalDateTime.now());
            petToSave.setCreatedBy(petInDb.get().getCreatedBy());
            petToSave.setCreatedOn(petInDb.get().getCreatedOn());
            petToSave.setOwners(pet.getOwners());
            this.petRepository.save(petToSave);
        } catch (Exception exp) {
            throw new RuntimeException(exp);
        }
    }

    private void validatePet(Pet pet) {
        if (pet.getName() == null || pet.getName().isEmpty()) {
            throw new RuntimeException("Pet name cannot be empty");
        }
        if (pet.getPetType() == null) {
            throw new RuntimeException("Pet type cannot be empty");
        }
    }
}
