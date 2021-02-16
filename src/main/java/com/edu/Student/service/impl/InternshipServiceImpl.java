package com.edu.Student.service.impl;

import com.edu.Student.domain.Internship;
import com.edu.Student.dto.InternshipDTO;
import com.edu.Student.dto.InternshipIdentityDTO;
import com.edu.Student.repository.DepartmentRepository;
import com.edu.Student.repository.InternshipRepository;
import com.edu.Student.service.InternshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InternshipServiceImpl implements InternshipService {

    private final InternshipRepository internshipRepository;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public InternshipServiceImpl(InternshipRepository internshipRepository, DepartmentRepository departmentRepository) {
        this.internshipRepository = internshipRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public InternshipIdentityDTO createAndUpdate(InternshipDTO internshipDTO) {
        Internship internship;
        //create
        if(internshipDTO.getId() == null){
            internship = new Internship();
            internship.setId(internshipDTO.getId());
            internship.setName(internshipDTO.getName());
            internship.setDepartment(departmentRepository.getOne(internshipDTO.getDepartment().getId()));
        }
        //update
        else {
            internship = internshipRepository.getOne(internshipDTO.getDepartment().getId());
            if(internshipDTO.getName() != null){
                internship.setName(internshipDTO.getName());
            }
            if(internshipDTO.getDepartment() != null) {
                internship.setDepartment(departmentRepository.getOne(internshipDTO.getDepartment().getId()));
            }
        }
        //save
        internshipRepository.save(internship);

        //response
        InternshipIdentityDTO internshipIdentityDTO = new InternshipIdentityDTO();
        internshipIdentityDTO.setId(internship.getId());
        internshipIdentityDTO.setName(internship.getName());
        internshipIdentityDTO.setDepartment(internship.getDepartment().getName());
        return internshipIdentityDTO;
    }
}
