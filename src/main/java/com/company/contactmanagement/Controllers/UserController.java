package com.company.contactmanagement.Controllers;

import com.company.contactmanagement.dao.UserRepo;
import com.company.contactmanagement.entities.Contact;
import com.company.contactmanagement.entities.User;
import com.company.contactmanagement.helper.Message;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@RestController
@Controller
public class UserController {
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/users")
    public ResponseEntity< List<User>> getBooks() {
        List<User> list=this.userRepo.findAll();
        if(list.size()<=0){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }
    @GetMapping("/user")
        public User addBook(){
        User user=new User();

        user.setName("John");
        user.setEmail("John123@gmail.com");
        user.setPassword("John1234");
        user.setAbout("John is going to die ");
        user.setRole("user");
        user.setEnabled(false);
        user.setImgUrl("www.instagram.com");
        return this.userRepo.save(user);
        }
    @PostMapping("/process")
    public String formValidator(@Valid @ModelAttribute("user") User user,BindingResult result,  Model model){

        try {
            if(result.hasErrors()){
                System.out.println(user.getAgreement());
                System.out.println("error"+result.toString());
                model.addAttribute("user",user);
                return "signup";
            }
//            if(!user.getAgreement()){
//                System.out.println("Please agree to the Terms & Conditions...");
//                throw new Exception("Please agree to the Terms & Conditions...");
//            }

            user.setRole("USER");

            user.setImgUrl("http://cat.google.com");
            System.out.println(user);
//            User data=  this.userRepo.save(user);
//            System.out.println(data);
            model.addAttribute("user",new User());
            model.addAttribute("message",new Message("Registered Successfully..!!","alert-success"));
            return "Signup";

        }
        catch (Exception e){
            e.printStackTrace();
            model.addAttribute("user",user);
            model.addAttribute("message",new Message("Something went wrong..!! "+e.getMessage(),"alert-danger"));
            return  "signup";

        }
    }
    @PostMapping("/fetch")

    @GetMapping("/contact")
        public User addContact(){
            Contact contact = new Contact();
            User user = new User();
            Optional<User> user3 =this.userRepo.findById(1);
            System.out.println(user3);
            contact.setEmail(("john123@gmail.com"));
            contact.setPhone("1234567890");
            contact.setDescription("Family contacts ");
            contact.setWork("business");
            contact.setImgUrl("http://Image.io.com ");
            contact.setNick_name("cena");
            user.getContacts().add(contact);
            return this.userRepo.save(user);
        }
    }

