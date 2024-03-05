package kirysay.spring.TestBoot.controllers;

import kirysay.spring.TestBoot.Config.MyUserDetails;
import kirysay.spring.TestBoot.Services.MyUserDetailServices;
import kirysay.spring.TestBoot.model.MyUser;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class SecurityController {
private MyUserDetailServices service;
      // Handler Methods
    @GetMapping("/home")
    public ResponseEntity<String> welcome(){
        return ResponseEntity.ok("I am User");
    }

    @GetMapping("/admin")
    public ResponseEntity<String> adminUser1(){
        return ResponseEntity.ok("I am Admin");
    }

    @GetMapping("/registred")
    public ResponseEntity<String> publicUser(){
        return ResponseEntity.ok("I am Registred User");
    }

}