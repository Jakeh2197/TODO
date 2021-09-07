package com.jakehcodes.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jakehcodes.todo.entity.TodoItem;
import com.jakehcodes.todo.service.TodoService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	private TodoService todoService;
	
	@Autowired
	public HomeController(TodoService todoService) {
		this.todoService = todoService;
	}
	
	@GetMapping("/list") 
	public String listTodoItems(Model model) {
		System.out.println("Its working!");
		
		List<TodoItem> items = todoService.findAll();
		
		model.addAttribute("items", items);
		
		System.out.println(items.toString());
		
		return "home/list";
	}

}
