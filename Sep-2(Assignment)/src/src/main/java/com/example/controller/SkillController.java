package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Skill;
import com.example.service.SkillService;

@RestController
public class SkillController {
	
	@Autowired
	SkillService skillServ;
	
	// ADD
	@PostMapping("/skill/add")
	Skill addSkill(Skill skill) {
		return skillServ.addSkill(skill);
	}
	
	// DELETE
	@DeleteMapping("/skill/delete/{skillId}")
	void deleteSkill(int skillId) {
		skillServ.deleteSkill(skillId);
	}
	
	// UPDATE
	Skill updateSkill(@RequestBody Skill skill) {
		return skillServ.updateSkill(skill);
	}
	
	// GET
	@GetMapping("/skill/getAll")
	List<Skill> getSkills() {
		return skillServ.getSkills();
	}
	
	// GET
	@GetMapping("/skill/getById/{skillId}")
	Skill getSkillById(@PathVariable int skillId) {
		return skillServ.getSkillById(skillId);
	}
	
	

}
