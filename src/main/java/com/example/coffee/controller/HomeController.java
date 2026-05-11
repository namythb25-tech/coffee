package com.example.coffee.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String home(Model model, HttpSession session) {
        if (session.getAttribute(AuthController.CURRENT_USER_ID) == null) {
            return "redirect:/login";
        }
        model.addAttribute("pageTitle", "Coffee House Admin");
        model.addAttribute("currentUsername", session.getAttribute(AuthController.CURRENT_USERNAME));
        model.addAttribute("currentRole", session.getAttribute(AuthController.CURRENT_ROLE));
        return "home";
    }
}
