package com.newProjectForSheela.ShellaProject.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    @Column(name = "Name")
    private String employeeName;
    @Column(name = "Designation")
    private String employeeDesignation;
    @Column(name = "Age")
    private Long employeeAge;
    @Column(name = "PhoneNumber")
    private Long employeePhoneNumber;
    @Column(name = "Experience")
    private Long yearOfExperience;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private Department department;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private Address address;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name = "Employee_Skill")
    private List<Skill> skills=new ArrayList<>();



}
