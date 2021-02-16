package com.edu.Student.service;

import com.edu.Student.dto.SkillDTO;
import java.util.List;

public interface SkillService {

    SkillDTO createAndUpdate(SkillDTO dto);
    String delete(Long id);
    SkillDTO get(Long id);
    List<SkillDTO> getAll();
}
