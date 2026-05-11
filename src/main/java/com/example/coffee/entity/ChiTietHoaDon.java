package com.example.coffee.entity;

import com.example.coffee.entity.id.ChiTietHoaDonId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "ChiTietHoaDon", schema = "dbo")
public class ChiTietHoaDon {
    @EmbeddedId
    private ChiTietHoaDonId id;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("maHoaDon")
    @JoinColumn(name = "MaHoaDon")
    private HoaDon hoaDon;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("maThucDon")
    @JoinColumn(name = "MaThucDon")
    private ThucDon thucDon;
    @Column(name = "SoLuong", nullable = false)
    private Integer soLuong;
    @Column(name = "GiaTaiThoiDiemBan", nullable = false)
    private Integer giaTaiThoiDiemBan;
    @Column(name = "ThanhTien", nullable = false)
    private Integer thanhTien;
    public ChiTietHoaDonId getId() { return id; }
    public void setId(ChiTietHoaDonId id) { this.id = id; }
    public HoaDon getHoaDon() { return hoaDon; }
    public void setHoaDon(HoaDon hoaDon) { this.hoaDon = hoaDon; }
    public ThucDon getThucDon() { return thucDon; }
    public void setThucDon(ThucDon thucDon) { this.thucDon = thucDon; }
    public Integer getSoLuong() { return soLuong; }
    public void setSoLuong(Integer soLuong) { this.soLuong = soLuong; }
    public Integer getGiaTaiThoiDiemBan() { return giaTaiThoiDiemBan; }
    public void setGiaTaiThoiDiemBan(Integer giaTaiThoiDiemBan) { this.giaTaiThoiDiemBan = giaTaiThoiDiemBan; }
    public Integer getThanhTien() { return thanhTien; }
    public void setThanhTien(Integer thanhTien) { this.thanhTien = thanhTien; }
}
