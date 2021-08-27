package com.jakehcodes.todo.dao;

import java.util.List;

import com.jakehcodes.todo.entity.TodoItem;

public interface TodoDao {
	
	public List<TodoItem> getAllItems();
	
	public TodoItem getItemByid(int id);
	
	public void saveItem(TodoItem item);
	
	public void deleteById(int id);

}
