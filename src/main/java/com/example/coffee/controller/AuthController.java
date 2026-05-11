package com.example.coffee.controller;

import com.example.coffee.dto.LoginRequest;
import com.example.coffee.entity.TaiKhoan;
import com.example.coffee.service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    public static final String CURRENT_USER_ID = "CURRENT_USER_ID";
    public static final String CURRENT_USERNAME = "CURRENT_USERNAME";
    public static final String CURRENT_ROLE = "CURRENT_ROLE";

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public String loginForm(Model model, HttpSession session) {
        if (session.getAttribute(CURRENT_USER_ID) != null) {
            return "redirect:/home";
        }
        model.addAttribute("loginRequest", new LoginRequest());
        model.addAttribute("pageTitle", "Đăng nhập");
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest loginRequest, HttpSession session, Model model) {
        return authService.dangNhap(loginRequest.getTenDangNhap(), loginRequest.getMatKhau())
                .map(taiKhoan -> dangNhapThanhCong(taiKhoan, session))
                .orElseGet(() -> dangNhapThatBai(loginRequest, model));
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    private String dangNhapThanhCong(TaiKhoan taiKhoan, HttpSession session) {
        session.setAttribute(CURRENT_USER_ID, taiKhoan.getMaTaiKhoan());
        session.setAttribute(CURRENT_USERNAME, taiKhoan.getTenDangNhap());
        session.setAttribute(CURRENT_ROLE, taiKhoan.getQuyenHan());
        return "redirect:/home";
    }

    private String dangNhapThatBai(LoginRequest loginRequest, Model model) {
        model.addAttribute("loginRequest", loginRequest);
        model.addAttribute("pageTitle", "Đăng nhập");
        model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng");
        return "auth/login";
    }
}
