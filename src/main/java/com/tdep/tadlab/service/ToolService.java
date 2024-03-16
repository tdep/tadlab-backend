package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.Tool;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ToolService {

    ResponseEntity<List<Tool>> getAllTools(String toolName);

    ResponseEntity<Tool> getToolById(long toolId);

    ResponseEntity<Tool> getToolByName(String toolName);

    ResponseEntity<Tool> createTool(Tool tool);

    ResponseEntity<Tool> updateTool(long toolId, Tool tool);

    ResponseEntity<HttpStatus> deleteTool(long toolId);

    ResponseEntity<HttpStatus> deleteAllTools();
}
