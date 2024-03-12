package com.tdep.tadlab.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.Type;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
@Table(name = "portfolio_entries")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PortfolioEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "entry_type", name = "entry_type", nullable = false, length = 255)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private EntryType entryType;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "portfolio_entry_urls",
            joinColumns = { @JoinColumn(name = "portfolio_entry_id") },
            inverseJoinColumns = { @JoinColumn(name = "url_id") },
            uniqueConstraints = {
                    @UniqueConstraint(
                            columnNames = { "portfolio_entry_id", "url_id"}
                    )
            }
    )
    private Set<Url> urls = new HashSet<>();

    public PortfolioEntry(String name, EntryType entryType) {
        this.name = name;
        this.entryType = entryType;
    }

    public PortfolioEntry() {
    }

    public void addUrl(Url url) {
        boolean added = urls.add(url);
        if(added) {
            url.getPortfolioEntries().add(this);
        }
    }

    public void removeUrl(Url url) {
        boolean removed = urls.remove(url);
        if(removed) {
            url.getPortfolioEntries().remove(this);
        }
    }

    public Set<Url> getUrls() {
        return urls;
    }

    public void setUrls(Set<Url> urls) {
        this.urls = urls;
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
