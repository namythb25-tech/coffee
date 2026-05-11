package com.example.coffee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "NhanVien", schema = "dbo")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaNhanVien")
    private Integer maNhanVien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaChucVu", nullable = false)
    private ChucVu chucVu;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaTaiKhoan", unique = true)
    private TaiKhoan taiKhoan;

    @Column(name = "HoTen", nullable = false, length = 150)
    private String hoTen;

    @Column(name = "SoDienThoai", nullable = false, length = 20)
    private String soDienThoai;

    @Column(name = "DiaChi", length = 255)
    private String diaChi;

    public Integer getMaNhanVien() { return maNhanVien; }
    public void setMaNhanVien(Integer maNhanVien) { this.maNhanVien = maNhanVien; }
    public ChucVu getChucVu() { return chucVu; }
    public void setChucVu(ChucVu chucVu) { this.chucVu = chucVu; }
    public TaiKhoan getTaiKhoan() { return taiKhoan; }
    public void setTaiKhoan(TaiKhoan taiKhoan) { this.taiKhoan = taiKhoan; }
    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }
    public String getSoDienThoai() { return soDienThoai; }
    public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; }
    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }
}
