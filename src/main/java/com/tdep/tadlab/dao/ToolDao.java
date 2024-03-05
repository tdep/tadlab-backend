package com.tdep.tadlab.dao;

import com.tdep.tadlab.model.Tool;

import java.util.List;
import java.util.Optional;

public interface ToolDao {

    List<Tool> getAllTools();

    Tool getToolById(int id);

    Optional<Tool> getToolByName(String name);
    Tool save(Tool tool);

    void delete(Tool tool);
}
