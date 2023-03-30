package ma.enset.jpaenset;

import ma.enset.jpaenset.entities.Role;
import ma.enset.jpaenset.entities.User;
import ma.enset.jpaenset.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Stream;

@SpringBootApplication
public class JpaEnsetApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaEnsetApplication.class, args);
    }

    CommandLineRunner start(UserService userService){
        return args -> {
            User u =new User();
            u.setUsername("admin");
            u.setUsername("123456");
            userService.addNewUser(u);

            User u2 =new User();
            u2.setUsername("user1");
            u2.setUsername("123456");
            userService.addNewUser(u2);

            /*List<User> lu =new ArrayList<>();
            lu.add(u2);*/

            Stream.of("Student", "User", "Admin").forEach(r->{
                Role role1 =new Role();
                role1.setRoleName(r);
                role1.setDesc(r);
                userService.addNewRole(role1);
            });

            userService.addRoleToUser("user1","Student");
            userService.addRoleToUser("user1","User");
            userService.addRoleToUser("admin","Admin");
        };
    }

}
