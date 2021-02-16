package com.edu.Student.web;

import com.edu.Student.dto.IdentityDTO;
import com.edu.Student.dto.StudentDTO;
import com.edu.Student.dto.StudentIdentityDTO;
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
    public @ResponseBody StudentIdentityDTO add(@RequestBody StudentDTO studentDTO) {
        return studentService.createAndUpdate(studentDTO);
    }

    @PostMapping("/update")
    public @ResponseBody void update(@RequestBody StudentDTO studentDTO) {
        studentService.createAndUpdate(studentDTO);
    }

    @PostMapping("/delete")
    public @ResponseBody String delete(@RequestBody IdentityDTO identityDTO){
       return studentService.delete(identityDTO.getId());
    }

    @PostMapping("/get")
    public @ResponseBody
    StudentIdentityDTO get(@RequestBody IdentityDTO identityDTO) {
        return studentService.get(identityDTO.getId());
    }

    @PostMapping("/get-all")
    public @ResponseBody
    List<StudentIdentityDTO> getAll(){
        return studentService.getAll();
    }

}
