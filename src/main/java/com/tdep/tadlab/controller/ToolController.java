package com.tdep.tadlab.controller;

import com.tdep.tadlab.entity.Tool;
import com.tdep.tadlab.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO: Change cross origins

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class ToolController {

    @Autowired private ToolService toolService;

    @GetMapping("/tools")
    public ResponseEntity<List<Tool>> getAllTools(@RequestParam(required = false) String toolName) {
        return toolService.getAllTools(toolName);
    }

    @GetMapping("/tools/{id}")
    public ResponseEntity<Tool> getToolById(@PathVariable("id") long toolId) {
        return toolService.getToolById(toolId);
    }

    @GetMapping("/tools/{name}")
    public ResponseEntity<Tool> getToolByName(@PathVariable("name") String toolName) {
        return toolService.getToolByName(toolName);
    }

    @PostMapping("/tools")
    public ResponseEntity<Tool> createTool(@RequestBody Tool tool) {
        return toolService.createTool(tool);
    }

    @PutMapping("/tools/{id}")
    public ResponseEntity<Tool> updateTool(@PathVariable("id") long toolId, @RequestBody Tool tool) {
        return toolService.updateTool(toolId, tool);
    }

    @DeleteMapping("/tools/{id}")
    public ResponseEntity<HttpStatus> deleteTool(@PathVariable("id") long toolId) {
        return toolService.deleteTool(toolId);
    }

    @DeleteMapping("/tools")
    public ResponseEntity<HttpStatus> deleteAllTools() {
        return toolService.deleteAllTools();
    }
}
