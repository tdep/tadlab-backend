package com.tdep.tadlab.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

import java.io.Serializable;

@Entity(name = "PortfolioEntry")
@Table(name = "portfolio_entry")
public class PortfolioEntry  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entry_id")
    private long entryId;

    @Column(name = "entry_name")
    private String entryName;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "entrytype", name = "entry_type", nullable = true, length = 50)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private EntryType entryType;

    public PortfolioEntry(String entryName, EntryType entryType) {
        this.entryName = entryName;
        this.entryType = entryType;
    }

    public PortfolioEntry() {

    }

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public long getEntryId() {
        return entryId;
    }

    public void setEntryId(long entryId) {
        this.entryId = entryId;
    }

    public EntryType getEntryType() {
        return entryType;
    }

    public void setEntryType(EntryType entryType) {
        this.entryType = entryType;
    }

    @Override
    public String toString() {
        return  "{" +
                "entry id='" + entryId + '\'' +
                ", entry name='" + entryName + '\'' +
                ", entry type='" + entryType + '\'' +
                '}';
    }
}
