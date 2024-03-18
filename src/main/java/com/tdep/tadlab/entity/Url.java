package com.tdep.tadlab.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "urls")
@PrimaryKeyJoinColumn(referencedColumnName = "entry_id")
public class Url extends PortfolioEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "url_id")
    private long urlId;

    @Setter
    @Column(name = "url_name")
    private String urlName;

    @Setter
    @Column(name = "url")
    private String url;

    @Setter
    @Column(name = "entry_id")
    private long entryId;

    public Url(String urlName, String url, long entryId, String entryName, EntryType entryType) {
        super(entryName, entryType);
        this.urlName = urlName;
        this.url = url;
        this.entryId = entryId;
    }

    public Url() { super(); }

    @Override
    public String toString() {
        return  "Url{" +
                ", url name='" + urlName + '\'' +
                ", url='" + url + '\'' +
                ", entry id='" + entryId + '\'' +
                ", entry type='" + super.getEntryType() + '\'' +
                '}';
    }
}
