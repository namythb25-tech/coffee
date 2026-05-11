package com.example.coffee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "KhuyenMai", schema = "dbo")
public class KhuyenMai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaKhuyenMai")
    private Integer maKhuyenMai;
    @Column(name = "TenKhuyenMai", nullable = false, length = 150)
    private String tenKhuyenMai;
    @Column(name = "NgayBatDau", nullable = false)
    private LocalDate ngayBatDau;
    @Column(name = "NgayKetThuc", nullable = false)
    private LocalDate ngayKetThuc;
    @Column(name = "LoaiKhuyenMai", nullable = false, length = 50)
    private String loaiKhuyenMai;
    @Column(name = "GiaTriGiam", nullable = false)
    private Integer giaTriGiam;
    @Column(name = "TrangThai", nullable = false)
    private Integer trangThai;
    @Column(name = "MoTa", length = 500)
    private String moTa;
    public Integer getMaKhuyenMai() { return maKhuyenMai; }
    public void setMaKhuyenMai(Integer maKhuyenMai) { this.maKhuyenMai = maKhuyenMai; }
    public String getTenKhuyenMai() { return tenKhuyenMai; }
    public void setTenKhuyenMai(String tenKhuyenMai) { this.tenKhuyenMai = tenKhuyenMai; }
    public LocalDate getNgayBatDau() { return ngayBatDau; }
    public void setNgayBatDau(LocalDate ngayBatDau) { this.ngayBatDau = ngayBatDau; }
    public LocalDate getNgayKetThuc() { return ngayKetThuc; }
    public void setNgayKetThuc(LocalDate ngayKetThuc) { this.ngayKetThuc = ngayKetThuc; }
    public String getLoaiKhuyenMai() { return loaiKhuyenMai; }
    public void setLoaiKhuyenMai(String loaiKhuyenMai) { this.loaiKhuyenMai = loaiKhuyenMai; }
    public Integer getGiaTriGiam() { return giaTriGiam; }
    public void setGiaTriGiam(Integer giaTriGiam) { this.giaTriGiam = giaTriGiam; }
    public Integer getTrangThai() { return trangThai; }
    public void setTrangThai(Integer trangThai) { this.trangThai = trangThai; }
    public String getMoTa() { return moTa; }
    public void setMoTa(String moTa) { this.moTa = moTa; }
}
