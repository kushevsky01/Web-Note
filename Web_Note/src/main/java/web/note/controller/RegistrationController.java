package web.note.controller;

import lombok.RequiredArgsConstructor;
import web.note.model.User;
import web.note.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class RegistrationController {
    private final UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") User userForm,
                          Model model) {

        if (userForm.getName().equals("")) {
            model.addAttribute("nameError",
                    "Имя пользователя не задано");
            return "registration";}
        if (!userForm.getPassword().equals(userForm.getSecondPassword())) {
            model.addAttribute("secondPasswordError",
                    "Пароли не совпадают");
            return "registration";}


        if (!userService.saveUser(userForm)) {
            model.addAttribute("usernameError",
                    "Пользователь с таким именем уже существует");
            return "registration";
        }
        userService.addRoleToUser(userForm.getUsername(), "ROLE_USER");
        return "redirect:/";
    }
}