package org.project.fotoalbum.repository;

import org.project.fotoalbum.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {
    List<Photo> findByNameContainingIgnoreCase(String name);
}
