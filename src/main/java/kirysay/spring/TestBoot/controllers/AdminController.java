package kirysay.spring.TestBoot.controllers;



import kirysay.spring.TestBoot.model.MyUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {

    private  final PersonController personController;

    @GetMapping("/admin-panel")
    public String admin(Model model) {
        List<MyUser> users = personController.showAll();
        model.addAttribute("users", users);
        return "admin";
    }

    @PostMapping("/admin-panel/adduser")
    public ResponseEntity<String> adminUser1(){
        return ResponseEntity.ok("I am Admin");
    }

    @PostMapping("/admin-panel/edituser")
    public ResponseEntity<String> adminUser2(){
        return ResponseEntity.ok("I am Admin");
    }

    @PostMapping("/admin-panel/addnews")
    public ResponseEntity<String> adminUser3(){
        return ResponseEntity.ok("I am Admin");
    }

    @PostMapping("/admin-panel/editnews")
    public ResponseEntity<String> adminUser4(){
        return ResponseEntity.ok("I am Admin");
    }
}
