package org.example.dateof7nov2025.Service;

import java.util.List;

import org.example.dateof7nov2025.Entity.Lop;
import org.example.dateof7nov2025.Model.Request.LopRequest;
import org.example.dateof7nov2025.Model.Response.LopResponse;
import org.example.dateof7nov2025.Repository.LopRepository;
import org.example.dateof7nov2025.Util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LopService {
    @Autowired
    private LopRepository lopRepository;

    public List<LopResponse> getDanhSachLop() {
        return lopRepository.findAll()
                .stream()
                .map(LopResponse::new)
                .toList();
    }

    public void themLop(LopRequest lopRequest) {
        Lop lop = MapperUtil.map(lopRequest, Lop.class);
        if (lop.getMaLop().equalsIgnoreCase(lopRequest.getMaLop())) {
            throw new RuntimeException(
                    "Can not add duplicate Lop with Class ID: " + lopRequest.getMaLop());
        }
        lopRepository.save(lop);
    }

    public void xoaLop(Long id) {
        Lop lop = lopRepository.findById(id).orElseThrow(
                () -> new RuntimeException(id + " is not found")
                                                        );
        lopRepository.deleteById(id);
    }

    public LopResponse detail(Long id) {
        Lop lop = lopRepository.findById(id).orElseThrow(
                () -> new RuntimeException(id + " is not found")
                                                        );
        return new LopResponse(lop);
    }


    public void updateLop(Long id, LopRequest request) {
        Lop lop = lopRepository.findById(id).orElseThrow(
                () -> new RuntimeException(id + " is not found")
                                                        );
        MapperUtil.mapToExisting(lop, request);
        lopRepository.save(lop);
    }

    public Page<LopResponse> phanTrang(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Lop> pageProduct = lopRepository.findAll(pageable);
        Page<LopResponse> pageResponse = pageProduct.map(LopResponse::new);
        return pageResponse;
    }
}
