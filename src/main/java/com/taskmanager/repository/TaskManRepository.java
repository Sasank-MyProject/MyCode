package com.taskmanager.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.taskmanager.domain.Task;

@Repository
public interface TaskManRepository extends CrudRepository<Task, Long> {

}

