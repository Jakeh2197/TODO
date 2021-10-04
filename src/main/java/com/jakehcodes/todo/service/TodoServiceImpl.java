package com.jakehcodes.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jakehcodes.todo.dao.TodoRepository;
import com.jakehcodes.todo.entity.TodoItem;

@Service
public class TodoServiceImpl implements TodoService {
	
	private TodoRepository todoRepository;
	
	@Autowired
	public TodoServiceImpl(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	@Override
	public List<TodoItem> findAll() {
		return todoRepository.findAllByOrderByIdAsc();
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
		
	}

	@Override
	public void deleteById(int id) {
		todoRepository.deleteById(id);
	}

}
