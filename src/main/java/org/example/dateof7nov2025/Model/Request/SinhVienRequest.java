package org.example.dateof7nov2025.Model.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SinhVienRequest {
    @NotBlank(message = "Student ID can not blank")
    private String maSv;

    @NotBlank(message = "Name can not blank")
    private String ten;

    private Integer tuoi;

    private Boolean gioiTinh = false;
}
