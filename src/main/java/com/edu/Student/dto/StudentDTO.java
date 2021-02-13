package com.edu.Student.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class StudentDTO implements Serializable {
    private static final long serialVersionUID = 2870631332920111106L;

    private Long id;
    private String name;
    private String dept;
}
