package org.example.dateof7nov2025.Model.Response;

import lombok.Getter;
import lombok.Setter;
import org.example.dateof7nov2025.Entity.SinhVien;

@Getter
@Setter
public class SinhVienResponse {
    private Long id;

    private String maSv;

    private String ten;

    private Integer tuoi;

    private Boolean gioiTinh;

    public SinhVienResponse(SinhVien sinhVien) {
        this.id = sinhVien.getId();
        this.maSv = sinhVien.getMaSv();
        this.ten = sinhVien.getTen();
        this.tuoi = sinhVien.getTuoi();
        this.gioiTinh = sinhVien.getGioiTinh();
    }

}
