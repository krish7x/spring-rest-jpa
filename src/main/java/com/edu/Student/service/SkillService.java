package com.edu.Student.service;

import com.edu.Student.dto.SkillDTO;
import java.util.List;

public interface SkillService {

    void createAndUpdate(SkillDTO dto);
    void delete(Long id);
    SkillDTO get(Long id);
    List<SkillDTO> getAll();
}
