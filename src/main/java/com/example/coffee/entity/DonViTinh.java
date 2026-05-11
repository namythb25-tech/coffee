package com.example.coffee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DonViTinh", schema = "dbo")
public class DonViTinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaDonViTinh")
    private Integer maDonViTinh;
    @Column(name = "TenDonVi", nullable = false, length = 50)
    private String tenDonVi;
    public Integer getMaDonViTinh() { return maDonViTinh; }
    public void setMaDonViTinh(Integer maDonViTinh) { this.maDonViTinh = maDonViTinh; }
    public String getTenDonVi() { return tenDonVi; }
    public void setTenDonVi(String tenDonVi) { this.tenDonVi = tenDonVi; }
}
