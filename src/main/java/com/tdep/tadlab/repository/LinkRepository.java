package com.tdep.tadlab.repository;

import com.tdep.tadlab.entity.projectDb.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LinkRepository extends JpaRepository<Link, Integer> {

}
