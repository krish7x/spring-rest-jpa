package com.edu.Student.service;

import com.edu.Student.dto.DepartmentDTO;
import java.util.List;

public interface DepartmentService {

    void createAndUpdate(DepartmentDTO dto);
    void delete(Long id);
    DepartmentDTO get(Long id);
    List<DepartmentDTO> getAll();
}
