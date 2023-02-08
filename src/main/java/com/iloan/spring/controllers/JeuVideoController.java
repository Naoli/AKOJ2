package com.iloan.spring.controllers;

import com.iloan.spring.models.JeuVideo;
import com.iloan.spring.repositories.JeuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class JeuVideoController {
    @Autowired
    private JeuRepository jeuRepo;

    @GetMapping("/jeux")
    public String viewHomePage(Model model) {
        model.addAttribute("users_list", jeuRepo.findAll());
        return "jeux/index";
    }

    @GetMapping("/jeux/addnew")
    public String addNewUser(Model model) {
        JeuVideo jeuvideo = new JeuVideo();
        model.addAttribute("jeu", jeuvideo);
        return "jeux/newuser";
    }

    @PostMapping("/jeux/save")
    public String saveUser(@ModelAttribute("jeu") JeuVideo jeuvideo) {
        jeuRepo.save(jeuvideo);
        return "redirect:/jeux";
    }

    @GetMapping("/jeux/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") int id, Model model) {
        Optional<JeuVideo> optional = jeuRepo.findById(id);
        JeuVideo jeuvideo = null;
        if (optional.isPresent()) {
            jeuvideo = optional.get();
            model.addAttribute("jeu", jeuvideo);
        }
        else
            throw new RuntimeException(
                    "Jeu not found for id : " + id);
        return "jeux/update";
    }

    @GetMapping("/jeux/deleteJeu/{id}")
    public String deleteThroughId(@PathVariable(value = "id") int id) {
        jeuRepo.deleteById(id);
        return "redirect:/jeux";
    }
}
