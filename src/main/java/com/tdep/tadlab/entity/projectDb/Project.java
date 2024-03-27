package com.tdep.tadlab.entity.projectDb;

import com.tdep.tadlab.entity.common.BasePortfolioEntryAudit;
import com.tdep.tadlab.entity.common.EntryType;
import jakarta.persistence.*;

import java.util.*;


@Entity
@Table(name = "projects")
public class Project extends BasePortfolioEntryAudit {

    @Column(name = "title")
    private String title;

    @Embedded
    private Author author;

    @Embedded
    private ProjectDetail projectDetail;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "project_links",
            joinColumns = { @JoinColumn(name = "fk_project")},
            inverseJoinColumns = @JoinColumn(name = "fk_link"))
    private Set<Link> links = new HashSet<Link>();



    // Initializing Constructor
    public Project(
            String entryName,
            EntryType entryType,
            String createdBy,
            Date createdAt,
            String title,
            Author author,
            ProjectDetail projectDetail,
            Set<Link> links) {
        super.setEntryName(entryName);
        super.setEntryType(entryType);
        super.setCreatedBy(createdBy);
        super.setCreatedAt(createdAt);
        this.title = title;
        this.author = author;
        this.projectDetail = projectDetail;
        this.links = links;
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

    public Set<Link> getLinks() {
        return links;
    }

    public void setLinks(Set<Link> links) {
        this.links = links;
    }

    public void addLink(Link link) {
        this.links.add(link);
    }

    public void removeLink(Link link) {
        this.links.remove(link);
    }


    @Override
    public String toString() {
        return  "{" +
                "title='" + title + '\'' +
                '}' +
                super.toString();
    }
}
