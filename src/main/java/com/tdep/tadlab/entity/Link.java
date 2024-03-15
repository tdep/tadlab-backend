package com.tdep.tadlab.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Entity
@Getter
@Table(name = "links")
public class Link extends PortfolioEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Setter
    @Column(name = "url_id", nullable = false)
    private Long urlId;

    @Setter
    @Column(name = "entry_id", nullable = false)
    private Long entryId;

    @Setter
    @Column(name = "link_type", nullable = false)
    private LinkType linkType;

    @Setter
    @Column(name = "project_id", nullable = true)
    private Long projectId;

    public Link(String name, EntryType entryType) {
        super(name, entryType);
    }

    public Link() {
    }

    public Link(String name, Long urlId, Long entryId, LinkType linkType, Long projectId) {
        this.urlId = urlId;
        this.entryId = entryId;
        this.linkType = linkType;
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return  "Url{" +
                ", name='" + super.getName() + '\'' +
                ", entry type='" + super.getEntryType() + '\'' +
                ", link type='" + linkType + '\'' +
                ", entry id='" + entryId + '\'' +
                ", url id='" + urlId + '\'' +
                ", project id='" + projectId + '\'' +
                '}';
    }
}
