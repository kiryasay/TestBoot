package kirysay.spring.TestBoot.controllers;

import kirysay.spring.TestBoot.model.MyUser;
import kirysay.spring.TestBoot.model.Person;
import kirysay.spring.TestBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private UserRepository userRepository;


    public List<MyUser> showAll() {
        List<MyUser> users = userRepository.findAll();
        System.out.println("Number of users retrieved: " + users.size());
        return users;
    }
    @GetMapping("/{id}")
    public MyUser showById(@PathVariable int id) {
        Optional<MyUser> userOptional = userRepository.findByUserId(id);
        return userOptional.orElse(null);
    }
}