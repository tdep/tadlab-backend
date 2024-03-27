package com.tdep.tadlab.entity.projectDb;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "links")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "link_name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "linktype", name = "link_type", nullable = false, length = 50)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private LinkType linkType;

    @Column(name = "link_url")
    private String url;

    @ManyToMany(mappedBy = "links")
    @Cascade({org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE})
    private Set<Project> projects = new HashSet<Project>();

    public Link(String name, LinkType linkType, String url, Set<Project> projects) {
        this.name = name;
        this.linkType = linkType;
        this.url = url;
        this.projects = projects;
    }

    public Link() {

    }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public LinkType getLinkType() {
        return linkType;
    }

    public void setLinkType(LinkType linkType) {
        this.linkType = linkType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public void addProject(Project project) {
        this.projects.add(project);
        project.getLinks().add(this);
    }

    public void removeProject(Project project) {
        this.projects.remove(project);
        project.getLinks().remove(this);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return  "{" +
                "link id='" + id + '\'' +
                ", link name='" + name + '\'' +
                ", link type='" + linkType + '\'' +
                ", url ='" + url + '\'' +
                '}';
    }
}

