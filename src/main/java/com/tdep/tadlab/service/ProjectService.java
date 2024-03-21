package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.projectDb.Project;
import com.tdep.tadlab.entity.projectDb.ProjectDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectService {

    ResponseEntity<List<Project>> getAllProjects();

    ResponseEntity<Project> getProjectById(int id);

    ResponseEntity<Project> createProject(Project project);

    ResponseEntity<Project> updateProject(int id, Project project);

    ResponseEntity<HttpStatus> setProjectDetails(int projectId, ProjectDetail detail);

    ResponseEntity<HttpStatus> deleteProject(int id);

    ResponseEntity<HttpStatus> deleteAllProjects();
}
