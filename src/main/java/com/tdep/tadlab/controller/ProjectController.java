package com.tdep.tadlab.controller;


//TODO: Change cross origins

import com.tdep.tadlab.entity.projectDb.Project;
import com.tdep.tadlab.entity.projectDb.ProjectDetail;
import com.tdep.tadlab.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@CrossOrigin(origins = "PostmanRuntime/7.37.0")
@RestController
@RequestMapping("/api/v1")
public class ProjectController {

    @Autowired
    private ProjectWriteService projectWriteService;

    @Autowired
    private ProjectReadService projectReadService;


//    Project

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getAllProjects() {
        return projectReadService.findAllProjects();
    }

    @GetMapping("/projects/details")
    public ResponseEntity<List<ProjectDetail>> getAllProjectDetails() { return projectReadService.findAllProjectDetails(); }

    @GetMapping("/projects/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable("id") int id) {
        return projectReadService.findProjectById(id);
    }

    @PostMapping("/projects")
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        return projectWriteService.createNewProject(project);
    }

    @PostMapping("/projects/details/{project-id}")
    public ResponseEntity<ProjectDetail> createProjectDetail(@PathVariable("project-id") int projectId, @RequestBody ProjectDetail projectDetail) {
        return projectWriteService.createNewProjectDetail(projectId, projectDetail);
    }

    @PutMapping("/projects/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable("id") int id, @RequestBody Project project) {
        return projectWriteService.updateExistingProject(id, project);
    }

    @PutMapping("/projects/details/{project-id}")
    public ResponseEntity<ProjectDetail> updateProjectDetail(@PathVariable("project-id") int projectId, @RequestBody ProjectDetail projectDetail) {
        return projectWriteService.updateExistingProjectDetail(projectId, projectDetail);
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<HttpStatus> deleteProject(@PathVariable("id") int id) {
        return projectWriteService.deleteProjectById(id);
    }

    @DeleteMapping("projects")
    public ResponseEntity<HttpStatus> deleteAllProjects() {
        return projectWriteService.deleteAllProjects();
    }


}
