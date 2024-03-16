package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.Project;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface ProjectService {

    ResponseEntity<List<Project>> getAllProjects(String projectName);

    ResponseEntity<Project> getProjectById(long projectId);

    ResponseEntity<Project> getProjectByName(String projectName);

    ResponseEntity<Project> createProject(Project project);

    ResponseEntity<Project> updateProject(long projectId, Project project);

    ResponseEntity<HttpStatus> deleteProject(long projectId);

    ResponseEntity<HttpStatus> deleteAllProjects();
}
