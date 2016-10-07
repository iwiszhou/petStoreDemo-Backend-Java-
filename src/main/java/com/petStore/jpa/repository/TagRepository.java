package com.petStore.jpa.repository;


import com.petStore.jpa.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

/**
 * Created by iwis on 2016-10-05.
 */
@RepositoryRestResource(exported = false)
public interface TagRepository extends JpaRepository<Tag, Long> {
}
