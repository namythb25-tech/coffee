package com.example.coffee.service;

import com.example.coffee.dto.NhanVienForm;
import com.example.coffee.entity.ChucVu;
import com.example.coffee.entity.NhanVien;
import com.example.coffee.entity.TaiKhoan;
import com.example.coffee.repository.ChucVuRepository;
import com.example.coffee.repository.NhanVienRepository;
import com.example.coffee.repository.TaiKhoanRepository;
import java.util.List;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

@Service
public class NhanVienService {
    private final NhanVienRepository nhanVienRepository;
    private final ChucVuRepository chucVuRepository;
    private final TaiKhoanRepository taiKhoanRepository;

    public NhanVienService(NhanVienRepository nhanVienRepository, ChucVuRepository chucVuRepository, TaiKhoanRepository taiKhoanRepository) {
        this.nhanVienRepository = nhanVienRepository;
        this.chucVuRepository = chucVuRepository;
        this.taiKhoanRepository = taiKhoanRepository;
    }

    public List<NhanVien> danhSach(String keyword) {
        if (isBlank(keyword)) {
            return nhanVienRepository.findAll();
        }
        String value = keyword.trim();
        return nhanVienRepository.findByHoTenContainingIgnoreCaseOrSoDienThoaiContainingIgnoreCase(value, value);
    }

    public List<ChucVu> danhSachChucVu() {
        return chucVuRepository.findAll();
    }

    public NhanVien layNhanVien(Integer id) {
        return nhanVienRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy nhân viên"));
    }

    public NhanVienForm taoFormMoi() {
        NhanVienForm form = new NhanVienForm();
        form.setQuyenHan("Nhân viên");
        return form;
    }

    public NhanVienForm taoFormSua(Integer id) {
        NhanVien nhanVien = layNhanVien(id);
        NhanVienForm form = new NhanVienForm();
        form.setMaNhanVien(nhanVien.getMaNhanVien());
        form.setHoTen(nhanVien.getHoTen());
        form.setSoDienThoai(nhanVien.getSoDienThoai());
        form.setDiaChi(nhanVien.getDiaChi());
        form.setMaChucVu(nhanVien.getChucVu().getMaChucVu());
        return form;
    }

    @Transactional
    public void them(NhanVienForm form) {
        NhanVien nhanVien = new NhanVien();
        ganDuLieu(nhanVien, form);
        if (form.isTaoTaiKhoan()) {
            nhanVien.setTaiKhoan(taoTaiKhoan(form));
        }
        nhanVienRepository.save(nhanVien);
    }

    @Transactional
    public void sua(Integer id, NhanVienForm form) {
        NhanVien nhanVien = layNhanVien(id);
        ganDuLieu(nhanVien, form);
        nhanVienRepository.save(nhanVien);
    }

    @Transactional
    public void xoa(Integer id) {
        try {
            nhanVienRepository.deleteById(id);
            nhanVienRepository.flush();
        } catch (DataIntegrityViolationException ex) {
            throw new IllegalStateException("Không thể xóa nhân viên vì đã có dữ liệu liên quan.");
        }
    }

    private void ganDuLieu(NhanVien nhanVien, NhanVienForm form) {
        ChucVu chucVu = chucVuRepository.findById(form.getMaChucVu()).orElseThrow(() -> new IllegalArgumentException("Vui lòng chọn chức vụ"));
        nhanVien.setHoTen(form.getHoTen().trim());
        nhanVien.setSoDienThoai(form.getSoDienThoai().trim());
        nhanVien.setDiaChi(isBlank(form.getDiaChi()) ? null : form.getDiaChi().trim());
        nhanVien.setChucVu(chucVu);
    }

    private TaiKhoan taoTaiKhoan(NhanVienForm form) {
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setTenDangNhap(form.getTenDangNhap().trim());
        taiKhoan.setMatKhau(form.getMatKhau().trim());
        taiKhoan.setQuyenHan(isBlank(form.getQuyenHan()) ? "Nhân viên" : form.getQuyenHan().trim());
        return taiKhoanRepository.save(taiKhoan);
    }

    public void kiemTraTaiKhoan(NhanVienForm form, boolean choPhepTaoTaiKhoan, BindingResult bindingResult) {
        if (!choPhepTaoTaiKhoan || !form.isTaoTaiKhoan()) {
            return;
        }
        if (isBlank(form.getTenDangNhap())) {
            bindingResult.rejectValue("tenDangNhap", "tenDangNhap.required", "Vui lòng nhập tên đăng nhập.");
        } else if (taiKhoanRepository.existsByTenDangNhap(form.getTenDangNhap().trim())) {
            bindingResult.rejectValue("tenDangNhap", "tenDangNhap.exists", "Tên đăng nhập đã tồn tại.");
        }
        if (isBlank(form.getMatKhau())) {
            bindingResult.rejectValue("matKhau", "matKhau.required", "Vui lòng nhập mật khẩu.");
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
