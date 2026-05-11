package com.example.coffee.controller;

import com.example.coffee.dto.NhanVienForm;
import com.example.coffee.service.NhanVienService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmployeeController {
    private final NhanVienService nhanVienService;

    public EmployeeController(NhanVienService nhanVienService) {
        this.nhanVienService = nhanVienService;
    }

    @GetMapping("/employees")
    public String list(@RequestParam(required = false) String keyword, Model model, HttpSession session) {
        if (!laQuanLy(session)) {
            return chanQuyen(model, session);
        }
        addSession(model, session);
        model.addAttribute("pageTitle", "Quản lý nhân viên");
        model.addAttribute("employees", nhanVienService.danhSach(keyword));
        model.addAttribute("keyword", keyword);
        return "employees/list";
    }

    @GetMapping("/employees/new")
    public String createForm(Model model, HttpSession session) {
        if (!laQuanLy(session)) {
            return chanQuyen(model, session);
        }
        addFormData(model, session, nhanVienService.taoFormMoi(), "Thêm nhân viên", true);
        return "employees/form";
    }

    @PostMapping("/employees")
    public String create(@Valid @ModelAttribute("employeeForm") NhanVienForm form, BindingResult bindingResult,
            Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        if (!laQuanLy(session)) {
            return chanQuyen(model, session);
        }
        nhanVienService.kiemTraTaiKhoan(form, true, bindingResult);
        if (bindingResult.hasErrors()) {
            addFormData(model, session, form, "Thêm nhân viên", true);
            return "employees/form";
        }
        try {
            nhanVienService.them(form);
            redirectAttributes.addFlashAttribute("success", "Thêm nhân viên thành công.");
            return "redirect:/employees";
        } catch (IllegalArgumentException ex) {
            addFormData(model, session, form, "Thêm nhân viên", true);
            model.addAttribute("error", ex.getMessage());
            return "employees/form";
        }
    }

    @GetMapping("/employees/{id}/edit")
    public String editForm(@PathVariable Integer id, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        if (!laQuanLy(session)) {
            return chanQuyen(model, session);
        }
        try {
            addFormData(model, session, nhanVienService.taoFormSua(id), "Sửa nhân viên", false);
            return "employees/form";
        } catch (IllegalArgumentException ex) {
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
            return "redirect:/employees";
        }
    }

    @PostMapping("/employees/{id}")
    public String update(@PathVariable Integer id, @Valid @ModelAttribute("employeeForm") NhanVienForm form,
            BindingResult bindingResult, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        if (!laQuanLy(session)) {
            return chanQuyen(model, session);
        }
        if (bindingResult.hasErrors()) {
            form.setMaNhanVien(id);
            addFormData(model, session, form, "Sửa nhân viên", false);
            return "employees/form";
        }
        try {
            nhanVienService.sua(id, form);
            redirectAttributes.addFlashAttribute("success", "Cập nhật nhân viên thành công.");
            return "redirect:/employees";
        } catch (IllegalArgumentException ex) {
            form.setMaNhanVien(id);
            addFormData(model, session, form, "Sửa nhân viên", false);
            model.addAttribute("error", ex.getMessage());
            return "employees/form";
        }
    }

    @PostMapping("/employees/{id}/delete")
    public String delete(@PathVariable Integer id, HttpSession session, Model model, RedirectAttributes redirectAttributes) {
        if (!laQuanLy(session)) {
            return chanQuyen(model, session);
        }
        try {
            nhanVienService.xoa(id);
            redirectAttributes.addFlashAttribute("success", "Xóa nhân viên thành công.");
        } catch (IllegalStateException ex) {
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
        }
        return "redirect:/employees";
    }

    private void addFormData(Model model, HttpSession session, NhanVienForm form, String pageTitle, boolean createMode) {
        addSession(model, session);
        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("employeeForm", form);
        model.addAttribute("chucVus", nhanVienService.danhSachChucVu());
        model.addAttribute("createMode", createMode);
    }

    private boolean laQuanLy(HttpSession session) {
        return session.getAttribute(AuthController.CURRENT_USER_ID) != null
                && "Quản lý".equals(session.getAttribute(AuthController.CURRENT_ROLE));
    }

    private String chanQuyen(Model model, HttpSession session) {
        if (session.getAttribute(AuthController.CURRENT_USER_ID) == null) {
            return "redirect:/login";
        }
        addSession(model, session);
        model.addAttribute("pageTitle", "Không có quyền");
        return "home";
    }

    private void addSession(Model model, HttpSession session) {
        model.addAttribute("currentUsername", session.getAttribute(AuthController.CURRENT_USERNAME));
        model.addAttribute("currentRole", session.getAttribute(AuthController.CURRENT_ROLE));
    }
}
