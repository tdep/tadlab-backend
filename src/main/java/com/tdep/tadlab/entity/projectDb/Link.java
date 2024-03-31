package com.tdep.tadlab.entity.projectDb;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "links")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "link_name")
    private String name;

    @Column(name = "link_url")
    private String url;

    public Link(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public Link() {

    }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return  "{" +
                "link id='" + id + '\'' +
                ", link name='" + name + '\'' +
                ", url ='" + url + '\'' +
                '}';
    }
}

