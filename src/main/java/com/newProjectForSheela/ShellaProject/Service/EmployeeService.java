package com.newProjectForSheela.ShellaProject.Service;

import com.newProjectForSheela.ShellaProject.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    Employee createEmployee(Employee employeeDto);

    Employee updateEmployee(Long id, Employee employee)throws Exception;

    void deleteEmployee(Long id) throws Com.Team.Creation.demo.Exception.EmployeeException;

    Employee getByEmployeeId(Long id) throws Com.Team.Creation.demo.Exception.EmployeeException;

    void deleteAllEmployee();
}
