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

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "entrytype", name = "entry_type", nullable = false, length = 50)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private EntryType entryType;

    public PortfolioEntry(EntryType entryType) {
        this.entryType = entryType;
    }

    public PortfolioEntry() {

    }

    public long getEntryId() {
        return this.entryId;
    }

    public void setEntryId(long entryId) {
        this.entryId = entryId;
    }

    public EntryType getEntryType() {
        return this.entryType;
    }

    public void setEntryType(EntryType entryType) {
        this.entryType = entryType;
    }

    @Override
    public String toString() {
        return  "{" +
                "entry id=" + entryId +
                ", entry_type='" + entryType + '\'' +
                '}';
    }
}
