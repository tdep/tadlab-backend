package com.tdep.tadlab.service;


import com.tdep.tadlab.entity.projectDb.Link;
import com.tdep.tadlab.entity.projectDb.Project;
import com.tdep.tadlab.entity.projectDb.ProjectDetail;
import com.tdep.tadlab.entity.projectDb.Test;
import com.tdep.tadlab.repository.LinkRepository;
import com.tdep.tadlab.repository.ProjectDetailRepository;
import com.tdep.tadlab.repository.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectWriteServiceImpl implements ProjectWriteService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectDetailRepository projectDetailRepository;

    @Autowired
    private LinkRepository linkRepository;

    Logger logger = LoggerFactory.getLogger(ProjectWriteServiceImpl.class);

//    Project

//    TODO: creating project always creates projectDetail object (empty)
//    TODO: perhaps that detail object does not get saved to its own table, but instead is just saved
//    TODO: as an object within the project object?
//    TODO: Also, maybe the created at/created by details should exist in the detail object, not the project
    public ResponseEntity<Project> createNewProject(Project project) {
        try {

            Project _project = projectRepository
                    .save(new Project(
                            project.getEntryName(),
                            project.getEntryType(),
                            project.getTitle()
                    ));

            logger.info(String.format("Project: %s created successfully!", _project.getId()));
            return new ResponseEntity<>(_project, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(String.format("Couldn't create Project with error: %s", e.getMessage()));
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Project> test(Project project) {
        try {
            Project _project = projectRepository
                    .save(new Project(
                            project.getTest()
                    ));
            logger.info("test happened");
            return new ResponseEntity<>(_project, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Project> updateExistingProject(int id, Project project) {
        Optional<Project> projectData = projectRepository.findById(id);

        if (projectData.isPresent()) {
            Project _project = projectData.get();
            _project.setEntryName(project.getEntryName());
            _project.setEntryType(project.getEntryType());
            _project.setTitle(project.getTitle());
            _project.setProjectDetail(project.getProjectDetail());
            logger.info("Project updated successfully!");
            return new ResponseEntity<>(projectRepository.save(_project), HttpStatus.OK);
        } else {
            logger.error("Project does not exist.");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<Project> addLinkToProject(int projectId, Link link) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<Project> addMultipleLinksToProject(int projectId, List<Link> links) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<Project> removeLinkFromProject(int projectId, Link link) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<Project> removeAllLinksFromProject(int projectId) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<HttpStatus> deleteProjectById(int projectId) {
        try {
            projectRepository.deleteById(projectId);
            logger.info("Project deleted successfully!");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            logger.error(String.format("Unable to delete this project because: %s", e.getMessage()));
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<HttpStatus> deleteAllProjects() {
        try {
            projectRepository.deleteAll();
            logger.info("All Projects deleted successfully!");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            logger.error(String.format("Unable to delete all projects because: %s", e.getMessage()));
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    Project Detail

    public ResponseEntity<ProjectDetail> createNewProjectDetail(int projectId, ProjectDetail detail) {
        Optional<Project> projectData = projectRepository.findById(projectId);

        try {
            ResponseEntity<ProjectDetail> detailResponseEntity = projectDetailBuilder(projectData, detail);
            ProjectDetail createdProjectDetail = detailResponseEntity.getBody();

            if (projectData.isPresent()) {
                Project _project = projectData.get();
                _project.setProjectDetail(createdProjectDetail);
                projectRepository.save(_project);
                return new ResponseEntity<>(createdProjectDetail, HttpStatus.OK);
            } else {
                logger.error("Project does not exist.");
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error(String.format("Unable to save project details to database because: %s", e.getMessage()));
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ProjectDetail> updateExistingProjectDetail(int projectId, ProjectDetail detail) {
        Optional<Project> projectData = projectRepository.findById(projectId);

        try {
            ResponseEntity<ProjectDetail> detailResponseEntity = projectDetailUpdater(projectData, detail);
            return new ResponseEntity<>(detailResponseEntity.getBody(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error(String.format("Unable to update project detail because: %s", e.getMessage()));
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    Link

    public ResponseEntity<Link> createNewLink(Link link) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<Link> updateExistingLink(int linkId, Link link) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<Link> updateExistingProjectLink(int projectId, Link link) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<HttpStatus> deleteLink(int linkId) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

//    Helper Methods

    private ResponseEntity<ProjectDetail> projectDetailBuilder(Optional<Project> project, ProjectDetail detail) {
        if (project.isPresent()) {
            ProjectDetail _detail = new ProjectDetail(
                    detail.getEntryName(),
                    detail.getEntryType(),
                    detail.getDescription()
            );
            logger.info("Project detail created!");
            return new ResponseEntity<>(projectDetailRepository.save(_detail), HttpStatus.CREATED);
        } else {
            logger.error("Unable to create project detail.");
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private ResponseEntity<ProjectDetail> projectDetailUpdater(Optional<Project> project, ProjectDetail detail) {
        if (project.isPresent()) {
            ProjectDetail _detail = project.get().getProjectDetail();
            _detail.setEntryName(detail.getEntryName());
            _detail.setEntryType(detail.getEntryType());
            _detail.setDescription(detail.getDescription());
            logger.info("Project details updated!");
            return new ResponseEntity<>(projectDetailRepository.save(_detail), HttpStatus.OK);
        } else {
            logger.error("Unable to find project.");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
