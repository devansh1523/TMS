package com.assignment.technify.devtask.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.technify.devtask.dto.TasksDto;
import com.assignment.technify.devtask.service.TasksService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/tasks")
@AllArgsConstructor
public class TasksController {
	
	private TasksService tasksService;
	
	//Add Tasks RestApi
	@PostMapping
	public ResponseEntity<TasksDto> createTasks(@RequestBody TasksDto tasksDto){
		TasksDto savedTasks = tasksService.createTasks(tasksDto);
		return new ResponseEntity<>(savedTasks, HttpStatus.CREATED);
		
	}
	
	
	//Get Tasks RestApi
	@GetMapping("{id}")
	public ResponseEntity<TasksDto> getTasksById(@PathVariable("id") Long tasksId){
		TasksDto tasksDto = tasksService.getTasksById(tasksId);	
		return ResponseEntity.ok(tasksDto);
	}
	
	//Get All Tasks RestAPi
	@GetMapping
	public ResponseEntity<List<TasksDto>> getAllTasks(){
		List<TasksDto> tasks = tasksService.getAllTasks();
		return ResponseEntity.ok(tasks);
	}
	
	//Update Tasks RestApi
	@PutMapping("{id}")
	public ResponseEntity<TasksDto> updateTasks(@PathVariable("id") Long tasksId, @RequestBody TasksDto updatedTasks){
		TasksDto tasksDto = tasksService.updateTasks(tasksId, updatedTasks);
		return ResponseEntity.ok(tasksDto);
	}
	
	//Delete Tasks RestApi
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteTasks(@PathVariable("id") Long tasksid){
		tasksService.deleteTasks(tasksid);
		return ResponseEntity.ok("Tasks deleted successfully");
	}
	
	
}
