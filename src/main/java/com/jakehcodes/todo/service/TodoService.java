package com.jakehcodes.todo.service;

import java.util.List;

import com.jakehcodes.todo.entity.Project;
import com.jakehcodes.todo.entity.TodoItem;

public interface TodoService {
	
	public List<TodoItem> findAll();
	
	public TodoItem findById(int id);
	
	public void saveTodoItem(TodoItem item);
	
	public void deleteById(int id);

	public List<TodoItem> findActive();

	public List<TodoItem> findInactive();

	public List<Project> findAllProjects();
	
	public void saveProject(Project project);
}
