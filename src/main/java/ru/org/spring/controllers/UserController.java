package ru.org.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.org.spring.model.User;
import ru.org.spring.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{name}")
    public String One(@PathVariable("name") String name, Model model) {
        User user = userService.findByName(name);
        model.addAttribute("user", user);
        return "user.html";

    }

}
