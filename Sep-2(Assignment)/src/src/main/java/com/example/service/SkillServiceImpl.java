package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Skill;
import com.example.repository.SkillRepository;

@Service
public class SkillServiceImpl implements SkillService {
	
	@Autowired
	SkillRepository skillRepo;

	@Override
	public Skill addSkill(Skill skill) {
		
		return skillRepo.save(skill);
	}

  

	@Override
	public void deleteSkill(int skillId) {
		skillRepo.deleteById(skillId);

	}

	@Override
	public Skill updateSkill(Skill updatedSkill) {
		
		return skillRepo.save(updatedSkill);
	}

	@Override
	public List<Skill> getSkills() {
		
		return skillRepo.findAll();
	}

	@Override
	public Skill getSkillById(int skillId) {
		
		return skillRepo.findById(skillId).get();
	}

}
