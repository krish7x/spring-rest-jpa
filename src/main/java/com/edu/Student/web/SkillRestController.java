package com.edu.Student.web;

import com.edu.Student.dto.IdentityDTO;
import com.edu.Student.dto.SkillDTO;
import com.edu.Student.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/skill")
public class SkillRestController {

    private final SkillService skillService;

    @Autowired
    public SkillRestController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping("/add")
    public @ResponseBody
    SkillDTO add(@RequestBody SkillDTO skillDTO) {
        return skillService.createAndUpdate(skillDTO);
    }

    @PostMapping("/update")
    public @ResponseBody
    void update(@RequestBody SkillDTO skillDTO) {
        skillService.createAndUpdate(skillDTO);
    }

    @PostMapping("/delete")
    public @ResponseBody
    String delete(@RequestBody IdentityDTO identityDTO) {
        return skillService.delete(identityDTO.getId());
    }

    @PostMapping("/get")
    public @ResponseBody
    SkillDTO get(@RequestBody IdentityDTO identityDTO) {
        return skillService.get(identityDTO.getId());
    }

    @PostMapping("/get-all")
    public @ResponseBody
    List<SkillDTO> getAll() {
        return skillService.getAll();
    }
}

