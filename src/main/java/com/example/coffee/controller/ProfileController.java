package com.example.coffee.controller;

import com.example.coffee.service.NhanVienService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {
    private final NhanVienService nhanVienService;

    public ProfileController(NhanVienService nhanVienService) {
        this.nhanVienService = nhanVienService;
    }

    @GetMapping("/profile")
    public String profile(HttpSession session) {
        Integer maTaiKhoan = (Integer) session.getAttribute(AuthController.CURRENT_USER_ID);
        if (maTaiKhoan == null) {
            return "redirect:/login";
        }
        Integer maNhanVien = nhanVienService.layMaNhanVienTheoTaiKhoan(maTaiKhoan);
        return "redirect:/employees/" + maNhanVien + "/edit";
    }
}
