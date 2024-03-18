package com.tdep.tadlab.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

import java.io.Serializable;

@MappedSuperclass
public abstract class PortfolioEntry  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entry_id")
    private long id;

    @Setter
    @Column(name = "entry_name")
    private String entryName;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "entry_type", name = "entry_type", nullable = false, length = 50)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private EntryType entryType;

    public String getName() {
        return entryName;
    }

    @Override
    public String toString() {
        return  "{" +
                "id=" + id +
                ", name='" + entryName + '\'' +
                ", entry_type='" + entryType + '\'' +
                '}';
    }
}
