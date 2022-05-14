package com.newProjectForSheela.ShellaProject.Controller;


import com.newProjectForSheela.ShellaProject.Dto.EmployeeDto;
import com.newProjectForSheela.ShellaProject.Entity.Employee;
import com.newProjectForSheela.ShellaProject.Service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ModelMapper modelMapper;

    EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping("/getAllEmployee")
    public List<EmployeeDto> getAllEmployee(){
        ModelMapper modelMapper = new ModelMapper();
        return (List<EmployeeDto>) employeeService.getAllEmployee()
                .stream()
                .map(employee -> modelMapper.map(employee,EmployeeDto.class));
    }
    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(name = "id") Long id) throws Com.Team.Creation.demo.Exception.EmployeeException {
        Employee employee = employeeService.getByEmployeeId(id);
//        ModelMapper modelMapper = new ModelMapper();
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);

        return ResponseEntity.ok().body(employeeDto);
    }
    @PostMapping("/create")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
//        ModelMapper modelMapper = new ModelMapper();
        Employee employee= modelMapper.map(employeeDto, Employee.class);

        Employee employee1 = employeeService.createEmployee(employee);

        EmployeeDto employeeDto1 = modelMapper.map(employee1, EmployeeDto.class);

        return new ResponseEntity<EmployeeDto>(employeeDto1, HttpStatus.CREATED);
    }
    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable long id, @RequestBody EmployeeDto employeeDto) throws Exception {

//        ModelMapper modelMapper = new ModelMapper();
        Employee employee = modelMapper.map(employeeDto, Employee.class);

        Employee employee1 = employeeService.updateEmployee(id, employee);

        EmployeeDto employeeDto1 = modelMapper.map(employee1, EmployeeDto.class);

        return ResponseEntity.ok().body(employeeDto1);
    }
    @DeleteMapping("DeleteEmployee/{id}")
    public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable(name = "id") Long id) throws Com.Team.Creation.demo.Exception.EmployeeException {
        employeeService.deleteEmployee(id);
        EmployeeDto employeeDto = new EmployeeDto(Boolean.TRUE, "Address deleted successfully", HttpStatus.OK);
        return new ResponseEntity<EmployeeDto>(employeeDto, HttpStatus.OK);
    }
    @DeleteMapping("DeleteAllEmployee")
    public ResponseEntity<EmployeeDto> deleteAllEmployee(){
        employeeService.deleteAllEmployee();
        EmployeeDto employeeDto=new EmployeeDto(Boolean.TRUE,"AllEmployee Deleted Successfully",HttpStatus.OK);
        return new ResponseEntity<EmployeeDto>(employeeDto,HttpStatus.ACCEPTED);
    }


}
