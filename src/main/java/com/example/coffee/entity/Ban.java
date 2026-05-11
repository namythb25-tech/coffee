package com.example.coffee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Ban", schema = "dbo")
public class Ban {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaBan")
    private Integer maBan;

    @Column(name = "TinhTrang", nullable = false, length = 50)
    private String tinhTrang;

    @Column(name = "TenBan", nullable = false, length = 100)
    private String tenBan;

    public Integer getMaBan() { return maBan; }
    public void setMaBan(Integer maBan) { this.maBan = maBan; }

    public String getTinhTrang() { return tinhTrang; }
    public void setTinhTrang(String tinhTrang) { this.tinhTrang = tinhTrang; }

    public String getTenBan() { return tenBan; }
    public void setTenBan(String tenBan) { this.tenBan = tenBan; }
}
