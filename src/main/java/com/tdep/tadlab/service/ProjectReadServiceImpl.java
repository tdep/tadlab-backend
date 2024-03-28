package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.projectDb.Link;
import com.tdep.tadlab.entity.projectDb.Project;
import com.tdep.tadlab.repository.LinkRepository;
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

//    Links

    public ResponseEntity<List<Link>> findAllLinks() {
        try {
            List<Link> links = new ArrayList<>(
                    linkRepository.findAll());
            if (links.isEmpty()) {
                logger.info("No links found.");
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(links, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(String.format("Could not find links because of exception: %s", e.getMessage()));
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Link> findLinkById(int id) {
        Optional<Link> linkData = linkRepository.findById(id);


        return linkData.map(
                link -> new ResponseEntity<>(
                        link, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(
                        HttpStatus.NOT_FOUND));
    }

}
