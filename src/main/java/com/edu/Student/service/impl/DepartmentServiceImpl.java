package com.edu.Student.service.impl;

import com.edu.Student.domain.Department;
import com.edu.Student.dto.DepartmentDTO;
import com.edu.Student.repository.DepartmentRepository;
import com.edu.Student.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDTO createAndUpdate(DepartmentDTO departmentDTO) {
        Department department;
        //create
        if (departmentDTO.getId() == null) {
            department = new Department();
            department.setId(departmentDTO.getId());
            department.setName(departmentDTO.getName());
            department.setLocation(departmentDTO.getLocation());
        }
        //update
        else {
            department = departmentRepository.getOne(departmentDTO.getId());
            if(departmentDTO.getName() != null) {
                department.setName(departmentDTO.getName());
            }
            if(departmentDTO.getLocation() != null) {
                department.setLocation(departmentDTO.getLocation());
            }
        }
        //save
        departmentRepository.save(department);
        //setting up id
        departmentDTO.setId(department.getId());
        //response
        return departmentDTO;
    }

    @Override
    public String delete(Long id) {
        //check if record exists
        if(departmentRepository.findById(id).isPresent()) {
            departmentRepository.deleteById(id);
            //success response
            return "Deleted Successfully!";
        }
        //failure response
        return "Deletion Unsuccessful!";
    }

    @Override
    public DepartmentDTO get(Long id) {
        //get entity values from repository
        Department department = departmentRepository.getOne(id);
        //instance of DTO
        DepartmentDTO departmentDTO = new DepartmentDTO();
        //set up DTO
        departmentDTO.setId(department.getId());
        departmentDTO.setName(department.getName());
        departmentDTO.setLocation(department.getLocation());
        //response
        return departmentDTO;
    }

    @Override
    public List<DepartmentDTO> getAll() {
        //To print all the DTOs in a list
        List<DepartmentDTO> departmentDTOS = new ArrayList<>();
        //get all the entity values of repository in a list
        List<Department> departments = departmentRepository.findAll();
        //loop through entity
        for(Department department: departments){
            //instance of DTO
            DepartmentDTO departmentDTO = new DepartmentDTO();
            //set up DTO
            departmentDTO.setId(department.getId());
            departmentDTO.setName(department.getName());
            departmentDTO.setLocation(department.getLocation());
            //add one DTO in a list of DTOs
            departmentDTOS.add(departmentDTO);
        }
        //response
        return departmentDTOS;
    }
}
