package com.company.contactmanagement.Controllers;

import com.company.contactmanagement.dao.UserRepo;
import com.company.contactmanagement.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//import ch.qos.logback.core.model.Model;
import org.springframework.ui.*;

@Controller

public class PagesController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserRepo userrepo;
    @GetMapping("/")
    public String Home( Model model) {
        model.addAttribute("title","Home - Contact-Management Application");
        return "Home";
    }
    @GetMapping("/login")
    public String Login( Model model){
        model.addAttribute("title","Login - Contact-Management Application");
        return "Login";
}
    @GetMapping("/signup")
    public String Signup( Model model){
        model.addAttribute("title","Register - Contact-Management Application");
        model.addAttribute("user",new User());
        return "Signup";
}



    
}
