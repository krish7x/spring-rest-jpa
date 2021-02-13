package com.edu.Student.web;

import com.edu.Student.dto.LongIdentityDTO;
import com.edu.Student.dto.StudentDTO;
import com.edu.Student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {

    private final StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public @ResponseBody void add(@RequestBody StudentDTO studentDTO) {
        studentService.createAndUpdate(studentDTO);
    }

    @PostMapping("/update")
    public @ResponseBody void update(@RequestBody StudentDTO studentDTO) {
        studentService.createAndUpdate(studentDTO);
    }

    @PostMapping("/delete")
    public @ResponseBody void update(@RequestBody LongIdentityDTO longIdentityDTO){
        studentService.delete(longIdentityDTO.getId());
    }

    @PostMapping("/get")
    public @ResponseBody StudentDTO get(@RequestBody LongIdentityDTO longIdentityDTO) {
        return studentService.get(longIdentityDTO.getId());
    }

    @PostMapping("/get-all")
    public @ResponseBody
    List<StudentDTO> getAll(){
        return studentService.getAll();
    }

}
