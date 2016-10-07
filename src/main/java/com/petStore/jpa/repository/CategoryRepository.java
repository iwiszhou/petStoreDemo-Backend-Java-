package com.petStore.jpa.repository;

import com.petStore.jpa.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by iwis on 2016-10-05.
 */
@RepositoryRestResource(exported = false)
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
