package com.spring.todoapp.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.todoapp.entity.TodoListData;
import com.spring.todoapp.repository.TodoAppRepository;

@Controller
@RequestMapping("/app")
public class TodoAppController {
	
	private TodoAppRepository appRepo;
	
	
	public TodoAppController(TodoAppRepository appRepo) {
		this.appRepo = appRepo;
	}

	@GetMapping("/hello")
	public String hello() {
		
		TodoListData entry= new TodoListData("get clothes",LocalTime.now(),LocalDate.now());
		TodoListData entry1= new TodoListData("buy groceries",LocalTime.now(),LocalDate.now());
		
		appRepo.save(entry);
		appRepo.save(entry1);
		
		return "homepage";
	}
	
	@GetMapping("/home")
	public String home(Model theModel) {
		
		List<TodoListData> todoData = appRepo.findAll();
		
		theModel.addAttribute("todoData",todoData);
		
		return "homepage";
	}
	
	@GetMapping("/addnewtask")
	public String addnewtask(Model theModel) {
		
		TodoListData entry= new TodoListData();
		theModel.addAttribute("entry",entry);
		
		return "addnewtask";
	}
	
	@PostMapping("/save")
	public String saveData(@ModelAttribute("entry") TodoListData newData) {
		
		newData.setDate(LocalDate.now());
		newData.setTime(LocalTime.now());
		
		appRepo.save(newData);
		
		return "redirect:/app/home";
	}
	@GetMapping("/updateForm")
	public String updateForm(@RequestParam("entryId") int theId, Model theModel) {
		
		Optional<TodoListData> temp=appRepo.findById(theId);
		TodoListData tempEntry=null;
		if(temp.isPresent())
			tempEntry=temp.get();
		
		theModel.addAttribute("entry",tempEntry);
		return "addnewtask";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("entryId") int theId,Model theModel) {
		appRepo.deleteById(theId);
		return "redirect:/app/home";
	}
	
	
	
	
}
