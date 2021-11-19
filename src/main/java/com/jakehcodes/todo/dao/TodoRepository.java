package com.jakehcodes.todo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jakehcodes.todo.entity.TodoItem;

public interface TodoRepository extends JpaRepository<TodoItem, Integer>{
	
	// add a method to sort by last name
	public List<TodoItem> findAllByOrderByIdAsc();
	
	@Query(value = "SELECT * FROM item WHERE item.status = 'Active'", nativeQuery = true)
	public List<TodoItem> findActiveItems();
	
	@Query(value = "SELECT * FROM item WHERE item.status != 'Active'", nativeQuery = true)
	public List<TodoItem> findInactiveItems();

}
