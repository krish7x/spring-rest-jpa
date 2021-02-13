package com.edu.Student.service;

import com.edu.Student.dto.StudentDTO;
import java.util.List;

public interface StudentService {

    void createAndUpdate(StudentDTO dto);
    void delete(Long id);
    StudentDTO get(Long id);
    List<StudentDTO> getAll();
}
