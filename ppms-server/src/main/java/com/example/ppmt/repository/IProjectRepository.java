package com.example.ppmt.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.ppmt.model.Project;

public interface IProjectRepository extends CrudRepository<Project, Long>{
	
	Project findByProjectIdentifier(String projectId);
}
