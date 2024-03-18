package com.tdep.tadlab.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity(name = "Project")
@Table(name = "projects")
public class Project extends PortfolioEntry {

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "projects", cascade = CascadeType.ALL)
    @Column(name = "tools")
    private List<Tool> tools = new ArrayList<>();

    @OneToOne(mappedBy = "projects", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Column(name = "details")
    private ProjectDetails projectDetails;

    @ManyToMany
    @JoinTable(
            name = "project_links",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "link_id")
    )
    @Column(name = "links")
    private Set<Link> links = new HashSet<>();

    public Project(String title, List<Tool> tools, ProjectDetails details, Set<Link> links) {
        this.title = title;
        this.tools = tools;
        this.projectDetails = details;
        this.links = links;
    }

    public Project() {

    }

//    Getters & Setters

    public void addTool(Tool tool) {
        tools.add(tool);
        tool.setProject(this);
    }

    public void removeTool(Tool tool) {
        tools.remove(tool);
        tool.removeProject();
    }

    public void addDetails(ProjectDetails projectDetails) {
        this.projectDetails = projectDetails;
        projectDetails.setProject(this);
    }

    public void removeDetails() {
        this.projectDetails.removeProject();
        this.projectDetails = null;
    }

    public void addLink(Link link) {
        links.add(link);
        link.setProject(this);
    }

    public void removeLink(Link link) {
        links.remove(link);
        link.removeProject();
    }


    @Override
    public String toString() {
        return  "Project{" +
                ", id='" + this.getEntryId() + '\'' +
                ", title='" + title + '\'' +
                ", details='" + projectDetails.toString() + '\'' +
                ", tools='" + tools.stream().map(Tool::toString) + '\'' +
                ", links='" + links.stream().map(Link::toString) + '\'' +
                '}';
    }
}

