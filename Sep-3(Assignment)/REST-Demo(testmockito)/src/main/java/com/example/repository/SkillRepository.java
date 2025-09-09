package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {

}
