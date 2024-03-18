package com.tdep.tadlab.repository;

import com.tdep.tadlab.entity.PortfolioEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PortfolioEntryRepository extends JpaRepository<PortfolioEntry, Long> {

    List<PortfolioEntry> findPortfolioEntriesByName(String name);

    Optional<PortfolioEntry> findByName(String name);
}
