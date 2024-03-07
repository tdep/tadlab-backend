package com.tdep.tadlab.controller;

import com.tdep.tadlab.repository.ProjectRepository;
import com.tdep.tadlab.repository.ProjectLinkRepository;
import com.tdep.tadlab.repository.ToolRepository;
import com.tdep.tadlab.entity.Project;
import com.tdep.tadlab.entity.Tool;
import com.tdep.tadlab.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/v1")
public class ProjectController {

    @Autowired private ProjectService projectService;

    //    TODO: Change cross origins
    private final String crossOrigin = "PostmanRuntime/7.36.3";

    @CrossOrigin(value = crossOrigin)
    @PostMapping("/projects")
    public Project saveProject(@Validated @RequestBody Project project) {
        return projectService.saveProject(project);
    }

    @CrossOrigin(value = crossOrigin)
    @GetMapping("/projects")
    public List<Project> fetchProjectsList() {
        return projectService.fetchProjectList();
    }

    @CrossOrigin(value = crossOrigin)
    @PutMapping("/projects/{id}")
    public Project updateProject(@RequestBody Project project, @PathVariable("id") int projectId) {
        return projectService.updateProject(project, projectId);
    }

    @CrossOrigin(value = crossOrigin)
    @DeleteMapping("/projects/{id}")
    public String deleteProjectById(@PathVariable("id") int projectId) {
        projectService.deleteProjectById(projectId);

        return "Deleted Project Successfully";
    }
}
