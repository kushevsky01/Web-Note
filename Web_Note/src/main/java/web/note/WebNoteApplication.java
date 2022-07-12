package web.note;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
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
            userService.saveUser(new web.note.model.User("admin", "admin", "admin","admin","active", "ROLE_ADMIN"));
            userService.saveUser(new web.note.model.User("user", "user", "user","user","active", "ROLE_USER"));
            userService.saveUser(new web.note.model.User("k", "k", "k","k","active", "ROLE_USER"));
        };
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
