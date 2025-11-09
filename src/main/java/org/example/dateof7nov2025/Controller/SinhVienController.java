package org.example.dateof7nov2025.Controller;

import java.util.List;

import jakarta.validation.Valid;
import org.example.dateof7nov2025.Model.Request.SinhVienRequest;
import org.example.dateof7nov2025.Model.Response.SinhVienResponse;
import org.example.dateof7nov2025.Service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sinh-vien")
public class SinhVienController {
    @Autowired
    private SinhVienService sinhVienService;

    @GetMapping
    public List<SinhVienResponse> getSinhVienList() {
        return sinhVienService.getDanhSachSinhVien();
    }

    @PostMapping("add")
    public void addSinhVien(@Valid @RequestBody SinhVienRequest request) {
        sinhVienService.themSinhVien(request);
    }

    @DeleteMapping
    public void deleteSinhVien(@Valid @RequestParam("id") Long id) {
        sinhVienService.removeSinhVien(id);
    }

    @GetMapping("detail")
    public SinhVienResponse getSinhVienDetail(@Valid @RequestParam("id") Long id) {
        return sinhVienService.detailSinhVien(id);
    }

    @PutMapping("edit")
    public ResponseEntity<?> updateSinhVien(
            @Valid @RequestParam("id") Long id,
            @RequestBody SinhVienRequest request) {
        sinhVienService.updateSinhVien(id, request);
        return ResponseEntity.ok().build();
    }

    // Phan trang
    @GetMapping("paging")
    public List<SinhVienResponse> phanTrang(@RequestParam("pageNo") Integer pageNo,
                                            @RequestParam("pageSize") Integer pageSize) {
        return sinhVienService.phanTrang(pageNo, pageSize).getContent();
    }
}
