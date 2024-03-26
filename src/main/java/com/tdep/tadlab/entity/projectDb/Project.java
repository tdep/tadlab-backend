package com.tdep.tadlab.entity.projectDb;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tdep.tadlab.entity.common.BasePortfolioEntryAudit;
import com.tdep.tadlab.entity.common.EntryType;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project extends BasePortfolioEntryAudit {

    @Column(name = "title")
    private String title;

    @Embedded
    private Author author;

    @Embedded
    private ProjectDetail projectDetail;

    @OneToMany(
            mappedBy = "project",
            cascade = CascadeType.ALL,
            orphanRemoval = false
    )
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    @Column(name = "links", nullable = true)
    private List<Link> links = new ArrayList<>();

    // Initializing Constructor
    public Project(
            String entryName,
            EntryType entryType,
            String createdBy,
            Date createdAt,
            String title,
            Author author,
            ProjectDetail projectDetail) {
        super.setEntryName(entryName);
        super.setEntryType(entryType);
        super.setCreatedBy(createdBy);
        super.setCreatedAt(createdAt);
        this.title = title;
        this.author = author;
        this.projectDetail = projectDetail;
    }

    public Project() {

    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public ProjectDetail getProjectDetail() {
        return projectDetail;
    }

    public void setProjectDetail(ProjectDetail projectDetail) {
        this.projectDetail = projectDetail;
    }

    public List<Link> getLinks() {
        return this.links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public void addLink(Link link) {
        links.add(link);
        link.setProject(this);
    }

    public void removeLink(Link link) {
        links.remove(link);
        link.setProject(null);
    }
    @Override
    public String toString() {
        return  "{" +
                ", title='" + title + '\'' +
                '}' +
                super.toString();
    }
}
