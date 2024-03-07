package com.tdep.tadlab.controller;

import com.tdep.tadlab.entity.Tool;
import com.tdep.tadlab.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ToolController {

    @Autowired private ToolService toolService;
    private final String crossOrigin = "PostmanRuntime/7.36.3";

    @CrossOrigin(value = crossOrigin)
    @PostMapping("/tools")
    public Tool saveTool(
            @Validated @RequestBody Tool tool) {
        return toolService.saveTool(tool);
    }

    @CrossOrigin(value = crossOrigin)
    @GetMapping("/tools")
    public List<Tool> fetchToolList() {
        return toolService.fetchToolList();
    }

    @CrossOrigin(value = crossOrigin)
    @PutMapping("/tools/{id}")
    public Tool updateTool(@RequestBody Tool tool, @PathVariable("id") int toolId) {
        return toolService.updateTool(tool, toolId);
    }

    @CrossOrigin(value = crossOrigin)
    @DeleteMapping("/tools/{id}")
    public String deleteToolById(@PathVariable("id") int toolId) {
        toolService.deleteToolById(
                toolId);
        return "Deleted Tool Successfully";
    }
}
