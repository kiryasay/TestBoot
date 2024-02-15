package kirysay.spring.TestBoot.Services;

import kirysay.spring.TestBoot.Config.MyUserDetails;
import kirysay.spring.TestBoot.model.MyUser;
import kirysay.spring.TestBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class MyUserDetailServices implements UserDetailsService {
    @Autowired
    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String userLogin) throws UsernameNotFoundException {
        Optional<MyUser> user = repository.findByUserLogin(userLogin);
        return user.map(MyUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(userLogin + "not found"));
    }
    public void addUser(MyUser user) {
        repository.save(user);
    }
}
