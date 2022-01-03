package com.jakehcodes.todo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="project")
public class Project {
	
	@Id
	@Column(name="project_name")
	private String projectName;
	
	public Project(String projectName) {
		this.projectName = projectName;
	}
	
	public Project() {
		
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Override
	public String toString() {
		return "[projectName=" + projectName + "]";
	}
	
}
