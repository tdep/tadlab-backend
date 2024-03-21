package com.tdep.tadlab.entity.projectDb;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tdep.tadlab.entity.common.BasePortfolioEntryAudit;
import com.tdep.tadlab.entity.common.EntryType;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project extends BasePortfolioEntryAudit {

    @Column(name = "title")
    private String title;

    @OneToOne(
            mappedBy = "project",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @PrimaryKeyJoinColumn(name = "detail")
    private ProjectDetail detail;

    @OneToMany(
            mappedBy = "project",
            cascade = CascadeType.ALL,
            orphanRemoval = false
    )
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    @Column(name = "links", nullable = true)
    private List<Link> links = new ArrayList<>();

    public Project(String entryName, EntryType entryType, String title, ProjectDetail detail, List<Link> links) {
        super.setEntryName(entryName);
        super.setEntryType(entryType);
        this.title = title;
        this.detail = detail;
        this.links = links;
    }

    public Project() {

    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public ProjectDetail getDetail() { return detail; }

    public void setDetail(ProjectDetail detail) { this.detail = detail; }

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
                ", details ='" + detail + '\'' +
                '}' +
                super.toString();
    }
}
