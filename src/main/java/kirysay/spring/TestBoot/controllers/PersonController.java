package kirysay.spring.TestBoot.controllers;

import kirysay.spring.TestBoot.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @GetMapping()
    public List<Person> showAll()
    {
        return List.of(
                new Person("Kirill", 20),
                new Person("Nikita", 21),
                new Person("Dany", 20)
        );
    }

}
