package com.edu.Student.service.impl;

import com.edu.Student.domain.Internship;
import com.edu.Student.dto.InternshipDTO;
import com.edu.Student.repository.InternshipRepository;
import com.edu.Student.service.InternshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InternshipServiceImpl implements InternshipService {

    private final InternshipRepository internshipRepository;

    @Autowired
    public InternshipServiceImpl(InternshipRepository internshipRepository) {
        this.internshipRepository = internshipRepository;
    }

    @Override
    public void createAndUpdate(InternshipDTO internshipDTO) {
        Internship internship;
        if(internshipDTO.getId() == null){
            internship = new Internship();
            internship.setId(internshipDTO.getId());
            internship.setName(internshipDTO.getName());
           ;
        } else {
            internship = internshipRepository.getOne(internshipDTO.getId());
            if(internshipDTO.getName() != null){
                internship.setName(internshipDTO.getName());
            }
        }
        internshipRepository.save(internship);
    }
}
