package com.tdep.tadlab.service;


import com.tdep.tadlab.entity.projectDb.Link;
import com.tdep.tadlab.entity.projectDb.Project;
import com.tdep.tadlab.entity.projectDb.ProjectDetail;
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
import java.util.concurrent.CompletableFuture;

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

    public ResponseEntity<Project> createNewProject(Project project) {
        try {
            Project _project = projectRepository
                    .save(new Project(
                            project.getEntryName(),
                            project.getEntryType(),
                            project.getTitle()
                    ));
            logger.info(String.format("Project: %s created successfully!", _project.getEntryId()));
            return new ResponseEntity<>(_project, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(String.format("Couldn't create Project with error: %s", e.getMessage()));
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
            return new ResponseEntity<>(projectRepository.save(_project), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<Project> addDetailToProject(int projectId, ProjectDetail detail) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<Project> addLinkToProject(int projectId, Link link) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<Project> addMultipleLinksToProject(int projectId, List<Link> links) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<Project> removeDetailFromProject(int projectId, ProjectDetail detail) {
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

    public CompletableFuture<ResponseEntity<ProjectDetail>> createNewProjectDetail(int projectId, ProjectDetail detail) {
        CompletableFuture<ResponseEntity<ProjectDetail>> suppliedDetail =
                CompletableFuture.supplyAsync(() -> {
                    try {
                        ProjectDetail _detail = projectDetailRepository.save(
                                new ProjectDetail(
                                        detail.getEntryName(),
                                        detail.getEntryType(),
                                        detail.getDescription()));
                        return new ResponseEntity<>(_detail, HttpStatus.OK);
                    } catch (Exception e) {
                        logger.error(String.format("Couldn't create Project Detail with error: %s", e.getMessage()));
                        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                    }
                });
        return suppliedDetail.thenCompose(
                savedDetail -> {
                    try {
                        this.projectDetailSaver(projectId, savedDetail.getBody());
                        return suppliedDetail;
                    } catch (Exception e) {
                        logger.error(String.format("Project details failed to save because: %s", e.getMessage()));
                        return new CompletableFuture<>();
                    }

                });
    }


    public ResponseEntity<ProjectDetail> updateExistingProjectDetail(int projectId, ProjectDetail detail) {
        Optional<Project> projectData = projectRepository.findById(projectId);

        if (projectData.isPresent()) {
            ProjectDetail _detail = projectData.get().getProjectDetail();
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

    public ResponseEntity<HttpStatus> deleteProjectDetailByProjectId(int projectId) {
        Optional<Project> project = projectRepository.findById(projectId);

        if (project.isPresent()) {
            int projectDetailId = project.get().getProjectDetail().getEntryId();
            try {
                projectDetailRepository.deleteById(projectDetailId);
                logger.info("Deleted project data successfully!");
            } catch (Exception e) {
                logger.error(String.format("Unable to delete project details because: %s", e.getMessage()));
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<HttpStatus> deleteProjectDetailByProjectName(String projectName) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
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

    private void projectDetailSaver(int projectId, ProjectDetail detail) {
        Optional<Project> project = projectRepository.findById(projectId);

        if (project.isPresent()) {
            Project _project = project.get();
            _project.setEntryName(project.get().getEntryName());
            _project.setEntryType(project.get().getEntryType());
            _project.setTitle(project.get().getTitle());
            _project.setProjectDetail(detail);
            _project.setEntryId(projectId);
            new ResponseEntity<>(_project, HttpStatus.OK);
        } else {
            new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
