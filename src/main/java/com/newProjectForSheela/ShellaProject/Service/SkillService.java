package com.newProjectForSheela.ShellaProject.Service;

import com.newProjectForSheela.ShellaProject.Entity.Skill;

import java.util.List;

public interface SkillService {
    List<Skill> getAllSkill();

    Skill createSkill(Skill skill);

    Skill updateSkill(Long id, Skill skill)throws Exception;

    void deleteSkill(Long id) throws Com.Team.Creation.demo.Exception.EmployeeException;

    Skill getBySkill(Long id) throws Com.Team.Creation.demo.Exception.EmployeeException;
}
