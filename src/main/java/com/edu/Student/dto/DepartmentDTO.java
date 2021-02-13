package com.edu.Student.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class DepartmentDTO implements Serializable {
    private static final long serialVersionUID = -758227754356099575L;

    private Long id;
    private String name;
    private String location;

}
