package com.newProjectForSheela.ShellaProject.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
     Long departmentId;
     String departmentName;

    public DepartmentDto(Boolean aTrue, String DeleteStatus, HttpStatus ok) {

    }

}
