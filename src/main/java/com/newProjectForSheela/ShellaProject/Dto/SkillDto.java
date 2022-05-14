package com.newProjectForSheela.ShellaProject.Dto;

import com.newProjectForSheela.ShellaProject.Entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.asm.Advice;
import org.springframework.http.HttpStatus;

import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SkillDto {
    private Long skillId;
    private String skillName;
    private Long skillExperience;

    public SkillDto(Boolean aTrue, String DeleteStatus, HttpStatus ok) {
    }
}
