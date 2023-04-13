package org.project.fotoalbum.services;

import org.project.fotoalbum.model.Photo;
import org.project.fotoalbum.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {
    @Autowired
    private PhotoRepository photoRepository;

    public List<Photo> getAll(){
        return photoRepository.findAll();
    }
}
