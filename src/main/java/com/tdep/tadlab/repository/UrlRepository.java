package com.tdep.tadlab.repository;

import com.tdep.tadlab.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    List<Url> findUrlsByName(String name);

    Optional<Url> findByName(String name);
}
