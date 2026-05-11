package com.example.coffee.repository;

import com.example.coffee.entity.ChiTietThucDon;
import com.example.coffee.entity.id.ChiTietThucDonId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChiTietThucDonRepository extends JpaRepository<ChiTietThucDon, ChiTietThucDonId> {
}

