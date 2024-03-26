package com.tdep.tadlab.service;


import com.tdep.tadlab.entity.projectDb.Link;
import com.tdep.tadlab.entity.projectDb.Project;
import com.tdep.tadlab.repository.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectWriteServiceImpl implements ProjectWriteService {

    @Autowired
    private ProjectRepository projectRepository;

    Logger logger = LoggerFactory.getLogger(ProjectWriteServiceImpl.class);

//    Project

    public ResponseEntity<Project> createNewProject(Project project) {
        try {

            Project _project = projectRepository
                    .save(new Project(
                            project.getEntryName(),
                            project.getEntryType(),
                            project.getCreatedBy(),
                            project.getCreatedAt(),
                            project.getTitle(),
                            project.getAuthor(),
                            project.getProjectDetail(),
                            project.getLinks()
                    ));

            logger.info(String.format("Project: %s created successfully!", _project.getId()));
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
            _project.setUpdatedBy(project.getUpdatedBy());
            _project.setUpdatedAt(project.getUpdatedAt());
            _project.setTitle(project.getTitle());
            _project.setAuthor(project.getAuthor());
            _project.setProjectDetail(project.getProjectDetail());
            _project.setLinks(project.getLinks());
            logger.info("Project updated successfully!");
            return new ResponseEntity<>(projectRepository.save(_project), HttpStatus.OK);
        } else {
            logger.error("Project does not exist.");
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<Project> addLinkToProject(int projectId, Link link) {
        Optional<Project> projectData = projectRepository.findById(projectId);

        if (projectData.isPresent()) {
            Link _link = new Link(
                    link.getName(),
                    link.getLinkType(),
                    link.getUrl()
            );
            Project _project = projectData.get();
            _project.addLink(_link);
            logger.info("Link successfully added to project!");
            return new ResponseEntity<>(projectRepository.save(_project), HttpStatus.OK);
        } else {
            logger.error("Project does not exist, unable to add new link.");
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Project> addMultipleLinksToProject(int projectId, List<Link> links) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<Project> removeLinkFromProject(int projectId, Link link) {
        Optional<Project> projectData = projectRepository.findById(projectId);

        if (projectData.isPresent()) {
            Project _project = projectData.get();
            Link linkData = findLinkByName(_project, link.getName());
            Link _link = new Link(
                    linkData.getName(),
                    linkData.getLinkType(),
                    linkData.getUrl()
            );
            _project.removeLink(_link);
            return new ResponseEntity<>(projectRepository.save(_project), HttpStatus.OK);
        } else {
            logger.error("Project does not exist, unable to remove link.");
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

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

//    Helper Methods

    private Link findLinkByName(Project project, String name) {

            List<Link> links = project.getLinks();
            Link _link = new Link();

            links.forEach(link -> {
                if (link.getName().equals(name)) {
                    _link.setName(link.getName());
                    _link.setLinkType(link.getLinkType());
                    _link.setUrl(link.getUrl());
                }
            });
            return _link;

    }
}
