package com.example.coffee.entity.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ChiTietThucDonId implements Serializable {
    @Column(name = "MaThucDon")
    private Integer maThucDon;
    @Column(name = "MaHangHoa")
    private Integer maHangHoa;
    public Integer getMaThucDon() { return maThucDon; }
    public void setMaThucDon(Integer maThucDon) { this.maThucDon = maThucDon; }
    public Integer getMaHangHoa() { return maHangHoa; }
    public void setMaHangHoa(Integer maHangHoa) { this.maHangHoa = maHangHoa; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChiTietThucDonId that = (ChiTietThucDonId) o;
        return Objects.equals(maThucDon, that.maThucDon) && Objects.equals(maHangHoa, that.maHangHoa);
    }
    @Override
    public int hashCode() { return Objects.hash(maThucDon, maHangHoa); }
}
