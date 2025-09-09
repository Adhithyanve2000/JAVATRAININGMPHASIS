package com.example.service;

import java.util.List;

import com.example.entity.Skill;

public interface SkillService {
	
	Skill addSkill(Skill skill);
	void deleteSkill(int skillId);
	Skill updateSkill(Skill skill);
	List<Skill> getSkills();
	Skill getSkillById(int skillId);

}
