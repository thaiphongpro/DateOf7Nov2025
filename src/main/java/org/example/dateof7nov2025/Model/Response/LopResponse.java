package org.example.dateof7nov2025.Model.Response;

import lombok.Getter;
import lombok.Setter;
import org.example.dateof7nov2025.Entity.Lop;

@Getter
@Setter
public class LopResponse {
    private Long id;

    private String maLop;

    private String ten;

    public LopResponse(Lop lop) {
        this.id = lop.getId();
        this.maLop = lop.getMaLop();
        this.ten = lop.getTen();
    }
}
