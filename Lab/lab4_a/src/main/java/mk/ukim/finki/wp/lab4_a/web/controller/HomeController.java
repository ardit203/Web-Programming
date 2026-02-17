package mk.ukim.finki.wp.lab4_a.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping()
    public String getHomePage(Model model){
        model.addAttribute("bodyContent", "home");
        return "master-template";
    }

    @GetMapping("/accessDenied")
    public String accessDenied(Model model){
        model.addAttribute("bodyContent", "access-denied");
        return "master-template";
    }
}
