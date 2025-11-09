package org.example.dateof7nov2025.Service;

import java.util.List;

import org.example.dateof7nov2025.Entity.SinhVien;
import org.example.dateof7nov2025.Model.Request.SinhVienRequest;
import org.example.dateof7nov2025.Model.Response.SinhVienResponse;
import org.example.dateof7nov2025.Repository.SinhVienRepository;
import org.example.dateof7nov2025.Util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SinhVienService {
    @Autowired
    private SinhVienRepository sinhVienRepository;

    public List<SinhVienResponse> getDanhSachSinhVien() {
        return sinhVienRepository.findAll()
                .stream()
                .map(SinhVienResponse::new)
                .toList();
    }

    public void themSinhVien(SinhVienRequest request) {
        SinhVien sinhVien = MapperUtil.map(request, SinhVien.class);
        if (sinhVien.getMaSv().equalsIgnoreCase(request.getMaSv())) {
            throw new RuntimeException(
                    "Can not add duplicate with Student ID: " + request.getMaSv());
        }
        sinhVienRepository.save(sinhVien);
    }

    public void removeSinhVien(Long id) {
        sinhVienRepository.findById(id).orElseThrow(
                () -> new RuntimeException(id + " is not exist")
                                                   );
        sinhVienRepository.deleteById(id);
    }

    public SinhVienResponse detailSinhVien(Long id) {
        SinhVien sinhVien = sinhVienRepository.findById(id).orElseThrow(
                () -> new RuntimeException(id + " is not exist")
                                                                       );
        return new SinhVienResponse(sinhVien);
    }

    public void updateSinhVien(Long id, SinhVienRequest request) {
        SinhVien sinhVien = sinhVienRepository.findById(id).orElseThrow(
                () -> new RuntimeException(id + " not found")
                                                                       );
        MapperUtil.mapToExisting(request, sinhVien);
        sinhVienRepository.save(sinhVien);
    }

    public Page<SinhVienResponse> phanTrang(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<SinhVien> pageProduct = sinhVienRepository.findAll(pageable);
        // map tu Product => Product Response
        Page<SinhVienResponse> pageResponse = pageProduct.map(SinhVienResponse::new);
        return pageResponse;
    }
}
