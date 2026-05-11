package com.example.coffee.repository;

import com.example.coffee.entity.Ban;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BanRepository extends JpaRepository<Ban, Integer> {
}
