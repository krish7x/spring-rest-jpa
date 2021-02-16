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
    public SkillDTO createAndUpdate(SkillDTO skillDTO) {
        Skill skill;
        //create
        if(skillDTO.getId() == null) {
            skill = new Skill();
            skill.setName(skillDTO.getName());
            skill.setLevel(skillDTO.getLevel());
        }
        //update
        else {
            skill = skillRepository.getOne(skillDTO.getId());
            if(skillDTO.getName() != null ) {
                skill.setName(skillDTO.getName());
            }
            if(skillDTO.getLevel() != null ) {
                skill.setLevel(skillDTO.getLevel());
            }
        }
        //save
        skillRepository.save(skill);
        //set up id
        skillDTO.setId(skill.getId());
        //response
        return skillDTO;
    }

    @Override
    public String delete(Long id) {
        //check if record exists
        if(skillRepository.findById(id).isPresent()){
            skillRepository.deleteById(id);
            //success response
            return "Deleted Successfully!";
        }
        //failure response
        return "Deletion Unsuccessful!";
    }

    @Override
    public SkillDTO get(Long id) {
        //get entity values from repository
        Skill skill = skillRepository.getOne(id);
        //instance of DTO
        SkillDTO skillDTO = new SkillDTO();
        //set up DTO
        skillDTO.setId(skill.getId());
        skillDTO.setName(skill.getName());
        skillDTO.setLevel(skill.getLevel());
        //response
        return skillDTO;
    }

    @Override
    public List<SkillDTO> getAll() {
        //To print all the DTOs in a list
        List<SkillDTO> skillDTOS = new ArrayList<>();
        //get all the entity values of repository in a list
        List<Skill> skills = skillRepository.findAll();
        //loop through entity
        for(Skill skill: skills){
            //instance of DTO
            SkillDTO skillDTO = new SkillDTO();
            //set up DTO
            skillDTO.setId(skill.getId());
            skillDTO.setName(skill.getName());
            skillDTO.setLevel(skill.getLevel());
            //add one DTO in a list of DTOs
            skillDTOS.add(skillDTO);
        }
        //response
        return skillDTOS;
    }
}
