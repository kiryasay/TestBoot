package kirysay.spring.TestBoot.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Data
@Entity
@Table(name = "user_list")

public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_name", unique = true)
    private String userName;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_rule")
    private String userRole;

    @Getter
    @Column(name = "user_login")
    private String userLogin;
    public String getName() {
        return  userName;
    }

    public String getPassword() {
        return userPassword;
    }

    public String getRole() {
        return  userRole;
    }

}
