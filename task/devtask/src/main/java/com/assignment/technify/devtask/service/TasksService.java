package com.assignment.technify.devtask.service;

import java.util.List;

import com.assignment.technify.devtask.dto.TasksDto;

public interface TasksService {
	
	TasksDto createTasks(TasksDto tasksDto);
	
	TasksDto getTasksById(Long tasksId);
	
	List<TasksDto> getAllTasks();
	
	TasksDto updateTasks(Long tasksId, TasksDto updatedTasks);
	
	void deleteTasks(Long tasksId);


}
