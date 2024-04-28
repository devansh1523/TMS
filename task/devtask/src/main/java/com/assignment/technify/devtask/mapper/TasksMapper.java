package com.assignment.technify.devtask.mapper;

import com.assignment.technify.devtask.dto.TasksDto;
import com.assignment.technify.devtask.entity.Tasks;

public class TasksMapper {
	
	public static TasksDto mapToTasksDto(Tasks tasks) {
		return new TasksDto(
				tasks.getId(),
				tasks.getName(),
				tasks.getDescription()
				);
		
	}
	
	public static Tasks mapToTasks(TasksDto tasksDto) {
		return new Tasks(
				tasksDto.getId(),
				tasksDto.getName(),
				tasksDto.getDescription()
				);
		
	}

}
