package com.assignment.technify.devtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.technify.devtask.entity.Tasks;

public interface TasksRepository extends JpaRepository<Tasks, Long>{

}
