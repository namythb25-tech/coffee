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
@Table(name = "DonXuat", schema = "dbo")
public class DonXuat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaDonXuat")
    private Integer maDonXuat;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaNhanVien", nullable = false)
    private NhanVien nhanVien;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaHangHoa", nullable = false)
    private HangHoa hangHoa;
    @Column(name = "TongTienXuat", nullable = false)
    private Integer tongTienXuat;
    @Column(name = "NgayXuat", nullable = false)
    private LocalDateTime ngayXuat;
    @Column(name = "SoLuong", nullable = false)
    private Integer soLuong;
    public Integer getMaDonXuat() { return maDonXuat; }
    public void setMaDonXuat(Integer maDonXuat) { this.maDonXuat = maDonXuat; }
    public NhanVien getNhanVien() { return nhanVien; }
    public void setNhanVien(NhanVien nhanVien) { this.nhanVien = nhanVien; }
    public HangHoa getHangHoa() { return hangHoa; }
    public void setHangHoa(HangHoa hangHoa) { this.hangHoa = hangHoa; }
    public Integer getTongTienXuat() { return tongTienXuat; }
    public void setTongTienXuat(Integer tongTienXuat) { this.tongTienXuat = tongTienXuat; }
    public LocalDateTime getNgayXuat() { return ngayXuat; }
    public void setNgayXuat(LocalDateTime ngayXuat) { this.ngayXuat = ngayXuat; }
    public Integer getSoLuong() { return soLuong; }
    public void setSoLuong(Integer soLuong) { this.soLuong = soLuong; }
}
