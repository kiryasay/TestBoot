package kirysay.spring.TestBoot.controllers;



import kirysay.spring.TestBoot.model.MyUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/admin-panel/edituser/{userId}")
    public String editUserForm(@PathVariable int userId, Model model) {
        // Логика получения пользователя по userId
        Optional<MyUser> userOptional = personController.findById(userId);

        // Проверка наличия пользователя
        if (userOptional.isPresent()) {
            model.addAttribute("user", userOptional.get());
            return "user-edit"; // Имя вашего HTML-шаблона
        } else {
            // Обработка случая, когда пользователя с таким ID нет
            return "redirect:/admin-panel"; // Или другой путь по вашему выбору
        }
    }


    @PostMapping("/admin-panel/edituser/{userId}")
    public String editUser(@PathVariable int userId, @ModelAttribute MyUser editedUser, RedirectAttributes redirectAttributes) {
        // Логика обновления пользователя в базе данных
        // ...

        redirectAttributes.addFlashAttribute("successMessage", "Пользователь успешно отредактирован.");
        return "redirect:/admin-panel";
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
