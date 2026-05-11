package com.example.coffee.repository;

import com.example.coffee.entity.ChiTietHoaDon;
import com.example.coffee.entity.id.ChiTietHoaDonId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChiTietHoaDonRepository extends JpaRepository<ChiTietHoaDon, ChiTietHoaDonId> {
}
