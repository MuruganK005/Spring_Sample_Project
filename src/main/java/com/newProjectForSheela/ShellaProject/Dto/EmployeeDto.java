package com.newProjectForSheela.ShellaProject.Dto;

import com.newProjectForSheela.ShellaProject.Entity.Address;
import com.newProjectForSheela.ShellaProject.Entity.Department;
import com.newProjectForSheela.ShellaProject.Entity.Employee;
import com.newProjectForSheela.ShellaProject.Entity.Skill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long employeeId;
    private String employeeName;
    private String employeeDesignation;
    private Long employeeAge;
    private Long employeePhoneNumber;
    private Long yearOfExperience;
   private DepartmentDto department;
   private List<SkillDto> skills=new ArrayList<>();
   private AddressDto address;

    public EmployeeDto(Boolean aTrue, String DeleteStatus, HttpStatus ok) {
    }
}
