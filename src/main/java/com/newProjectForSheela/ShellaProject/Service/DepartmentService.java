package com.newProjectForSheela.ShellaProject.Service;

import com.newProjectForSheela.ShellaProject.Dto.DepartmentDto;
import com.newProjectForSheela.ShellaProject.Entity.Department;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartment();

    Department createDepartment(Department departmentDto) throws Com.Team.Creation.demo.Exception.EmployeeException;

    Department updateDepartment(Long id, Department department)throws Exception;

    void deleteDepartment(Long id) throws Com.Team.Creation.demo.Exception.EmployeeException;

    Department getByDepartmentId(Long id) throws Com.Team.Creation.demo.Exception.EmployeeException;

    Department getDepartmentName(@RequestParam DepartmentDto departmentDto)throws Exception;
}
