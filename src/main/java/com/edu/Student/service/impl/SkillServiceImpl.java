package com.edu.Student.service.impl;

import com.edu.Student.domain.Skill;
import com.edu.Student.dto.SkillDTO;
import com.edu.Student.repository.SkillRepository;
import com.edu.Student.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;

    @Autowired
    public SkillServiceImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public void createAndUpdate(SkillDTO skillDTO) {
        Skill skill;
        if(skillDTO.getId() != null) {
            skill = skillRepository.getOne(skillDTO.getId());
        } else {
            skill = new Skill();
        }
        if(skillDTO.getName() != null ) {
            skill.setName(skillDTO.getName());
        }
        if(skillDTO.getLevel() != null ) {
            skill.setLevel(skillDTO.getLevel());
        }
        skillRepository.save(skill);
    }

    @Override
    public void delete(Long id) {
        skillRepository.deleteById(id);
    }

    @Override
    public SkillDTO get(Long id) {
        Skill skill = skillRepository.getOne(id);
        SkillDTO skillDTO = new SkillDTO();
        skillDTO.setId(skill.getId());
        skillDTO.setName(skill.getName());
        skillDTO.setLevel(skill.getLevel());
        return skillDTO;
    }

    @Override
    public List<SkillDTO> getAll() {
        List<SkillDTO> skillDTOS = new ArrayList<>();
        List<Skill> skills = skillRepository.findAll();

        for(Skill skill: skills){
            SkillDTO skillDTO = new SkillDTO();
            skillDTO.setId(skill.getId());
            skillDTO.setName(skill.getName());
            skillDTO.setLevel(skill.getLevel());
            skillDTOS.add(skillDTO);
        }
        return skillDTOS;
    }

}
