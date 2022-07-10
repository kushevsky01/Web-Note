package web.note.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        return "login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @PostMapping("/login/fail")
    public String loginFail(Model model) {
        model.addAttribute("loginError", "Неверный логин или пароль");

        return "login";
    }
}