package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.projectDb.Project;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectReadService {

//    Project
    ResponseEntity<List<Project>> findAllProjects();
    ResponseEntity<Project> findProjectById(int id);
    ResponseEntity<Project> findProjectByName(String name);
    ResponseEntity<List<Project>> findProjectsByLinkType(String linkType);
    ResponseEntity<List<Project>> findProjectsByDate(String date);

}
