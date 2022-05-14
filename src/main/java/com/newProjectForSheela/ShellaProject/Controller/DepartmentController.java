package com.newProjectForSheela.ShellaProject.Controller;

import com.newProjectForSheela.ShellaProject.Dto.DepartmentDto;
import com.newProjectForSheela.ShellaProject.Entity.Department;
import com.newProjectForSheela.ShellaProject.Service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/getAllDepartment")
    public List<DepartmentDto> getAllDepartment(){
        ArrayList<DepartmentDto> departmentDtoArrayList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        try {
            List<Department> departments = departmentService.getAllDepartment();
            for (Department department:departments) {
                departmentDtoArrayList.add(modelMapper.map(department, DepartmentDto.class));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return departmentDtoArrayList;
    }
    @GetMapping("/getDepartment/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable(name = "id") Long id) throws Com.Team.Creation.demo.Exception.EmployeeException {
        Department department = departmentService.getByDepartmentId(id);
        ModelMapper modelMapper = new ModelMapper();
        DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);

        return ResponseEntity.ok().body(departmentDto);
    }
    @PostMapping("/createDepartment")
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) throws Com.Team.Creation.demo.Exception.EmployeeException {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        Department department = modelMapper.map(departmentDto, Department.class);

        Department department1 = departmentService.createDepartment(department);

        DepartmentDto departmentDto1 = modelMapper.map(department1, DepartmentDto.class);

        return new ResponseEntity<DepartmentDto>(departmentDto1, HttpStatus.CREATED);
    }
    @PutMapping("/updateDepartment/{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable long id, @RequestBody DepartmentDto departmentDto) throws Exception {
        ModelMapper modelMapper = new ModelMapper();
        Department department = modelMapper.map(departmentDto, Department.class);

        Department department1 = departmentService.updateDepartment(id, department);

        DepartmentDto departmentDto1 = modelMapper.map(department, DepartmentDto.class);

        return ResponseEntity.ok().body(departmentDto1);
    }
    @DeleteMapping("/deleteDepartment/{id}")
    public ResponseEntity<DepartmentDto> deleteDepartment(@PathVariable(name = "id") Long id) throws Com.Team.Creation.demo.Exception.EmployeeException {
        departmentService.deleteDepartment(id);
        DepartmentDto departmentDto = new DepartmentDto(Boolean.TRUE, "Department deleted successfully", HttpStatus.OK);
        return new ResponseEntity<DepartmentDto>(departmentDto, HttpStatus.OK);
    }
    @GetMapping("/getDepartmentName")
    public Department getDepartmentByName(@RequestParam DepartmentDto departmentDto) throws Exception {
        return departmentService.getDepartmentName(departmentDto);
    }
}
