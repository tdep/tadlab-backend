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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectReadServiceImpl implements ProjectReadService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectDetailRepository projectDetailRepository;

    @Autowired
    private LinkRepository linkRepository;

    Logger logger = LoggerFactory.getLogger(ProjectWriteServiceImpl.class);

//    Project

    public ResponseEntity<List<Project>> findAllProjects() {
        try {
            List<Project> projects = new ArrayList<>(
                    projectRepository.findAll());
            if (projects.isEmpty()) {
                logger.info("No projects found.");
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(projects, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(String.format("Could not find projects because of exception: %s", e.getMessage()));
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Project> findProjectById(int id) {
        Optional<Project> projectData = projectRepository.findById(id);

        return projectData.map(
                project -> new ResponseEntity<>(
                        project, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(
                        HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Project> findProjectByName(String name) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<List<Project>> findProjectsByLinkType(String linkType) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<List<Project>> findProjectsByDate(String date) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

//    Project Detail

    public ResponseEntity<List<ProjectDetail>> findAllProjectDetails() {
        try {
            List<ProjectDetail> details = new ArrayList<>(
                    projectDetailRepository.findAll());
            if (details.isEmpty()) {
                logger.info("No project details found");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(details, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(String.format("Could not find project details because of exception: %s", e.getMessage()));
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ProjectDetail> findDetailById(int id) {
        Optional<ProjectDetail> projectDetailData = projectDetailRepository.findById(id);

        return projectDetailData.map(
                detail -> new ResponseEntity<>(
                        detail, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(
                        HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<ProjectDetail> findDetailByProjectName(String projectName) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<ProjectDetail> findDetailByProjectId(int projectId) {
        Optional<Project> project = projectRepository.findById(projectId);

        if (project.isPresent()) {
            int projectDetailId = project.get().getProjectDetail().getId();
            Optional<ProjectDetail> projectDetailData = projectDetailRepository.findById(projectDetailId);

            return projectDetailData.map(
                    detail -> new ResponseEntity<>(
                            detail, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(
                            HttpStatus.NOT_FOUND));
        }
        logger.error(String.format("There is no project with id: %s", projectId));
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

//    Link

    public ResponseEntity<List<Link>> findAllLinks() {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<Link> findLinkById(int id) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<Link> findLinkByType(String type) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<List<Link>> findLinksByProjectName(String projectName) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<List<Link>> findLinksByProjectId(int projectId) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }
}
