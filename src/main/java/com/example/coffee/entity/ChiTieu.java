package com.example.coffee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "ChiTieu", schema = "dbo")
public class ChiTieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaChiTieu")
    private Integer maChiTieu;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaTaiKhoan", nullable = false)
    private TaiKhoan taiKhoan;
    @Column(name = "SoTien", nullable = false)
    private Integer soTien;
    @Column(name = "TenKhoanChi", nullable = false, length = 150)
    private String tenKhoanChi;
    @Column(name = "NgayChi", nullable = false)
    private LocalDate ngayChi;
    public Integer getMaChiTieu() { return maChiTieu; }
    public void setMaChiTieu(Integer maChiTieu) { this.maChiTieu = maChiTieu; }
    public TaiKhoan getTaiKhoan() { return taiKhoan; }
    public void setTaiKhoan(TaiKhoan taiKhoan) { this.taiKhoan = taiKhoan; }
    public Integer getSoTien() { return soTien; }
    public void setSoTien(Integer soTien) { this.soTien = soTien; }
    public String getTenKhoanChi() { return tenKhoanChi; }
    public void setTenKhoanChi(String tenKhoanChi) { this.tenKhoanChi = tenKhoanChi; }
    public LocalDate getNgayChi() { return ngayChi; }
    public void setNgayChi(LocalDate ngayChi) { this.ngayChi = ngayChi; }
}
