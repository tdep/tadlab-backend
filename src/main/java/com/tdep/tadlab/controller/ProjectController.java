package com.tdep.tadlab.controller;

import com.tdep.tadlab.entity.Project;
import com.tdep.tadlab.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//    TODO: Change cross origins
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class ProjectController {

    @Autowired private ProjectService projectService;

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getAllProjects(@RequestParam(required = false) String projectName) {
        return projectService.getAllProjects(projectName);
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable("id") long projectId) {
        return projectService.getProjectById(projectId);
    }

    @GetMapping("/projects/{name}")
    public ResponseEntity<Project> getProjectByName(@PathVariable("name") String projectName) {
        return projectService.getProjectByName(projectName);
    }

    @PostMapping("/projects")
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    @PutMapping("/projects/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable("id") long projectId, @RequestBody Project project) {
        return projectService.updateProject(projectId, project);
    }


    @DeleteMapping("/projects/{id}")
    public ResponseEntity<HttpStatus> deleteProject(@PathVariable("id") long projectId) {
        return projectService.deleteProject(projectId);
    }

    @DeleteMapping("/projects")
    public ResponseEntity<HttpStatus> deleteAllProjects() {
        return projectService.deleteAllProjects();
    }
}
