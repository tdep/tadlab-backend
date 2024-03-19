package com.tdep.tadlab.entity.projectDb;

import com.tdep.tadlab.entity.common.BasePortfolioEntryAudit;
import com.tdep.tadlab.entity.common.EntryType;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

@Entity
@Table(name = "links")
public class Link extends BasePortfolioEntryAudit {

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "linktype", name = "link_type", nullable = false, length = 50)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private LinkType linkType;

    @Column(name = "url")
    private String url;

    public Link(String entryName, EntryType entryType, LinkType linkType, String url) {
        super.setEntryName(entryName);
        super.setEntryType(entryType);
        this.linkType = linkType;
        this.url = url;
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

    @Override
    public String toString() {
        return  "{" +
                ", link type='" + linkType + '\'' +
                ", url ='" + url + '\'' +
                '}' +
                super.toString();
    }
}

