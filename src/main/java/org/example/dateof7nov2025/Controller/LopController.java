package org.example.dateof7nov2025.Controller;

import java.util.List;

import jakarta.validation.Valid;
import org.example.dateof7nov2025.Model.Request.LopRequest;
import org.example.dateof7nov2025.Model.Response.LopResponse;
import org.example.dateof7nov2025.Repository.LopRepository;
import org.example.dateof7nov2025.Service.LopService;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lop")
public class LopController {
    @Autowired
    private LopService lopService;
    @Autowired
    private LopRepository lopRepository;

    @GetMapping
    public List<LopResponse> getAllLops() {
        return lopService.getDanhSachLop();
    }

    @PostMapping("add")
    public void saveLop(@Valid @RequestBody LopRequest lopRequest) {
        lopService.themLop(lopRequest);
    }

    @PutMapping("edit")
    public ResponseEntity<?> updateLop(@Valid @RequestParam("id") Long id,
                                       @RequestBody LopRequest request) {
        lopService.updateLop(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public void deleteLop(@Valid @RequestParam("id") Long id) {
        lopService.xoaLop(id);
    }

    @GetMapping("detail")
    public LopResponse detailLop(@RequestParam("id") Long id) {
        return lopService.detail(id);
    }

    @GetMapping("paging")
    public List<LopResponse> phanTrang(@RequestParam("pageNo") Integer pageNo,
                                       @RequestParam("pageSize") Integer pageSize) {
        return lopService.phanTrang(pageNo, pageSize).getContent();
    }
}
