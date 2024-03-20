package com.tdep.tadlab.controller;


//TODO: Change cross origins

import com.tdep.tadlab.entity.projectDb.Project;
import com.tdep.tadlab.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "PostmanRuntime/7.37.0")
@RestController
@RequestMapping("/api/v1")
public class ProjectController {

    @Autowired private ProjectService projectService;

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable("id") int id) {
        return projectService.getProjectById(id);
    }

    @PostMapping("/projects")
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        System.out.println(project);
        return projectService.createProject(project);
    }

    @PutMapping("/projects/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable("id") int id, @RequestBody Project project) {
        return projectService.updateProject(id, project);
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<HttpStatus> deleteProject(@PathVariable("id") int id) {
        return projectService.deleteProject(id);
    }

    @DeleteMapping("projects")
    public ResponseEntity<HttpStatus> deleteAllProjects() {
        return projectService.deleteAllProjects();
    }
}
