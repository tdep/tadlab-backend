package com.tdep.tadlab.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Entity
@Table(name = "links")
@PrimaryKeyJoinColumn(referencedColumnName = "entry_id")

public class Link extends PortfolioEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "link_id")
    private long id;

    @Setter
    @Column(name = "link_name", nullable = false, length = 50)
    private String linkName;

    @Setter
    @Column(name = "link_type", nullable = false)
    private LinkType linkType;

    @Setter
    @Column(name = "url_id", nullable = false)
    private long urlId;

    @Setter
    @Column(name = "entry_id", nullable = false)
    private long entryId;

    @Setter
    @Column(name = "project_id", nullable = true)
    private long projectId;

    public Link(String linkName, LinkType linkType, long urlId, long entryId, long projectId, EntryType entryType) {
        super(entryType);
        this.linkName = linkName;
        this.linkType = linkType;
        this.urlId = urlId;
        this.entryId = entryId;
        this.projectId = projectId;
    }

    public Link() { super(); }

    @Override
    public String toString() {
        return  "Url{" +
                ", name='" + linkName + '\'' +
                ", link type='" + linkType + '\'' +
                ", url id='" + urlId + '\'' +
                ", entry id='" + entryId + '\'' +
                ", project id='" + projectId + '\'' +
                ", entry type='" + super.getEntryType() + '\'' +
                '}';
    }
}
