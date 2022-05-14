package com.newProjectForSheela.ShellaProject.Service;

import com.newProjectForSheela.ShellaProject.Entity.Employee;
import com.newProjectForSheela.ShellaProject.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) throws Exception {
        Employee employee1 = employeeRepository.findById(id)
                .orElseThrow(() -> new Com.Team.Creation.demo.Exception.EmployeeException(HttpStatus.BAD_REQUEST, "Address Id has Not Found"));
        employee1.setEmployeeId(employee.getEmployeeId());
        employee1.setEmployeeName(employee.getEmployeeName());
        employee1.setEmployeeAge(employee.getEmployeeAge());
        employee1.setEmployeeDesignation(employee.getEmployeeDesignation());
        employee1.setEmployeePhoneNumber(employee.getEmployeePhoneNumber());
        employee1.setYearOfExperience(employee.getYearOfExperience());
        employee1.setDepartment(employee1.getDepartment());
        employee1.setSkills(employee.getSkills());
        return employeeRepository.save(employee);
    }
    @Override
    public void deleteEmployee(Long id) throws Com.Team.Creation.demo.Exception.EmployeeException {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new Com.Team.Creation.demo.Exception.EmployeeException(HttpStatus.BAD_REQUEST, "Address ID Not Found"));
        employeeRepository.delete(employee);
    }

    @Override
    public Employee getByEmployeeId(Long id) throws Com.Team.Creation.demo.Exception.EmployeeException {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new Com.Team.Creation.demo.Exception.EmployeeException(HttpStatus.BAD_REQUEST, "Address not Present in Database");
        }
    }

    @Override
    public void deleteAllEmployee() {
        employeeRepository.deleteAll();
    }

}
