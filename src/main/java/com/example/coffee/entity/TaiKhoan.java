package com.example.coffee.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "TaiKhoan", schema = "dbo")
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaTaiKhoan")
    private Integer maTaiKhoan;

    @Column(name = "TenDangNhap", nullable = false, unique = true, length = 100)
    private String tenDangNhap;

    @Column(name = "MatKhau", nullable = false, length = 255)
    private String matKhau;

    @Column(name = "QuyenHan", nullable = false, length = 50)
    private String quyenHan;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "Anh")
    private byte[] anh;

    public Integer getMaTaiKhoan() { return maTaiKhoan; }
    public void setMaTaiKhoan(Integer maTaiKhoan) { this.maTaiKhoan = maTaiKhoan; }
    public String getTenDangNhap() { return tenDangNhap; }
    public void setTenDangNhap(String tenDangNhap) { this.tenDangNhap = tenDangNhap; }
    public String getMatKhau() { return matKhau; }
    public void setMatKhau(String matKhau) { this.matKhau = matKhau; }
    public String getQuyenHan() { return quyenHan; }
    public void setQuyenHan(String quyenHan) { this.quyenHan = quyenHan; }
    public byte[] getAnh() { return anh; }
    public void setAnh(byte[] anh) { this.anh = anh; }
}
