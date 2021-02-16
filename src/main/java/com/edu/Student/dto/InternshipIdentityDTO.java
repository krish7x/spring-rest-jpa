package com.edu.Student.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class InternshipIdentityDTO implements Serializable {
    private static final long serialVersionUID = -61230362056393592L;

    private Long id;
    private String name;
    private String department;
}
