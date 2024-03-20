package com.tdep.tadlab.entity.projectDb;

import com.tdep.tadlab.entity.common.BasePortfolioEntryAudit;
import com.tdep.tadlab.entity.common.EntryType;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

import java.util.Objects;

@Entity
@Table(name = "links")
public class Link extends BasePortfolioEntryAudit {

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "linktype", name = "link_type", nullable = false, length = 50)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private LinkType linkType;

    @Column(name = "url")
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;

    public Link(String entryName, EntryType entryType, LinkType linkType, String url, Project project) {
        super.setEntryName(entryName);
        super.setEntryType(entryType);
        this.linkType = linkType;
        this.url = url;
        this.project = project;
    }

    public Link() {

    }

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

    public Project getProject() { return project; }

    public void setProject(Project project) { this.project = project; }

    @Override
    public boolean equals(Object o) {
        int id = super.getEntryId();
        if (this == o) return true;
        if (!(o instanceof Link)) return false;
        return (id != 0) && id == ((Link) o).getEntryId();
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return  "{" +
                ", link type='" + linkType + '\'' +
                ", url ='" + url + '\'' +
                ", project ='" + project.getTitle() + '\'' +
                '}' +
                super.toString();
    }
}

