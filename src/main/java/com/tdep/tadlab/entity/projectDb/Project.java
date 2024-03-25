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

    private ProjectDetail projectDetail;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "TEST_FN")),
            @AttributeOverride(name = "lastName", column = @Column(name = "TEST_LN"))
    })
    private Test test;

    @OneToMany(
            mappedBy = "project",
            cascade = CascadeType.ALL,
            orphanRemoval = false
    )
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    @Column(name = "links", nullable = true)
    private List<Link> links = new ArrayList<>();

    // Initializing Constructor
    public Project(String entryName, EntryType entryType, String title) {
        super.setEntryName(entryName);
        super.setEntryType(entryType);
        this.title = title;
    }

    public Project(Test test) {
        this.test = test;
    }


    public Project() {

    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    @OneToOne
    public ProjectDetail getProjectDetail() {
        return projectDetail;
    }

    public void setProjectDetail(ProjectDetail projectDetail) {
        this.projectDetail = projectDetail;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
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
