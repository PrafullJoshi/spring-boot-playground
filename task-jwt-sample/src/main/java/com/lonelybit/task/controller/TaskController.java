package com.lonelybit.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lonelybit.task.model.Task;
import com.lonelybit.task.repository.TaskRepository;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	private TaskRepository taskRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Task> list() {
		return taskRepository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Task get(@PathVariable long id) {
		return taskRepository.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Task add(@RequestBody Task task) {
		return taskRepository.saveAndFlush(task);
	}
}
