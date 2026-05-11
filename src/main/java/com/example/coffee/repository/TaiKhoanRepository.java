package com.example.coffee.repository;

import com.example.coffee.entity.TaiKhoan;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Integer> {
    Optional<TaiKhoan> findByTenDangNhap(String tenDangNhap);
    boolean existsByTenDangNhap(String tenDangNhap);
}

