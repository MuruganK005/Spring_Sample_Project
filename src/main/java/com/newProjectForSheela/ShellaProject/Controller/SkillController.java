package com.newProjectForSheela.ShellaProject.Controller;


import com.newProjectForSheela.ShellaProject.Dto.AddressDto;
import com.newProjectForSheela.ShellaProject.Dto.SkillDto;
import com.newProjectForSheela.ShellaProject.Entity.Address;
import com.newProjectForSheela.ShellaProject.Entity.Skill;
import com.newProjectForSheela.ShellaProject.Service.AddressService;
import com.newProjectForSheela.ShellaProject.Service.SkillService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill")
public class SkillController {
    @Autowired
    private SkillService skillService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/getAllSkill")
    public List<SkillDto> getAllSkill(){
        return (List<SkillDto>) skillService.getAllSkill()
                .stream()
                .map(skill -> modelMapper.map(skill,AddressDto.class));
    }
    @GetMapping("/getSkill/{id}")
    public ResponseEntity<SkillDto> getSkillById(@PathVariable(name = "id") Long id) throws Com.Team.Creation.demo.Exception.EmployeeException {
        Skill skill = skillService.getBySkill(id);

        SkillDto skillDto = modelMapper.map(skill, SkillDto.class);

        return ResponseEntity.ok().body(skillDto);
    }
    @PostMapping("/createSkill")
    public ResponseEntity<SkillDto> createSkill(@RequestBody SkillDto skillDto) {

        Skill skill = modelMapper.map(skillDto, Skill.class);

        Skill skill1 = skillService.createSkill(skill);

        SkillDto skillDto1 = modelMapper.map(skill1, SkillDto.class);

        return new ResponseEntity<SkillDto>(skillDto1, HttpStatus.CREATED);
    }
    @PutMapping("/updateSkill/{id}")
    public ResponseEntity<SkillDto> updateSkill(@PathVariable long id, @RequestBody SkillDto skillDto) throws Exception {

        Skill skill = modelMapper.map(skillDto, Skill.class);

        Skill skill1 = skillService.updateSkill(id, skill);

        SkillDto skillDto1 = modelMapper.map(skill1, SkillDto.class);

        return ResponseEntity.ok().body(skillDto1);
    }
    @DeleteMapping("/deleteSkill/{id}")
    public ResponseEntity<SkillDto> deleteSkill(@PathVariable(name = "id") Long id) throws Com.Team.Creation.demo.Exception.EmployeeException {
        skillService.deleteSkill(id);
        SkillDto skillDto = new SkillDto(Boolean.TRUE, "Address deleted successfully", HttpStatus.OK);
        return new ResponseEntity<SkillDto>(skillDto, HttpStatus.OK);
    }
}
