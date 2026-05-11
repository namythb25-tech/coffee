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
@Table(name = "DonNhap", schema = "dbo")
public class DonNhap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaDonNhap")
    private Integer maDonNhap;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaNhanVien", nullable = false)
    private NhanVien nhanVien;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaThietBi")
    private ThietBi thietBi;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaHangHoa")
    private HangHoa hangHoa;
    @Column(name = "NgayNhap", nullable = false)
    private LocalDateTime ngayNhap;
    @Column(name = "TongTien", nullable = false)
    private Integer tongTien;
    @Column(name = "SoLuong", nullable = false)
    private Integer soLuong;
    public Integer getMaDonNhap() { return maDonNhap; }
    public void setMaDonNhap(Integer maDonNhap) { this.maDonNhap = maDonNhap; }
    public NhanVien getNhanVien() { return nhanVien; }
    public void setNhanVien(NhanVien nhanVien) { this.nhanVien = nhanVien; }
    public ThietBi getThietBi() { return thietBi; }
    public void setThietBi(ThietBi thietBi) { this.thietBi = thietBi; }
    public HangHoa getHangHoa() { return hangHoa; }
    public void setHangHoa(HangHoa hangHoa) { this.hangHoa = hangHoa; }
    public LocalDateTime getNgayNhap() { return ngayNhap; }
    public void setNgayNhap(LocalDateTime ngayNhap) { this.ngayNhap = ngayNhap; }
    public Integer getTongTien() { return tongTien; }
    public void setTongTien(Integer tongTien) { this.tongTien = tongTien; }
    public Integer getSoLuong() { return soLuong; }
    public void setSoLuong(Integer soLuong) { this.soLuong = soLuong; }
}
