package com.newProjectForSheela.ShellaProject.Repository;

import com.newProjectForSheela.ShellaProject.Entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill,Long> {
}
