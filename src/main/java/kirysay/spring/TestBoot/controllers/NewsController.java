package kirysay.spring.TestBoot.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewsController {

    @GetMapping("/news")
    public ResponseEntity<String> welcome(){
        return ResponseEntity.ok("I am User");
    }

}
