package com.tdep.tadlab.controller;

import com.tdep.tadlab.entity.ProjectLink;
import com.tdep.tadlab.service.ProjectLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProjectLinkController {

    @Autowired private ProjectLinkService projectLinkService;

    private final String crossOrigin = "http://localhost:3000";

    @CrossOrigin(value = crossOrigin)
    @PostMapping("/projectLinks")
    public ProjectLink saveProjectLink(
            @Validated @RequestBody ProjectLink projectLink) {
        return projectLinkService.saveProjectLink(projectLink);
    }

    @CrossOrigin(value = crossOrigin)
    @GetMapping("/projectLinks")
    public List<ProjectLink> fetchProjectLinkList() {
        return projectLinkService.fetchProjectLinkList();
    }

    @CrossOrigin(value = crossOrigin)
    @PutMapping("/projectLinks/{id}")
    public ProjectLink updateProjectLink(@RequestBody ProjectLink projectLink,
                                         @PathVariable("id") int projectLinkId) {
        return projectLinkService.updateProjectLink(projectLink, projectLinkId);
    }

    @CrossOrigin(value = crossOrigin)
    @DeleteMapping("/projectLinks/{id}")
    public String deleteProjectLinkById(@PathVariable("id") int projectLinkId) {
        projectLinkService.deleteProjectLinkById(projectLinkId);

        return "Deleted Project Link Successfully";
    }
}
