package com.edu.Student.web;

import com.edu.Student.dto.InternshipDTO;
import com.edu.Student.dto.InternshipIdentityDTO;
import com.edu.Student.service.InternshipService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/internship")
public class InternshipRestController {

    private final InternshipService internshipService;

    public InternshipRestController(InternshipService internshipService) {
        this.internshipService = internshipService;
    }

    @PostMapping("/add")
    public @ResponseBody
    InternshipIdentityDTO add(@RequestBody InternshipDTO internshipDTO){
       return internshipService.createAndUpdate(internshipDTO);
    }
}
