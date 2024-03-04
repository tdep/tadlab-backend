package com.tdep.tadlab.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private String imageUrl;
    @OneToMany
    private List<ProjectLink> projectLinks;
    @ManyToMany
    @JoinTable(
            name = "project_tools",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "tool_id"))
    private Set<Tool> tools;

    public int getId() { return id;}

    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getImageUrl() { return imageUrl; }

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public List<ProjectLink> getProjectLinks() { return projectLinks; }

    public void setProjectLinks(List<ProjectLink> projectLinks) { this.projectLinks = projectLinks; }

    public Set<Tool> getProjectTools() { return tools; }

    public void setProjectTools(Set<Tool> tools) { this.tools = tools; }
}
