package com.jakehcodes.todo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jakehcodes.todo.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
	
	@Query(value = "SELECT * FROM project", nativeQuery = true)
	public List<Project> findAllProjects();

}
