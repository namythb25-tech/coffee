package com.example.coffee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "ThietBi", schema = "dbo")
public class ThietBi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaThietBi")
    private Integer maThietBi;
    @Column(name = "TenThietBi", nullable = false, length = 150)
    private String tenThietBi;
    @Column(name = "SoLuong", nullable = false)
    private Integer soLuong;
    @Column(name = "GhiChu", length = 500)
    private String ghiChu;
    @Column(name = "NgayMua", nullable = false)
    private LocalDate ngayMua;
    @Column(name = "DonGiaMua", nullable = false)
    private Integer donGiaMua;
    public Integer getMaThietBi() { return maThietBi; }
    public void setMaThietBi(Integer maThietBi) { this.maThietBi = maThietBi; }
    public String getTenThietBi() { return tenThietBi; }
    public void setTenThietBi(String tenThietBi) { this.tenThietBi = tenThietBi; }
    public Integer getSoLuong() { return soLuong; }
    public void setSoLuong(Integer soLuong) { this.soLuong = soLuong; }
    public String getGhiChu() { return ghiChu; }
    public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; }
    public LocalDate getNgayMua() { return ngayMua; }
    public void setNgayMua(LocalDate ngayMua) { this.ngayMua = ngayMua; }
    public Integer getDonGiaMua() { return donGiaMua; }
    public void setDonGiaMua(Integer donGiaMua) { this.donGiaMua = donGiaMua; }
}
