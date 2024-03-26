package com.tdep.tadlab.entity.projectDb;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

@Embeddable
public class Link {

    private String name;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "linktype", name = "link_type", nullable = false, length = 50)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private LinkType linkType;
    private String url;

    public Link(String name, LinkType linkType, String url) {
        this.name = name;
        this.linkType = linkType;
        this.url = url;
    }

    public Link() {

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

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return  "{" +
                ", link name='" + name + '\'' +
                ", link type='" + linkType + '\'' +
                ", url ='" + url + '\'' +
                '}';
    }
}

