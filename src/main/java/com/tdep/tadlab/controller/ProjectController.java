package com.tdep.tadlab.controller;

import com.tdep.tadlab.entity.Project;
import com.tdep.tadlab.repository.ProjectRepository;
import com.tdep.tadlab.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//    TODO: Change cross origins
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class ProjectController {

    @Autowired private ProjectService projectService;
    @Autowired private ProjectRepository projectRepository;

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getAllProjects(@RequestParam(required = false) String name) {
        try {
            List<Project> projects = new ArrayList<Project>();

            if (name == null) {
                projects.addAll(projectRepository.findAll());
            } else {
                projects.addAll(projectRepository.findProjectByName(name));
            }
            if (projects.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(projects, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping("/projects")
    public Project saveProject(@Validated @RequestBody Project project) {
        return projectService.saveProject(project);
    }

    @GetMapping("/projects")
    public List<Project> fetchProjectsList() {
        return projectService.fetchProjectList();
    }

    @PutMapping("/projects/{id}")
    public Project updateProject(@RequestBody Project project, @PathVariable("id") int projectId) {
        return projectService.updateProject(project, projectId);
    }

    @DeleteMapping("/projects/{id}")
    public String deleteProjectById(@PathVariable("id") int projectId) {
        projectService.deleteProjectById(projectId);

        return "Deleted Project Successfully";
    }
}
