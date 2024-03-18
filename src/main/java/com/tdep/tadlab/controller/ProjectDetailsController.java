package com.tdep.tadlab.controller;

//TODO: Change cross origins

import com.tdep.tadlab.entity.ProjectDetails;
import com.tdep.tadlab.service.ProjectDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class ProjectDetailsController {

    @Autowired private ProjectDetailsService projectDetailsService;

    @GetMapping("/prodetails")
    public ResponseEntity<List<ProjectDetails>> getAllDetails() {
        return projectDetailsService.getAllDetails();
    }

    @GetMapping("/prodetails/{id}")
    public ResponseEntity<ProjectDetails> getDetailById(@PathVariable("id") long detailId) {
        return projectDetailsService.getDetailById(detailId);
    }

    @PostMapping("/prodetails")
    public ResponseEntity<ProjectDetails> createDetail(@RequestBody ProjectDetails details) {
        return projectDetailsService.createDetail(details);
    }

    @PutMapping("/prodetails/{id}")
    public ResponseEntity<ProjectDetails> updateDetails(@PathVariable("id") long detailId, @RequestBody ProjectDetails detail) {
        return projectDetailsService.updateDetail(detailId, detail);
    }

    @DeleteMapping("/prodetails/{id}")
    public ResponseEntity<HttpStatus> deleteDetailById(@PathVariable("id") long detailId) {
        return projectDetailsService.deleteDetail(detailId);
    }

    @DeleteMapping("/prodetails")
    public ResponseEntity<HttpStatus> deleteAllProjectDetails() {
        return projectDetailsService.deleteAllDetails();
    }
}
