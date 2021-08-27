package com.jakehcodes.todo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jakehcodes.todo.entity.TodoItem;

@Repository
public class TodoDaoImpl implements TodoDao {
	
	private EntityManager entityManager;
	
	@Autowired
	public TodoDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<TodoItem> getAllItems() {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query<TodoItem> query = session.createQuery("from TodoItem", TodoItem.class);
		
		List<TodoItem> items = query.getResultList();
		
		return items;
	}

	@Override
	public TodoItem getItemByid(int id) {
		return null;
	}

	@Override
	public void saveItem(TodoItem item) {
		
	}

	@Override
	public void deleteById(int id) {
		
	}

}
