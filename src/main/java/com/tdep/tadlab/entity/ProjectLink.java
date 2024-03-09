package com.tdep.tadlab.entity;

import jakarta.persistence.*;

@Entity
@Table(name="project_links")
public class ProjectLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "url")
    private String url;
    @Column(name = "link_type")
    private String linkType;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public ProjectLink() {
    }

    public ProjectLink(String name, String url, String linkType, Project project) {
        this.name = name;
        this.url = url;
        this.linkType = linkType;
        this.project = project;
    }

    public int getId() { return id; }
    public void setId() { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getLinkType() { return linkType; }
    public void setLinkType(String linkType) { this.linkType = linkType; }

    public Project getProjectId() { return project; }
    public void setProjectId(Project project) { this.project = project; }

    @Override
    public String toString() {
        return "ProjectLink [name=" + name + ", id=" + id + ", url=" + url + "]";
    }
}
