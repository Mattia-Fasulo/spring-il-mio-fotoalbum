package org.project.fotoalbum.controller;

import org.project.fotoalbum.model.Photo;
import org.project.fotoalbum.repository.CategoryRepository;
import org.project.fotoalbum.services.CategoryService;
import org.project.fotoalbum.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/photos")
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String index(
            @RequestParam(name = "q") Optional<String> keyword,
            Model model
    ){
        List<Photo> photoList;

        if(keyword.isEmpty()){
            photoList = photoService.getAll();
        } else {
            photoList = photoService.getByName(keyword.get());
            model.addAttribute("keyword", keyword.get());
        }
        model.addAttribute("list", photoList);
        return "/photos/index";
    }

    @GetMapping("/{photoId}")
    public String show(
        Model model,
        @PathVariable("photoId") Integer id
    ){
        Photo photo = photoService.getById(id);
        model.addAttribute("photo", photo);
        return "/photos/show";
    }


}
