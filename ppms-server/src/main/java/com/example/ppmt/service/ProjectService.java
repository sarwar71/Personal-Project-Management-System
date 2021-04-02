package com.example.ppmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ppmt.exceptions.ProjectIdException;
import com.example.ppmt.model.Project;
import com.example.ppmt.repository.IProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private IProjectRepository repo;

	public Project saveOrUpdateProject(Project project) {
		try {
			
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			
			return repo.save(project);
			
		} catch (Exception e) {
			throw new ProjectIdException(
					"Project Id: '" + project.getProjectIdentifier().toUpperCase() + "' already exixts.");
		}
	}
	
	public Project findProjectByIdentifier(String projectId) {
		
		Project project = repo.findByProjectIdentifier(projectId.toUpperCase());
		
		if(project == null) {
			throw new ProjectIdException(
					"Project Id: '" + projectId + "' dosen't exixt.");
		}
		
		return project;
	}
	
	public Iterable<Project> findAllProjects(){
		return repo.findAll();
	}
	
	public void deleteProjectByIdentifier(String projectId) {
		
		Project project = repo.findByProjectIdentifier(projectId.toUpperCase());
		
		if(project == null) {
			throw new ProjectIdException("Project Id: " + projectId + " dosen,t exist");
		}
		
		repo.delete(project);
	}
	
	

}
