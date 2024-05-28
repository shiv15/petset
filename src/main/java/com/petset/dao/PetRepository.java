package com.petset.dao;

import com.petset.model.Pet;
import org.springframework.stereotype.Repository;


@Repository
public interface PetRepository extends BaseJPARepository<Pet, String> {
}
