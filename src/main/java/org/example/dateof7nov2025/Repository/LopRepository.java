package org.example.dateof7nov2025.Repository;

import jakarta.validation.constraints.NotBlank;
import org.example.dateof7nov2025.Entity.Lop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LopRepository extends JpaRepository<Lop, Long> {
//    boolean existsByClassID(String maLop);
}
