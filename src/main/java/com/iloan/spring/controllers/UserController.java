package com.iloan.spring.controllers;

import com.iloan.spring.models.User;
import com.iloan.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/users")
    public String viewHomePage(Model model) {
        model.addAttribute("users_list", userRepo.findAll());
        return "users/index";
    }



    @PostMapping("/users/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userRepo.save(user);
        return "redirect:/users";
    }

    @GetMapping("/users/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") int id, Model model) {
        Optional<User> optional = userRepo.findById(id);
        User user = null;
        if (optional.isPresent()) {
            user = optional.get();
            model.addAttribute("user", user);
        }
        else
            throw new RuntimeException(
                    "User not found for id : " + id);
        return "users/update";
    }

    @GetMapping("/users/deleteUser/{id}")
    public String deleteThroughId(@PathVariable(value = "id") int id) {
        userRepo.deleteById(id);
        return "redirect:/users";
    }
}
