package com.edu.Student.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudentIdentityDTO implements Serializable {
    private static final long serialVersionUID = -7348648322862429874L;

    private Long id;
    private String name;
    private String Department;
}
