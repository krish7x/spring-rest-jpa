package com.edu.Student.service.impl;

import com.edu.Student.domain.Student;
import com.edu.Student.dto.StudentDTO;
import com.edu.Student.repository.StudentRepository;
import com.edu.Student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public void createAndUpdate(StudentDTO studentDTO) {
        Student student;
        if(studentDTO.getId() != null) {
            student = studentRepository.getOne(studentDTO.getId());
        } else {
            student = new Student();
        }
        if(studentDTO.getName() != null) {
            student.setName(studentDTO.getName());
        }
        if(studentDTO.getDept() != null) {
            student.setDept(studentDTO.getDept());
        }
        studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDTO get(Long id) {
        Student student = studentRepository.getOne(id);
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setDept(student.getDept());
        return studentDTO;
    }

    @Override
    public List<StudentDTO> getAll() {

        List<StudentDTO> studentsDTO = new ArrayList<>();
        List<Student> students = studentRepository.findAll();

        for(Student student: students) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setId(student.getId());
            studentDTO.setName(student.getName());
            studentDTO.setDept(student.getDept());
            studentsDTO.add(studentDTO);
        }
        return studentsDTO;
    }
}
