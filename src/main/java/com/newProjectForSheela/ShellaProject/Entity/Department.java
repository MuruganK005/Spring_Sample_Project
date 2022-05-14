package com.newProjectForSheela.ShellaProject.Entity;

import com.newProjectForSheela.ShellaProject.Dto.DepartmentDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "Department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;
    @Column(name = "DepartmentName")
    private String departmentName;
}
