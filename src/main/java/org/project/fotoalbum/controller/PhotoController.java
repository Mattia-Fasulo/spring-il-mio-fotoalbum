package org.project.fotoalbum.controller;

import jakarta.validation.Valid;
import org.project.fotoalbum.exceptions.PhotoNotFoundException;
import org.project.fotoalbum.model.AlertMessage;
import org.project.fotoalbum.model.AlertMessage.AlertMessageType;
import org.project.fotoalbum.model.Photo;
import org.project.fotoalbum.services.CategoryService;
import org.project.fotoalbum.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        System.out.println(photo);
        return "/photos/show";
    }

    @GetMapping("/create")
    public String create(
            Model model
    ){
        model.addAttribute("photo", new Photo());
        model.addAttribute("categories", categoryService.getAll());
        return "/photos/save";
    }

    @PostMapping("/create")
    public String doCreate(
        Model model,
        @Valid @ModelAttribute("photo") Photo formPhoto,
        BindingResult bindingResult
    ){
        if(!photoService.isValidName(formPhoto)) {
            bindingResult.addError(new FieldError("pizza", "name", formPhoto.getName(), false, null, null,
                    "name must be unique"));
        }

        if(bindingResult.hasErrors()){
            model.addAttribute("categories", categoryService.getAll());
            return "/photos/save";
        }

        photoService.createPhoto(formPhoto);
        return "redirect:/photos";
    }

    @GetMapping("/edit/{id}")
    public String edit(
            Model model,
            @PathVariable Integer id
    ){
        try{
            Photo photo = photoService.getById(id);
            model.addAttribute("photo", photo);
            model.addAttribute("categories", categoryService.getAll());
            return "/photos/save";
        } catch (PhotoNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Photo with " + id + " not found");
        }
    }

    @PostMapping("/edit/{id}")
    public String doEdit(
            Model model,
            @PathVariable Integer id,
            @Valid @ModelAttribute("photo") Photo formPhoto,
            BindingResult bindingResult
    ){
        if(!photoService.isValidName(formPhoto)) {
            bindingResult.addError(new FieldError("pizza", "name", formPhoto.getName(), false, null, null,
                    "name must be unique"));
        }

        if(bindingResult.hasErrors()){
            model.addAttribute("categories", categoryService.getAll());
            return "/photos/save";
        }
        try{
            Photo updatePhoto = photoService.updatePhoto(formPhoto, id);
            return "redirect:/photos/" + Integer.toString(updatePhoto.getId());
        } catch (PhotoNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Photo with " + id + " not found");
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(
        @PathVariable Integer id,
        RedirectAttributes redirectAttributes
    ){
        try{
            boolean success = photoService.deleteById(id);
            if(success){
                redirectAttributes.addFlashAttribute("message",
                        new AlertMessage(AlertMessageType.SUCCESS, "Photo with id " + 1 + " deleted"));
            } else {
                redirectAttributes.addFlashAttribute("message",
                        new AlertMessage(AlertMessageType.ERROR, "Unable to delete photo with id " + id));
            }
        } catch(PhotoNotFoundException e){
            redirectAttributes.addFlashAttribute("message",
                    new AlertMessage(AlertMessageType.ERROR, "Photo with id " + id + " not found"));
        }
        return "redirect:/photos";
    }


}
