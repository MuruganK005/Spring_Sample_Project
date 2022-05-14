package com.newProjectForSheela.ShellaProject.Service;

import com.newProjectForSheela.ShellaProject.Entity.Skill;
import com.newProjectForSheela.ShellaProject.Repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillServiceImpl implements SkillService{
    @Autowired
    private SkillRepository skillRepository;
    @Override
    public List<Skill> getAllSkill(){
        return skillRepository.findAll();
    }
    @Override
    public Skill createSkill(Skill skill){
        return skillRepository.save(skill);
    }
    @Override
    public Skill updateSkill(Long id, Skill skill)throws Exception{
        Skill skill1=skillRepository.findById(id)
                .orElseThrow(()->new Com.Team.Creation.demo.Exception.EmployeeException(HttpStatus.BAD_REQUEST,"Address Id has Not Found"));
        skill1.setSkillId(skill.getSkillId());
        skill1.setSkillName(skill.getSkillName());
        skill.setSkillExperience(skill.getSkillExperience());
        return skillRepository.save(skill);
    }
    @Override
    public void deleteSkill(Long id) throws Com.Team.Creation.demo.Exception.EmployeeException {
        Skill skill=skillRepository.findById(id)
                .orElseThrow(()->new Com.Team.Creation.demo.Exception.EmployeeException(HttpStatus.BAD_REQUEST,"Address ID Not Found"));
        skillRepository.delete(skill);
    }
    @Override
    public Skill getBySkill(Long id) throws Com.Team.Creation.demo.Exception.EmployeeException {
        Optional<Skill> skill = skillRepository.findById(id);
        if (skill.isPresent()) {
            return skill.get();
        } else {
            throw new Com.Team.Creation.demo.Exception.EmployeeException(HttpStatus.BAD_REQUEST, "Address not Present in Database");
        }
    }
}
