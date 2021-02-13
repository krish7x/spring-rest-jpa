package com.edu.Student.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class SkillDTO implements Serializable {
    private static final long serialVersionUID = -3247943964376280555L;
    
    private Long id;
    private String name;
    private String level;
}
