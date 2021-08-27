package com.jakehcodes.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jakehcodes.todo.dao.TodoDao;
import com.jakehcodes.todo.entity.TodoItem;

@Service
public class TodoServiceImpl implements TodoService {
	
	private TodoDao todoDao;
	
	@Autowired
	public TodoServiceImpl(TodoDao todoDao) {
		this.todoDao = todoDao;
	}

	@Override
	public List<TodoItem> findAll() {
		return todoDao.getAllItems();
	}

	@Override
	public TodoItem findById(int id) {
		return null;
	}

	@Override
	public void saveTodoItem(TodoItem item) {
		
	}

	@Override
	public void deleteById(int id) {
		
	}

}
