package org.project.fotoalbum.services;

import org.project.fotoalbum.exceptions.PhotoNotFoundException;
import org.project.fotoalbum.model.Photo;
import org.project.fotoalbum.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {
    @Autowired
    private PhotoRepository photoRepository;

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
}
