package com.example.coffee.service;

import com.example.coffee.entity.TaiKhoan;
import com.example.coffee.repository.TaiKhoanRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final TaiKhoanRepository taiKhoanRepository;

    public AuthService(TaiKhoanRepository taiKhoanRepository) {
        this.taiKhoanRepository = taiKhoanRepository;
    }

    public Optional<TaiKhoan> dangNhap(String tenDangNhap, String matKhau) {
        if (tenDangNhap == null || matKhau == null) {
            return Optional.empty();
        }
        return taiKhoanRepository.findByTenDangNhap(tenDangNhap.trim())
                .filter(taiKhoan -> matKhau.equals(taiKhoan.getMatKhau()));
    }
}
