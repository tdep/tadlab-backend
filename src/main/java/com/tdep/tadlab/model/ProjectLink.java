package com.tdep.tadlab.model;

import jakarta.persistence.*;

@Entity
@Table(name="project_links")
public class ProjectLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Project project;
    private String name;
    private String url;

    public int getId() { return id; }

    public void setId() { this.id = id; }

    public Project getProject() { return project; }

    public void setProject(Project project) { this.project = project; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }
}
