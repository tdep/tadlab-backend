package com.tdep.tadlab.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "projects")
@AllArgsConstructor
@Builder
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany (fetch = FetchType.LAZY)
    @JoinColumn (name = "project_id", referencedColumnName = "id")
    private Set<ProjectLink> projectLinks;

//    @OneToMany
//    private List<ProjectLink> projectLinks;
//    @ManyToMany(
//            fetch = FetchType.LAZY,
//            cascade = {
//                    CascadeType.PERSIST,
//                    CascadeType.MERGE,
//                    CascadeType.DETACH,
//                    CascadeType.REFRESH })
//    @JoinTable(
//            name = "project_tools",
//            joinColumns = @JoinColumn(name = "project_id"),
//            inverseJoinColumns = @JoinColumn(name = "tool_id"))
//    private Set<Tool> tools;

    public Project() {
    }

    public Project(String title, String description, String imageUrl) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public int getId() { return id;}
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public Set<ProjectLink> getProjectLinks() {
        return projectLinks;
    }

//    public List<ProjectLink> getProjectLinks() { return projectLinks; }
//    public void setProjectLinks(List<ProjectLink> projectLinks) { this.projectLinks = projectLinks; }
//
//    public Set<Tool> getProjectTools() { return tools; }
//    public void setProjectTools(Set<Tool> tools) { this.tools = tools; }

    @Override
    public String toString() {
        return "Project [" +
                "title=" + title + ", id=" + id +
                ", description=" + description +
                ", imageUrl=" + imageUrl + "]";
    }
}

