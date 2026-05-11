package com.example.coffee.entity;

import com.example.coffee.entity.id.ChiTietThucDonId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "ChiTietThucDon", schema = "dbo")
public class ChiTietThucDon {
    @EmbeddedId
    private ChiTietThucDonId id;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("maThucDon")
    @JoinColumn(name = "MaThucDon")
    private ThucDon thucDon;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("maHangHoa")
    @JoinColumn(name = "MaHangHoa")
    private HangHoa hangHoa;
    @Column(name = "KhoiLuong", nullable = false, precision = 18, scale = 2)
    private BigDecimal khoiLuong;
    @Column(name = "DonViTinh", nullable = false, length = 50)
    private String donViTinh;
    public ChiTietThucDonId getId() { return id; }
    public void setId(ChiTietThucDonId id) { this.id = id; }
    public ThucDon getThucDon() { return thucDon; }
    public void setThucDon(ThucDon thucDon) { this.thucDon = thucDon; }
    public HangHoa getHangHoa() { return hangHoa; }
    public void setHangHoa(HangHoa hangHoa) { this.hangHoa = hangHoa; }
    public BigDecimal getKhoiLuong() { return khoiLuong; }
    public void setKhoiLuong(BigDecimal khoiLuong) { this.khoiLuong = khoiLuong; }
    public String getDonViTinh() { return donViTinh; }
    public void setDonViTinh(String donViTinh) { this.donViTinh = donViTinh; }
}
