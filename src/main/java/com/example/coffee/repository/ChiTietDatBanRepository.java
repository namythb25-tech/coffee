package com.example.coffee.repository;

import com.example.coffee.entity.ChiTietDatBan;
import com.example.coffee.entity.id.ChiTietDatBanId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChiTietDatBanRepository extends JpaRepository<ChiTietDatBan, ChiTietDatBanId> {
}
