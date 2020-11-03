package com.sda.userpassword.controller;

import com.sda.userpassword.model.PhoneEntity;
import com.sda.userpassword.model.UserPassword;
import com.sda.userpassword.service.UserPasswordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserPasswordController {

    UserPasswordService userPasswordService;

    public UserPasswordController(UserPasswordService userPasswordService) {
        this.userPasswordService = userPasswordService;
    }

    @GetMapping("/")
    public String getAll(Model model){
        List<UserPassword> all = userPasswordService.getAll();
        model.addAttribute("passwords", all);
        return "index";
    }

    @GetMapping("/addpass")
    public String addPassword(Model model){
        model.addAttribute("password", new UserPassword());
        return "add-password";
    }

    @PostMapping("/")
    public String savePassword(@Valid UserPassword userPassword, BindingResult result){
        if (result.hasErrors()) {
            return "add-password";
        }
        userPasswordService.addUserPassword(userPassword);
        return "redirect:/";
    }

    @GetMapping("/delete/{name}")
    public String deletePassword(@PathVariable String name){
        userPasswordService.removeUserPassword(name);
        return "redirect:/";
    }

    @GetMapping("/details/{name}")
    public String showDetails(@PathVariable String name, Model model) {
        List<PhoneEntity> phonesByUsername = userPasswordService.getPhonesByUsername(name);
        model.addAttribute("phones", phonesByUsername);
        return "details";
    }
}
