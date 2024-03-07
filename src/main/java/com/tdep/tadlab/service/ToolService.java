package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.Tool;

import java.util.List;

public interface ToolService {

    Tool saveTool(Tool tool);

    List<Tool> fetchToolList();

    Tool updateTool(Tool tool, int toolId);

    void deleteToolById(int toolId);
}
