package web.note;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class WebNoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebNoteApplication.class, args);

    }
    @Bean
    CommandLineRunner run(web.note.service.UserService userService) {
        return args -> {
            userService.saveRole(new web.note.model.Role(null, "ROLE_ADMIN"));
            userService.saveRole(new web.note.model.Role(null, "ROLE_USER"));

            userService.saveUser(new web.note.model.User("admin", "admin", "admin","admin"));

            userService.addRoleToUser("admin", "ROLE_ADMIN");
        };
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
