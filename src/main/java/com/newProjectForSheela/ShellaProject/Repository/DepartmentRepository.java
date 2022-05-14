package com.newProjectForSheela.ShellaProject.Repository;

import com.newProjectForSheela.ShellaProject.Dto.DepartmentDto;
import com.newProjectForSheela.ShellaProject.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Department findByDepartmentName(String departmentDto);
}
