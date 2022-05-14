package com.newProjectForSheela.ShellaProject.Service;

import Com.Team.Creation.demo.Exception.EmployeeException;
import com.newProjectForSheela.ShellaProject.Dto.DepartmentDto;
import com.newProjectForSheela.ShellaProject.Entity.Department;
import com.newProjectForSheela.ShellaProject.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public List<Department> getAllDepartment(){
        return departmentRepository.findAll();
    }
    @Override
    public Department createDepartment(Department departmentDto)throws EmployeeException{
        Department departmentDto1= departmentRepository.findByDepartmentName(departmentDto.getDepartmentName());
        if (departmentDto1 != null){
            throw new EmployeeException(HttpStatus.FORBIDDEN,"DepartmentName Cannot create twice");
        }else
           return departmentRepository.save(departmentDto);

    }
    @Override
    public Department updateDepartment(Long id, Department department)throws Exception{
        Department department1=departmentRepository.findById(id)
                .orElseThrow(()->new Com.Team.Creation.demo.Exception.EmployeeException(HttpStatus.BAD_REQUEST,"Address Id has Not Found"));
       department1.setDepartmentId(department.getDepartmentId());
       department1.setDepartmentName(department.getDepartmentName());
        return departmentRepository.save(department);
    }
    @Override
    public void deleteDepartment(Long id) throws Com.Team.Creation.demo.Exception.EmployeeException {
        Department department=departmentRepository.findById(id)
                .orElseThrow(()->new Com.Team.Creation.demo.Exception.EmployeeException(HttpStatus.BAD_REQUEST,"Address ID Not Found"));
        departmentRepository.delete(department);
    }
    @Override
    public Department getByDepartmentId(Long id) throws Com.Team.Creation.demo.Exception.EmployeeException {
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) {
            return department.get();
        } else {
            throw new Com.Team.Creation.demo.Exception.EmployeeException(HttpStatus.BAD_REQUEST, "Address not Present in Database");
        }
    }
    @Override
    public Department getDepartmentName(@RequestParam DepartmentDto departmentDto)throws Exception{
        Department departmentDto1=departmentRepository.findByDepartmentName(departmentDto.getDepartmentName());
        if (departmentDto1 != null){
            throw new EmployeeException(HttpStatus.FORBIDDEN,"Department Name Not Found");
        }
        else
            departmentDto1.setDepartmentName(departmentDto.getDepartmentName());
        return departmentDto1;
    }
}
