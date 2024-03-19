package com.tdep.tadlab.entity.common;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

import java.io.Serializable;
import java.util.UUID;


@MappedSuperclass
public class BasePortfolioEntry implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private int id;

    @Column(name = "entry_name")
    private String entryName;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "entrytype", name = "entry_type", nullable = false, length = 50)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private EntryType entryType;

    public BasePortfolioEntry(String entryName, EntryType entryType) {
        this.entryName = entryName;
        this.entryType = entryType;
    }

    public BasePortfolioEntry() {

    }

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public int getEntryId() {
        return id;
    }

    public void setEntryId(int id) {
        this.id = id;
    }

    public EntryType getEntryType() {
        return entryType;
    }

    public void setEntryType(EntryType entryType) {
        this.entryType = entryType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BasePortfolioEntry that)) return false;
        return id == that.id;
    }

    @Override
    public String toString() {
        return  "{" +
                "entry id='" + id + '\'' +
                ", entry name='" + entryName + '\'' +
                ", entry type='" + entryType + '\'' +
                '}' +
                super.toString();
    }
}
