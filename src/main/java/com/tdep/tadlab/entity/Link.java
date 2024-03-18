package com.tdep.tadlab.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

import java.util.Optional;

@Getter
@Entity(name = "Link")
@Table(name = "links")
public class Link extends PortfolioEntry {

    @Setter
    private String linkName;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "link_type", name = "link_type", nullable = false, length = 50)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private LinkType linkType;

    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Tool tool;

    @Setter
    private String url;

    public Link(String linkName, LinkType linkType, Project project, Tool tool, String url) {
        this.linkName = linkName;
        this.linkType = linkType;
        this.project = project;
        this.tool = tool;
        this.url = url;
    }

    public Link() {

    }

    public void setProject(Project project) {
        this.project = project;
        project.addLink(this);
    }

    public void removeProject() {
        this.project.removeLink(this);
        this.project = null;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
        tool.setLink(this);
    }

    public void removeTool() {
        this.tool.removeLink();
        this.tool = null;
    }

    @Override
    public String toString() {
        return  "Link{" +
                " id=" + this.getEntryId() +
                " name=" + linkName +
                ", project='" + project + '\'' +
                ", tool='" + tool + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
