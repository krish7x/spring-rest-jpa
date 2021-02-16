package com.edu.Student.service;

import com.edu.Student.dto.DepartmentDTO;
import java.util.List;

public interface DepartmentService {

    DepartmentDTO createAndUpdate(DepartmentDTO dto);
    String delete(Long id);
    DepartmentDTO get(Long id);
    List<DepartmentDTO> getAll();
}
