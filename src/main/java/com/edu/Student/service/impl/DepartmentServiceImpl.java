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
    public void createAndUpdate(DepartmentDTO departmentDTO) {
        Department department;
        if (departmentDTO.getId() == null) {
            department = new Department();
            department.setId(departmentDTO.getId());
            department.setName(departmentDTO.getName());
            department.setLocation(departmentDTO.getLocation());
        } else {
            department = departmentRepository.getOne(departmentDTO.getId());
            if(departmentDTO.getName() != null) {
                department.setName(departmentDTO.getName());
            }
            if(departmentDTO.getLocation() != null) {
                department.setLocation(departmentDTO.getLocation());
            }

        }
        departmentRepository.save(department);
    }

    @Override
    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public DepartmentDTO get(Long id) {
        Department department = departmentRepository.getOne(id);

        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId(department.getId());
        departmentDTO.setName(department.getName());
        departmentDTO.setLocation(department.getLocation());
        return departmentDTO;
    }

    @Override
    public List<DepartmentDTO> getAll() {
        List<DepartmentDTO> departmentDTOS = new ArrayList<>();
        List<Department> departments = departmentRepository.findAll();

        for(Department department: departments){
            DepartmentDTO departmentDTO = new DepartmentDTO();
            departmentDTO.setId(department.getId());
            departmentDTO.setName(department.getName());
            departmentDTO.setLocation(department.getLocation());

            departmentDTOS.add(departmentDTO);
        }
        return departmentDTOS;
    }
}
