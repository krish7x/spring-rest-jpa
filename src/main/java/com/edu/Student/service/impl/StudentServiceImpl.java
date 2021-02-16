package com.edu.Student.service.impl;

import com.edu.Student.domain.Student;
import com.edu.Student.dto.StudentDTO;
import com.edu.Student.dto.StudentIdentityDTO;
import com.edu.Student.repository.DepartmentRepository;
import com.edu.Student.repository.StudentRepository;
import com.edu.Student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, DepartmentRepository departmentRepository){
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public StudentIdentityDTO createAndUpdate(StudentDTO studentDTO) {
        Student student;
        //create if not exist
        if(studentDTO.getId() == null) {
            student = new Student();
            student.setName(studentDTO.getName());
            student.setDepartment(departmentRepository.getOne(studentDTO.getDepartment().getId()));
        }
        //update if exist
        else {
            student = studentRepository.getOne(studentDTO.getId());
            if(studentDTO.getName() != null) {
                student.setName(studentDTO.getName());
            }
            if(studentDTO.getDepartment() != null) {
                student.setDepartment(departmentRepository.getOne(studentDTO.getDepartment().getId()));
            }
        }
        //save
        studentRepository.save(student);
        //response
        StudentIdentityDTO studentIdentityDTO = new StudentIdentityDTO();
        studentIdentityDTO.setId(student.getId());
        studentIdentityDTO.setName(student.getName());
        studentIdentityDTO.setDepartment(student.getDepartment().getName());
        return studentIdentityDTO;
    }

    @Override
    public String delete(Long id) {
        //check if record exists
        if(studentRepository.findById(id).isPresent()){
            studentRepository.deleteById(id);
            //success response
            return "Deleted Successfully!";
        }
        //failure response
        return "Deletion Unsuccessful!";
    }

    @Override
    public StudentIdentityDTO get(Long id) {
        //get entity values from repository
        Student student = studentRepository.getOne(id);
        //instance of DTO
        StudentIdentityDTO studentIdentityDTO = new StudentIdentityDTO();
        //set up DTO
        studentIdentityDTO.setId(student.getId());
        studentIdentityDTO.setName(student.getName());
        studentIdentityDTO.setDepartment(departmentRepository.getOne(student.getDepartment().getId()).getName());
        //response
        return studentIdentityDTO;
    }

    @Override
    public List<StudentIdentityDTO> getAll() {
        //To print all the DTOs in a list
        List<StudentIdentityDTO> studentIdentityDTOS = new ArrayList<>();
        //get all the entity values of repository in a list
        List<Student> students = studentRepository.findAll();
        //loop through entity
        for(Student student: students) {
            //instance of DTO
            StudentIdentityDTO studentIdentityDTO = new StudentIdentityDTO();
            //set up DTO
            studentIdentityDTO.setId(student.getId());
            studentIdentityDTO.setName(student.getName());
            studentIdentityDTO.setDepartment(departmentRepository.getOne(student.getDepartment().getId()).getName());
            //add one DTO in a list of DTOs
            studentIdentityDTOS.add(studentIdentityDTO);
        }
        //response
        return studentIdentityDTOS;
    }
}

