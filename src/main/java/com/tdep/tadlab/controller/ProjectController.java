package com.tdep.tadlab.controller;

import com.tdep.tadlab.dao.ProjectDao;
import com.tdep.tadlab.dao.ProjectLinkDao;
import com.tdep.tadlab.dao.ToolDao;
import com.tdep.tadlab.model.Project;
import com.tdep.tadlab.model.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private ProjectLinkDao projectLinkDao;

    @Autowired
    private ToolDao toolDao;

    private final String crossOrigin = "http://localhost:3000";

//    TODO: Change cross origins

    @CrossOrigin(origins = crossOrigin)
    @GetMapping(value = "/projects")
    public List<Project> getAllProjects() {
        return projectDao.getAllProjects();
    }

    @CrossOrigin(origins = crossOrigin)
    @GetMapping(value = "/projects/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable int id) {
        Optional<Project> project = projectDao.getProjectById(id);
        return project.map(ResponseEntity::ok)
                .orElseGet(() ->
                        ResponseEntity.notFound()
                                .build());
    }

    @CrossOrigin(origins = crossOrigin)
    @PostMapping(value = "/projects/new")
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project savedProject = projectDao.save(project);
        return ResponseEntity.created(URI.create("/projects/" + savedProject.getId())).body(savedProject);
    }

    @CrossOrigin(origins = crossOrigin)
    @PutMapping(value = "/projects/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable int id, @RequestBody Project project) {
        Optional<Project> existingProject = projectDao.getProjectById(id);
        if (existingProject.isPresent()) {
            project.setId(id);
            Project savedProject = projectDao.save(project);
            return ResponseEntity.ok(savedProject);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    TODO: Must also remove the links to Tools and delete ProjectLinks
    @CrossOrigin(origins = crossOrigin)
    @DeleteMapping(value = "/projects/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable int id) {
        Optional<Project> project = projectDao.getProjectById(id);
        if (project.isPresent()) {
            projectDao.delete(project.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    TODO: Replace this method following the paradigm above
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "/createProjectForTool/{toolId}")
    public String createProjectForTool(@RequestBody Project entity, @PathVariable(name = "toolId") String toolId) {
        System.out.println("\nCreate a new Project and assign to an existing Tool." + "\n");

//        Create a new Project
        Project project = new Project(entity.getTitle(), entity.getDescription(), entity.getImageUrl());

//        Save the new Project
        project = projectDao.save(project);
        System.out.println("\nSaved project :: " + project + "\n");

//        Get a Tool
        Tool tool = this.toolDao.getToolById(Integer.parseInt(toolId));
        System.out.println("\nTool details :: " + tool.toString() + "\n");

//        Create a Project Set
        Set<Project>  projects = new HashSet<>();
        projects.add(project);

//        Assign Project Set to Tool
        tool.setProject(projects);

//        Save Tool
        tool = toolDao.save(tool);
        System.out.println("\nProject assigned to the Tool." + "\n");

        return "Project saved!";
    }
}
