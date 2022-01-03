package com.jakehcodes.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jakehcodes.todo.dao.ProjectRepository;
import com.jakehcodes.todo.dao.TodoRepository;
import com.jakehcodes.todo.entity.Project;
import com.jakehcodes.todo.entity.TodoItem;

@Service
public class TodoServiceImpl implements TodoService {
	
	private TodoRepository todoRepository;
	private ProjectRepository projectRepository;
	
	@Autowired
	public TodoServiceImpl(TodoRepository todoRepository, ProjectRepository projectRepository) {
		this.todoRepository = todoRepository;
		this.projectRepository = projectRepository;
	}

	@Override
	public List<TodoItem> findAll() {
		return todoRepository.findAllByOrderByIdAsc();
	}
	
	@Override
	public List<TodoItem> findActive() {
		return todoRepository.findActiveItems();
	}
	
	@Override
	public List<TodoItem> findInactive() {
		return todoRepository.findInactiveItems();
	}

	@Override
	public TodoItem findById(int id) {
		Optional<TodoItem> result = todoRepository.findById(id);
		
		TodoItem item = null;
		
		if(result.isPresent()) {
			item = result.get();
		}
		else {
			throw new RuntimeException("Did not find item id: " + id);
		}
		
		return item;
	}

	@Override
	public void saveTodoItem(TodoItem item) {
		todoRepository.save(item);
	}

	@Override
	public void deleteById(int id) {
		todoRepository.deleteById(id);
	}

	@Override
	public List<Project> findAllProjects() {
		return projectRepository.findAllProjects();
	}
	
	@Override
	public void saveProject(Project project) {
		projectRepository.save(project);
	}

}
