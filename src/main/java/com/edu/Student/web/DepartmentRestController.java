package com.edu.Student.web;

import com.edu.Student.dto.DepartmentDTO;
import com.edu.Student.dto.LongIdentityDTO;
import com.edu.Student.service.DepartmentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/dept")
public class DepartmentRestController {

    private final DepartmentService departmentService;

    public DepartmentRestController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/add")
    public @ResponseBody void add(@RequestBody DepartmentDTO departmentDTO) {
        departmentService.createAndUpdate(departmentDTO);
    }

    @PostMapping("/update")
    public @ResponseBody void update(@RequestBody DepartmentDTO departmentDTO) {
        departmentService.createAndUpdate(departmentDTO);
    }

    @PostMapping("/delete")
    public @ResponseBody void delete(@RequestBody LongIdentityDTO longIdentityDTO){
        departmentService.delete(longIdentityDTO.getId());
    }

    @PostMapping("/get")
    public @ResponseBody DepartmentDTO get(@RequestBody  LongIdentityDTO longIdentityDTO){
      return  departmentService.get(longIdentityDTO.getId());
    }

    @PostMapping("/get-all")
    public @ResponseBody
    List<DepartmentDTO> getAll(){
       return  departmentService.getAll();
    }
}
