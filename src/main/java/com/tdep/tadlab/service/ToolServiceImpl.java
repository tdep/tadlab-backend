package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.Tool;
import com.tdep.tadlab.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ToolServiceImpl implements ToolService {

    @Autowired
    private ToolRepository toolRepository;

    @Override
    public Tool saveTool(Tool tool) {
        return toolRepository.save(tool);
    }

    @Override
    public List<Tool> fetchToolList() {
        return (List<Tool>) toolRepository.findAll();
    }

    @Override
    public Tool updateTool(Tool tool, int toolId) {

        Tool toolDB = null;
        if (toolRepository.findById(toolId).isPresent()) {
            toolDB = toolRepository.findById(toolId).get();

            if (Objects.nonNull(tool.getName())
                    && !"".equalsIgnoreCase(
                    tool.getName())) {
                toolDB.setName(
                        tool.getName());
            }

            if (Objects.nonNull(tool.getImageUrl())
                    && !"".equalsIgnoreCase(
                    tool.getImageUrl())) {
                toolDB.setImageUrl(
                        tool.getImageUrl());
            }

//            if (Objects.nonNull(tool.getProject())) {
//                toolDB.setProject(
//                        tool.getProject());
//            }
        }

        assert toolDB != null;
        return toolRepository.save(toolDB);
    }

    @Override
    public void deleteToolById(int toolId) {
        toolRepository.deleteById(toolId);
    }
}
