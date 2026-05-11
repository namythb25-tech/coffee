package com.example.coffee.entity.id;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Embeddable;

@Embeddable
public class ChiTietDatBanId implements Serializable {
    private Integer maBan;
    private Integer maNhanVien;
    private Integer maHoaDon;

    public Integer getMaBan() { return maBan; }
    public void setMaBan(Integer maBan) { this.maBan = maBan; }

    public Integer getMaNhanVien() { return maNhanVien; }
    public void setMaNhanVien(Integer maNhanVien) { this.maNhanVien = maNhanVien; }

    public Integer getMaHoaDon() { return maHoaDon; }
    public void setMaHoaDon(Integer maHoaDon) { this.maHoaDon = maHoaDon; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChiTietDatBanId that = (ChiTietDatBanId) o;
        return Objects.equals(maBan, that.maBan) && Objects.equals(maNhanVien, that.maNhanVien) && Objects.equals(maHoaDon, that.maHoaDon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maBan, maNhanVien, maHoaDon);
    }
}
