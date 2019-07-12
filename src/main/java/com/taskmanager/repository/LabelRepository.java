package com.taskmanager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.taskmanager.domain.Label;

@Repository
public interface LabelRepository extends CrudRepository<Label, Long> {

}


