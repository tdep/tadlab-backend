package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.ProjectLink;
import com.tdep.tadlab.repository.ProjectLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProjectLinkServiceImpl implements ProjectLinkService {

    @Autowired
    private ProjectLinkRepository projectLinkRepository;

    @Override
    public ProjectLink saveProjectLink(ProjectLink projectLink) {
        return projectLinkRepository.save(projectLink);
    }

    @Override
    public List<ProjectLink> fetchProjectLinkList() {
        return (List<ProjectLink>) projectLinkRepository.findAll();
    }

    @Override
    public ProjectLink updateProjectLink(ProjectLink projectLink, int projectLinkId) {
        ProjectLink projectLinkDB = null;

        if (projectLinkRepository.findById(projectLinkId).isPresent()) {
            projectLinkDB = projectLinkRepository.findById(projectLinkId).get();

            if (Objects.nonNull(projectLink.getName())
            && !"".equalsIgnoreCase(
                    projectLink.getName())) {
                projectLinkDB.setName(
                        projectLink.getName());
            }

            if (Objects.nonNull(projectLink.getUrl())
            && !"".equalsIgnoreCase(
                    projectLink.getUrl())) {
                projectLinkDB.setUrl(
                        projectLink.getUrl());
            }

//            if (Objects.nonNull(projectLink.getProject())) {
//                projectLinkDB.setProject(
//                        projectLink.getProject());
//            }
        }

        assert projectLinkDB != null;
        return projectLinkRepository.save(projectLinkDB);
    }

    @Override
    public void deleteProjectLinkById(int projectLinkId) {
        projectLinkRepository.deleteById(projectLinkId);
    }
}
