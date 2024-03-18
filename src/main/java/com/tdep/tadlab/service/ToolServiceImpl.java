package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.Tool;
import com.tdep.tadlab.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ToolServiceImpl implements ToolService {

    @Autowired
    private ToolRepository toolRepository;

    public ResponseEntity<List<Tool>> getAllTools(String toolName) {
        try {
            List<Tool> tools = new ArrayList<>();

            if (toolName == null) {
                tools.addAll(toolRepository.findAll());
            } else {
                tools.addAll(toolRepository.findToolsByName(toolName));
            }
            if (tools.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(tools, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Tool> getToolById(long toolId) {
        Optional<Tool> toolData = toolRepository.findById(toolId);

        return toolData.map(
                tool -> new ResponseEntity<>(
                        tool, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(
                        HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Tool> getToolByName(String toolName) {
        Optional<Tool> toolData = toolRepository.findByName(toolName);

        return toolData.map(
                tool -> new ResponseEntity<>(
                        tool, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(
                        HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Tool> createTool(Tool tool) {
        try {
            Tool _tool = toolRepository
                    .save(new Tool(
                            tool.getName(),
                            tool.getLinkId(),
                            tool.getProjectId(),
                            tool.getEntryId(),
                            tool.getEntryType()));
            return new ResponseEntity<>(_tool, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Tool> updateTool(long toolId, Tool tool) {
        Optional<Tool> toolData = toolRepository.findById(toolId);

        if (toolData.isPresent()) {
            Tool _tool = toolData.get();
            _tool.setToolName(tool.getToolName());
            _tool.setLinkId(tool.getLinkId());
            _tool.setProjectId(tool.getProjectId());
            _tool.setEntryId(tool.getEntryId());
            _tool.setEntryType(tool.getEntryType());
            return new ResponseEntity<>(toolRepository.save(_tool), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<HttpStatus> deleteTool(long toolId) {
        try {
            toolRepository.deleteById(toolId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<HttpStatus> deleteAllTools() {
        try {
            toolRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
