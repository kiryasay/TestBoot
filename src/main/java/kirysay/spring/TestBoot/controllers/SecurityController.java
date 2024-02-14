package kirysay.spring.TestBoot.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class SecurityController {

      // Handler Methods
    @GetMapping("/normal")
    public ResponseEntity<String> normalUser(){
        return ResponseEntity.ok("I am User");
    }

    @GetMapping("/admin")
    public ResponseEntity<String> adminUser(){
        return ResponseEntity.ok("I am Admin");
    }

    @GetMapping("/public")
    public ResponseEntity<String> publicUser(){
        return ResponseEntity.ok("I am Public User");
    }
}