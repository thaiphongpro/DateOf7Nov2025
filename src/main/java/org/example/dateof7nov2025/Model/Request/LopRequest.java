package org.example.dateof7nov2025.Model.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LopRequest {
    @NotBlank(message = "Class ID can not blank")
    private String maLop;;

    @NotBlank(message = "Class name can not blank")
    private String ten;

}
