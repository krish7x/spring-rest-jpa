package com.edu.Student.dto;

import com.edu.Student.domain.Department;
import lombok.Data;
import java.io.Serializable;

@Data
public class InternshipDTO implements Serializable {

    private static final long serialVersionUID = -2525699143670769457L;

    private Long id;
    private String name;
}
