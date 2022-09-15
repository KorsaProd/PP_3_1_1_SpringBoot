package ru.korsa.pp_3_1_1_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.korsa.pp_3_1_1_springboot.model.User;
import ru.korsa.pp_3_1_1_springboot.service.UserServiceImpl;


import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getHomePage(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("{id}")
    public String showUser(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "showUser";
    }

    @GetMapping("/newUser")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "newUser";
    }

    @PostMapping("/newUser")
    public String addUser(@ModelAttribute("user") @Valid User user,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "newUser";
        }
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("user", userService.getUserById(id));
        return "editUser";
    }

    @PatchMapping("{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult, @PathVariable("id") Integer id) {
        if (bindingResult.hasErrors()) {
            return "editUser";
        }
        userService.updateUser(user, id);
        return "redirect:/";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") Integer id) {
        userService.removeUserById(id);
        return "redirect:/";
    }




}
