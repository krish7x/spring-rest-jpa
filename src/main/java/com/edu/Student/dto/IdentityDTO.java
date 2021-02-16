package com.edu.Student.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class LongIdentityDTO implements Serializable {
    private static final long serialVersionUID = 8808215286285893892L;

    private Long id;
}
