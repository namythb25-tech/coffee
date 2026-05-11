package com.example.coffee.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class NhanVienForm {
    private Integer maNhanVien;

    @NotNull(message = "Vui lòng chọn chức vụ.")
    private Integer maChucVu;

    @NotBlank(message = "Vui lòng nhập họ tên.")
    @Size(max = 30, message = "Họ tên tối đa 30 ký tự.")
    private String hoTen;

    @NotBlank(message = "Vui lòng nhập số điện thoại.")
    @Size(max = 15, message = "Số điện thoại tối đa 15 ký tự.")
    private String soDienThoai;

    @Size(max = 50, message = "Địa chỉ tối đa 50 ký tự.")
    private String diaChi;

    private boolean taoTaiKhoan;

    @Size(max = 20, message = "Tên đăng nhập tối đa 20 ký tự.")
    private String tenDangNhap;

    @Size(max = 20, message = "Mật khẩu tối đa 20 ký tự.")
    private String matKhau;

    private String quyenHan;

    public Integer getMaNhanVien() { return maNhanVien; }
    public void setMaNhanVien(Integer maNhanVien) { this.maNhanVien = maNhanVien; }
    public Integer getMaChucVu() { return maChucVu; }
    public void setMaChucVu(Integer maChucVu) { this.maChucVu = maChucVu; }
    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }
    public String getSoDienThoai() { return soDienThoai; }
    public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; }
    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }
    public boolean isTaoTaiKhoan() { return taoTaiKhoan; }
    public void setTaoTaiKhoan(boolean taoTaiKhoan) { this.taoTaiKhoan = taoTaiKhoan; }
    public String getTenDangNhap() { return tenDangNhap; }
    public void setTenDangNhap(String tenDangNhap) { this.tenDangNhap = tenDangNhap; }
    public String getMatKhau() { return matKhau; }
    public void setMatKhau(String matKhau) { this.matKhau = matKhau; }
    public String getQuyenHan() { return quyenHan; }
    public void setQuyenHan(String quyenHan) { this.quyenHan = quyenHan; }
}
