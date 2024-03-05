package com.tdep.tadlab.model;

import jakarta.persistence.*;

@Entity
@Table(name="project_links")
public class ProjectLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    private Project project;
    @Column(name = "name")
    private String name;
    @Column(name = "url")
    private String url;

    public ProjectLink() {
    }

    public ProjectLink(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public int getId() { return id; }
    public void setId() { this.id = id; }

    public Project getProject() { return project; }
    public void setProject(Project project) { this.project = project; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    @Override
    public String toString() {
        return "ProjectLink [name=" + name + ", id=" + id + ", url=" + url + "]";
    }
}
