package com.jsonplaceholder.todos;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class TodosController {
	
	@Resource
	TodosService todosService;
	
	@GetMapping
	public List<Todos> getTodos() {
		return todosService.findAll();
	}
	
	@PostMapping("/insert")
	public void insertTodos(@RequestBody List<Todos> todos) {
		try {
	        for(Todos todo : todos){
	        	todosService.insertTodo(todo);
	        }
	    } catch(Exception e){}
	}
	
	@PostMapping("/update")
	public void updateTodos(@RequestBody Todos todos) {
		todosService.updateTodo(todos);
	}
}