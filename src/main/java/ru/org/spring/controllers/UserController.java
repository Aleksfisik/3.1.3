package ru.org.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.org.spring.model.User;
import ru.org.spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String findAll(Model model){
        List<User> users=userService.findAll();
        model.addAttribute("users",users);
        System.out.println("EFEF");
        return "user-list.html";

    }
    @GetMapping("/user/{name}")
    public String One(@PathVariable("name") String name, Model model){
        User user = userService.findByName(name);
        model.addAttribute("user", user);
        return "user.html";

    }
    @GetMapping("/admin/user-create")
    public String createPersonForm(User user){
        return "user-create.html";
    }
    @PostMapping("/admin/user-create")
    public String createPerson(User user){
        userService.savePerson(user);
        return "redirect:/admin";
    }
    @GetMapping("/admin/user-delete/{id}")
    public String deletePerson(@PathVariable("id") Long id){
        userService.deleteById(id);
        return "redirect:/admin";
    }
    @GetMapping("/admin/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user-update.html";
    }

    @PostMapping("/admin/user-update")
    public String updateUser(User user){
        userService.savePerson(user);
        return "redirect:/admin";
    }
}
