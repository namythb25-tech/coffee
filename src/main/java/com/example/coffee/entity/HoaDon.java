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
import java.time.LocalDateTime;

@Entity
@Table(name = "HoaDon", schema = "dbo")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaHoaDon")
    private Integer maHoaDon;
    @Column(name = "TongTien", nullable = false)
    private Integer tongTien;
    @Column(name = "NgayGioTao", nullable = false)
    private LocalDateTime ngayGioTao;
    @Column(name = "TrangThai", nullable = false)
    private Integer trangThai;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaKhuyenMai")
    private KhuyenMai khuyenMai;
    public Integer getMaHoaDon() { return maHoaDon; }
    public void setMaHoaDon(Integer maHoaDon) { this.maHoaDon = maHoaDon; }
    public Integer getTongTien() { return tongTien; }
    public void setTongTien(Integer tongTien) { this.tongTien = tongTien; }
    public LocalDateTime getNgayGioTao() { return ngayGioTao; }
    public void setNgayGioTao(LocalDateTime ngayGioTao) { this.ngayGioTao = ngayGioTao; }
    public Integer getTrangThai() { return trangThai; }
    public void setTrangThai(Integer trangThai) { this.trangThai = trangThai; }
    public KhuyenMai getKhuyenMai() { return khuyenMai; }
    public void setKhuyenMai(KhuyenMai khuyenMai) { this.khuyenMai = khuyenMai; }
}
