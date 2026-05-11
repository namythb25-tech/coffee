package com.example.coffee.entity;

import com.example.coffee.entity.id.ChiTietDatBanId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "ChiTietDatBan", schema = "dbo")
public class ChiTietDatBan {
    @EmbeddedId
    private ChiTietDatBanId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("maBan")
    @JoinColumn(name = "MaBan")
    private Ban ban;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("maNhanVien")
    @JoinColumn(name = "MaNhanVien")
    private NhanVien nhanVien;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("maHoaDon")
    @JoinColumn(name = "MaHoaDon")
    private HoaDon hoaDon;

    @Column(name = "TenKhachHang", nullable = false, length = 150)
    private String tenKhachHang;

    @Column(name = "SdtKhachHang", length = 20)
    private String sdtKhachHang;

    @Column(name = "NgayGioDat", nullable = false)
    private LocalDateTime ngayGioDat;

    public ChiTietDatBanId getId() { return id; }
    public void setId(ChiTietDatBanId id) { this.id = id; }

    public Ban getBan() { return ban; }
    public void setBan(Ban ban) { this.ban = ban; }

    public NhanVien getNhanVien() { return nhanVien; }
    public void setNhanVien(NhanVien nhanVien) { this.nhanVien = nhanVien; }

    public HoaDon getHoaDon() { return hoaDon; }
    public void setHoaDon(HoaDon hoaDon) { this.hoaDon = hoaDon; }

    public String getTenKhachHang() { return tenKhachHang; }
    public void setTenKhachHang(String tenKhachHang) { this.tenKhachHang = tenKhachHang; }

    public String getSdtKhachHang() { return sdtKhachHang; }
    public void setSdtKhachHang(String sdtKhachHang) { this.sdtKhachHang = sdtKhachHang; }

    public LocalDateTime getNgayGioDat() { return ngayGioDat; }
    public void setNgayGioDat(LocalDateTime ngayGioDat) { this.ngayGioDat = ngayGioDat; }
}
