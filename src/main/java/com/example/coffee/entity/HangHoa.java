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

@Entity
@Table(name = "HangHoa", schema = "dbo")
public class HangHoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaHangHoa")
    private Integer maHangHoa;
    @Column(name = "TenHangHoa", nullable = false, length = 150)
    private String tenHangHoa;
    @Column(name = "SoLuong", nullable = false)
    private Integer soLuong;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaDonViTinh", nullable = false)
    private DonViTinh donViTinh;
    @Column(name = "DonGia", nullable = false)
    private Integer donGia;
    public Integer getMaHangHoa() { return maHangHoa; }
    public void setMaHangHoa(Integer maHangHoa) { this.maHangHoa = maHangHoa; }
    public String getTenHangHoa() { return tenHangHoa; }
    public void setTenHangHoa(String tenHangHoa) { this.tenHangHoa = tenHangHoa; }
    public Integer getSoLuong() { return soLuong; }
    public void setSoLuong(Integer soLuong) { this.soLuong = soLuong; }
    public DonViTinh getDonViTinh() { return donViTinh; }
    public void setDonViTinh(DonViTinh donViTinh) { this.donViTinh = donViTinh; }
    public Integer getDonGia() { return donGia; }
    public void setDonGia(Integer donGia) { this.donGia = donGia; }
}
