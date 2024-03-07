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
    private final String crossOrigin = "PostmanRuntime/7.36.3";

    @CrossOrigin(value = crossOrigin)
    @PostMapping("/projectlinks")
    public ProjectLink saveProjectLink(
            @Validated @RequestBody ProjectLink projectLink) {
        return projectLinkService.saveProjectLink(projectLink);
    }

    @CrossOrigin(value = crossOrigin)
    @GetMapping("/projectlinks")
    public List<ProjectLink> fetchProjectLinkList() {
        return projectLinkService.fetchProjectLinkList();
    }

    @CrossOrigin(value = crossOrigin)
    @PutMapping("/projectlinks/{id}")
    public ProjectLink updateProjectLink(@RequestBody ProjectLink projectLink,
                                         @PathVariable("id") int projectLinkId) {
        return projectLinkService.updateProjectLink(projectLink, projectLinkId);
    }

    @CrossOrigin(value = crossOrigin)
    @DeleteMapping("/projectlinks/{id}")
    public String deleteProjectLinkById(@PathVariable("id") int projectLinkId) {
        projectLinkService.deleteProjectLinkById(projectLinkId);

        return "Deleted Project Link Successfully";
    }
}
