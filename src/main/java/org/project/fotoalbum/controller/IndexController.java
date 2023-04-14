package org.project.fotoalbum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String index(){
        //throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED, "My custom error");
        return "redirect:/photos";
    }
}
