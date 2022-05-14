package com.newProjectForSheela.ShellaProject.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity(name = "Skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillId;
    @Column(name = "SkillName")
    private String skillName;
    @Column(name = "SkillExperience")
    private String skillExperience;

//    @ManyToOne
//    @JoinColumn(name = "employee_employee_id",nullable = true)
//    private Employee employee;

}
