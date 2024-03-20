package com.tdep.tadlab.service;

// TODO: Create Logger to replace sysout

import com.tdep.tadlab.entity.projectDb.Project;
import com.tdep.tadlab.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public ResponseEntity<List<Project>> getAllProjects() {
        try {
            List<Project> projects = new ArrayList<>(
                    projectRepository.findAll());
            if (projects.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(projects, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Project> getProjectById(int id) {
        Optional<Project> projectData = projectRepository.findById(id);

        return projectData.map(
                project -> new ResponseEntity<>(
                        project, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(
                        HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Project> createProject(Project project) {
        try {
            Project _project = projectRepository
                    .save(new Project(
                            project.getEntryName(),
                            project.getEntryType(),
                            project.getTitle(),
                            project.getDetail(),
                            project.getLinks()
                    ));
            System.out.println(project);
            return new ResponseEntity<>(_project, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Project> updateProject(int id, Project project) {
        Optional<Project> projectData = projectRepository.findById(id);

        if (projectData.isPresent()) {
            System.out.println(projectData.get());
            Project _project = projectData.get();
            _project.setEntryName(project.getEntryName());
            _project.setEntryType(project.getEntryType());
            _project.setTitle(project.getTitle());
            _project.setDetail(project.getDetail());
            _project.setLinks(project.getLinks());
            return new ResponseEntity<>(projectRepository.save(_project), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<HttpStatus> deleteProject(int id) {
        try {
            projectRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<HttpStatus> deleteAllProjects() {
        try {
            projectRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
