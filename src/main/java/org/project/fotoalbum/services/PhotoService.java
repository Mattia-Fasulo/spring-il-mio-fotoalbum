package org.project.fotoalbum.services;

import org.project.fotoalbum.exceptions.CategoryNotFoundException;
import org.project.fotoalbum.exceptions.PhotoNotFoundException;
import org.project.fotoalbum.model.Category;
import org.project.fotoalbum.model.Photo;
import org.project.fotoalbum.repository.CategoryRepository;
import org.project.fotoalbum.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class PhotoService {
    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public boolean isValidName(Photo photo){
        if(photo.getId() == null){
            return !photoRepository.existsByName(photo.getName());
        }
        return !photoRepository.existsByNameAndIdNot(photo.getName(), photo.getId());
    }

    public List<Photo> getAll(){
        return photoRepository.findAll();
    }

    public List<Photo> getByName(String keyword) {
        return photoRepository.findByNameContainingIgnoreCase(keyword);
    }

    public Photo getById(Integer id) throws PhotoNotFoundException{
        Optional<Photo> result = photoRepository.findById(id);
        if(result.isEmpty()){
            throw new PhotoNotFoundException("Photo not found");
        } else {
            return result.get();
        }
    }

    public Set<Category> getCategories(Photo photo){
        Set<Category> categories = new HashSet<>();
        if(photo.getCategories() != null){
            for(Category c : photo.getCategories()){
                categories.add(categoryRepository.findById(c.getId()).orElseThrow(()-> new CategoryNotFoundException("Category not found")));
            }
        }
        return categories;
    }

    public Photo createPhoto(Photo formPhoto){
        Photo photoToPersist = new Photo();
        photoToPersist.setName(formPhoto.getName());
        photoToPersist.setDescription(formPhoto.getDescription());
        photoToPersist.setUrl(formPhoto.getUrl());
        photoToPersist.setVisible(formPhoto.isVisible());
        photoToPersist.setCreatedAt(LocalDateTime.now());
        photoToPersist.setCategories(getCategories(formPhoto));

        return photoRepository.save(photoToPersist);

    }

    public Photo updatePhoto(Photo formPhoto, Integer id){
        Photo photoToUpdate = getById(id);
        photoToUpdate.setName(formPhoto.getName());
        photoToUpdate.setDescription(formPhoto.getDescription());
        photoToUpdate.setUrl(formPhoto.getUrl());
        photoToUpdate.setVisible(formPhoto.isVisible());
        photoToUpdate.setCategories(getCategories(formPhoto));

        return photoRepository.save(photoToUpdate);

    }
}
