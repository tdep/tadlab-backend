package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.Project;
import com.tdep.tadlab.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public ResponseEntity<List<Project>> getAllProjects(String projectName) {
        try {
            List<Project> projects = new ArrayList<Project>();

            if (projectName == null) {
                projects.addAll(projectRepository.findAll());
            } else {
                projects.addAll(projectRepository.findProjectsByName(projectName));
            }
            if (projects.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(projects, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Project> getProjectById(long projectId) {
        Optional<Project> projectData = projectRepository.findById(projectId);

        return projectData.map(
                project -> new ResponseEntity<>(
                        project, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(
                        HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Project> getProjectByName(String projectName) {
        Optional<Project> projectData = projectRepository.findByName(projectName);

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
                            project.getProjectName(),
                            project.getDescription(),
                            project.getEntryId(),
                            project.getEntryType()));
            return new ResponseEntity<>(_project, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Project> updateProject(long projectId, Project project) {
        Optional<Project> projectData = projectRepository.findById(projectId);

        if (projectData.isPresent()) {
            Project _project = projectData.get();
            _project.setProjectName(project.getProjectName());
            _project.setDescription(project.getDescription());
            _project.setEntryId(project.getEntryId());
            _project.setEntryType(project.getEntryType());
            return new ResponseEntity<>(projectRepository.save(_project), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<HttpStatus> deleteProject(long projectId) {
        try {
            projectRepository.deleteById(projectId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<HttpStatus> deleteAllProjects() {
        try {
            projectRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
