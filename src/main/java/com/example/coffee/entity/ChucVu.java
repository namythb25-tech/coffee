package com.example.coffee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ChucVu", schema = "dbo")
public class ChucVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaChucVu")
    private Integer maChucVu;

    @Column(name = "Luong", nullable = false)
    private Integer luong;

    @Column(name = "TenChucVu", nullable = false, length = 100)
    private String tenChucVu;

    public Integer getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(Integer maChucVu) {
        this.maChucVu = maChucVu;
    }

    public Integer getLuong() {
        return luong;
    }

    public void setLuong(Integer luong) {
        this.luong = luong;
    }

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }
}
