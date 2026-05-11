package com.example.coffee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ThucDon", schema = "dbo")
public class ThucDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaThucDon")
    private Integer maThucDon;
    @Column(name = "TenMon", nullable = false, length = 150)
    private String tenMon;
    @Column(name = "GiaTienHienTai", nullable = false)
    private Integer giaTienHienTai;
    @Column(name = "LoaiMon", nullable = false, length = 100)
    private String loaiMon;
    public Integer getMaThucDon() { return maThucDon; }
    public void setMaThucDon(Integer maThucDon) { this.maThucDon = maThucDon; }
    public String getTenMon() { return tenMon; }
    public void setTenMon(String tenMon) { this.tenMon = tenMon; }
    public Integer getGiaTienHienTai() { return giaTienHienTai; }
    public void setGiaTienHienTai(Integer giaTienHienTai) { this.giaTienHienTai = giaTienHienTai; }
    public String getLoaiMon() { return loaiMon; }
    public void setLoaiMon(String loaiMon) { this.loaiMon = loaiMon; }
}
