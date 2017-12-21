package com.lonelybit.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lonelybit.task.model.Task;


public interface TaskRepository extends JpaRepository<Task, Long>{

}
