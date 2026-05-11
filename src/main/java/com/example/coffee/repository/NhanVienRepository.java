package com.example.coffee.repository;

import com.example.coffee.entity.NhanVien;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {
    List<NhanVien> findByHoTenContainingIgnoreCaseOrSoDienThoaiContainingIgnoreCase(String hoTen, String soDienThoai);
}

