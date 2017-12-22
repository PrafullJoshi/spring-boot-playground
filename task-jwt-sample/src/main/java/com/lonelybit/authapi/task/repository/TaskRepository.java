package com.lonelybit.authapi.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lonelybit.authapi.task.model.Task;


public interface TaskRepository extends JpaRepository<Task, Long>{

}
