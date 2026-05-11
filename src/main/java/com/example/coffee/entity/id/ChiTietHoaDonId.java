package com.example.coffee.entity.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ChiTietHoaDonId implements Serializable {
    @Column(name = "MaHoaDon")
    private Integer maHoaDon;
    @Column(name = "MaThucDon")
    private Integer maThucDon;
    public Integer getMaHoaDon() { return maHoaDon; }
    public void setMaHoaDon(Integer maHoaDon) { this.maHoaDon = maHoaDon; }
    public Integer getMaThucDon() { return maThucDon; }
    public void setMaThucDon(Integer maThucDon) { this.maThucDon = maThucDon; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChiTietHoaDonId that = (ChiTietHoaDonId) o;
        return Objects.equals(maHoaDon, that.maHoaDon) && Objects.equals(maThucDon, that.maThucDon);
    }
    @Override
    public int hashCode() { return Objects.hash(maHoaDon, maThucDon); }
}
