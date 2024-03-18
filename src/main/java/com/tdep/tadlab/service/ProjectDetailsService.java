package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.ProjectDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectDetailsService {

    ResponseEntity<List<ProjectDetails>> getAllDetails();

    ResponseEntity<ProjectDetails> getDetailById(long detailId);

    ResponseEntity<ProjectDetails> createDetail(ProjectDetails projectDetails);

    ResponseEntity<ProjectDetails> updateDetail(long detailId, ProjectDetails details);

    ResponseEntity<HttpStatus> deleteDetail(long detailId);

    ResponseEntity<HttpStatus> deleteAllDetails();
}
