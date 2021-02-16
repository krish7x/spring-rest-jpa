package com.edu.Student.service;

import com.edu.Student.dto.StudentDTO;
import com.edu.Student.dto.StudentIdentityDTO;

import java.util.List;

public interface StudentService {

    StudentIdentityDTO createAndUpdate(StudentDTO studentDTO);
    String delete(Long id);
    StudentIdentityDTO get(Long id);
    List<StudentIdentityDTO> getAll();
}
