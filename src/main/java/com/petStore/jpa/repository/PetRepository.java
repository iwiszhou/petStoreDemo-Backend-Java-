package com.petStore.jpa.repository;

import com.petStore.jpa.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

/**
 * Created by iwis on 2016-10-04.
 */
@RepositoryRestResource(path = "/mypet")
public interface PetRepository extends JpaRepository<Pet, Long>{
    Pet findById(@Param("pid") long pid);
}
