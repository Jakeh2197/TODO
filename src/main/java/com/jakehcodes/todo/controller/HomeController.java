package com.jakehcodes.todo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jakehcodes.todo.entity.TodoItem;
import com.jakehcodes.todo.entity.utility.StatusCode;
import com.jakehcodes.todo.service.TodoService;

/* 
 * @Controller annotation sets this class up as a controller so it can listen on the port the application is running on
 * @RequestMapping specifies a string to "listen" for (in this case localhost:8080/home 
 * (index.html is setup as a reroute to localhost:8080/home/list, spring application looks for index.html to create home page)  
*/

@Controller
@RequestMapping("/home")
public class HomeController {
	
	private TodoService todoService;
	
	/* @Autowired allows the application to find the best class to use as the template for this
	 * object. It can be controlled manually by providing more specific setup information for
	 * the object
	 */
	@Autowired
	public HomeController(TodoService todoService) {
		this.todoService = todoService;
	}
	
	/* 
	 * this creates a list of TodoItems and populates that list with data pulled from the DB
	 * via the todoService
	*/
	@GetMapping("/list") 
	public String listTodoItems(Model model) {		
		List<TodoItem> activeItems = todoService.findActive();
		List<TodoItem> inactiveItems = todoService.findInactive();
		
		model.addAttribute("activeItems", activeItems);
		model.addAttribute("inactiveItems", inactiveItems);
		
		return "home/list";
	}
	
	/* 
	 * this creates a new TodoItem that is added to the model 
	 * this object is then passed to the /add-item-form screen where the user can enter the rest
	 * of the details for this object 
	*/
	@GetMapping("/addItem")
	public String addItem (Model model) {
		TodoItem item = new TodoItem();
		
		LocalDate date_created = LocalDate.now();
		LocalDate date_updated = LocalDate.now();
		
		item.setDateCreated(date_created);
		item.setDateUpdated(date_updated);
		
		model.addAttribute("item", item);
		model.addAttribute("statusCodes", StatusCode.values());
		
		return "home/add-item-form";
		
	}
	
	@PostMapping("save")
	public String saveItem(@ModelAttribute("item") TodoItem item) {
		todoService.saveTodoItem(item);
		
		return "redirect:/home/list";
	}
	
	@GetMapping("/updateItem")
	public String updateItem(@RequestParam("itemId") int id, Model model) {
		TodoItem item = todoService.findById(id);
		
		model.addAttribute("item", item);
		
		return "home/add-item-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("itemId") int id) {	
		todoService.deleteById(id);
		
		return "redirect:/home/list";
	}

}
