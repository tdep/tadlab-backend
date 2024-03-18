package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.ProjectDetails;
import com.tdep.tadlab.repository.ProjectDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectDetailsServiceImpl implements ProjectDetailsService {

    @Autowired
    private ProjectDetailsRepository projectDetailsRepository;

    public ResponseEntity<List<ProjectDetails>> getAllDetails() {
        try {
            List<ProjectDetails> details = new ArrayList<>(
                    projectDetailsRepository.findAll());

            if (details.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(details, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ProjectDetails> getDetailById(long detailId) {
        Optional<ProjectDetails> detailData = projectDetailsRepository.findById(detailId);

        return detailData.map(
                detail -> new ResponseEntity<>(
                        detail, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(
                        HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<ProjectDetails> createDetail(ProjectDetails details) {
        try {
            ProjectDetails _details = projectDetailsRepository
                    .save(new ProjectDetails(
                            details.getDescription(),
                            details.getCreated(),
                            details.getProject()));
            return new ResponseEntity<>(_details, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ProjectDetails> updateDetail(long detailId, ProjectDetails details) {
        Optional<ProjectDetails> detailData = projectDetailsRepository.findById(detailId);

        if (detailData.isPresent()) {
            ProjectDetails _details = detailData.get();
            _details.setDescription(details.getDescription());
            _details.setCreated(details.getCreated());
            _details.setProject(details.getProject());
            return new ResponseEntity<>(projectDetailsRepository.save(_details), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<HttpStatus> deleteDetail(long detailId) {
        try {
            projectDetailsRepository.deleteById(detailId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<HttpStatus> deleteAllDetails() {
        try {
            projectDetailsRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
