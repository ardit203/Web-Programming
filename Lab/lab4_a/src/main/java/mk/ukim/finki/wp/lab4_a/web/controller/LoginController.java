package mk.ukim.finki.wp.lab4_a.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {
    @GetMapping
    public String getLoginPage(Model model){
        model.addAttribute("bodyContent", "login");
        return "master-template";
    }
}
