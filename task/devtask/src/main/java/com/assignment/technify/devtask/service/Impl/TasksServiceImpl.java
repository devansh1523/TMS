package com.assignment.technify.devtask.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.assignment.technify.devtask.dto.TasksDto;
import com.assignment.technify.devtask.entity.Tasks;
import com.assignment.technify.devtask.exception.ResourceNotFoundException;
import com.assignment.technify.devtask.mapper.TasksMapper;
import com.assignment.technify.devtask.repository.TasksRepository;
import com.assignment.technify.devtask.service.TasksService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class TasksServiceImpl implements TasksService{
	
	private TasksRepository tasksRepository;

	@Override
	public TasksDto createTasks(TasksDto tasksDto) {
		
		Tasks tasks= TasksMapper.mapToTasks(tasksDto);
		Tasks savedTasks = tasksRepository.save(tasks);
		return TasksMapper.mapToTasksDto(savedTasks);
	}

	@Override
	public TasksDto getTasksById(Long tasksId) {
		Tasks tasks = tasksRepository.findById(tasksId)
			.orElseThrow(() -> new ResourceNotFoundException("Tasks does not exist with the id: " + tasksId));
		return TasksMapper.mapToTasksDto(tasks);
	}

	@Override
	public List<TasksDto> getAllTasks() {
		List<Tasks> tasks = tasksRepository.findAll();
		return (List<TasksDto>) tasks.stream().map((tasks) -> TasksMapper.mapToTasksDto(tasks))
				.collect(Collectors.toList());
	}
	

}
