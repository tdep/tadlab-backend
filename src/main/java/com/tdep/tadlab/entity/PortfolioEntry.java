package com.tdep.tadlab.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

@Getter
@Entity
@Table(name = "portfolio_entries")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PortfolioEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "entry_type", name = "entry_type", nullable = false, length = 50)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private EntryType entryType;

    public PortfolioEntry(String name, EntryType entryType) {
        this.name = name;
        this.entryType = entryType;
    }

    public PortfolioEntry() {
    }

    @Override
    public String toString() {
        return  "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", entry_type='" + entryType + '\'' +
                '}';
    }
}
