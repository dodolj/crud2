package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @RequestMapping("/")
    public String redirectHome(Model model) {
        return "redirect:/users";
    }

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user-list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") UUID id, Model model) {
        Optional<User> userOptional = userService.getUserById(id);

        if (userOptional.isPresent()) {
            model.addAttribute("user", userOptional.get());
            return "user-edit";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") UUID id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/deleteAll")
    public String deleteAllUsers() {
        userService.deleteAllUsers();
        return "redirect:/";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }
}