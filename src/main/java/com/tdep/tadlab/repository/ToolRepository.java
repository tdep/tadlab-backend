package com.tdep.tadlab.repository;

import com.tdep.tadlab.entity.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Long> {

    List<Tool> findToolsByName(String name);

    Optional<Tool> findByName(String name);

}
