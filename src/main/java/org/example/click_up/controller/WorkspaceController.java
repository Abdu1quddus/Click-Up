package org.example.click_up.controller;

import org.example.click_up.dto.WorkspaceDto;
import org.example.click_up.model.Result;
import org.example.click_up.model.Workspace;
import org.example.click_up.service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workspace")
public class WorkspaceController {

    @Autowired
    WorkspaceService workspaceService;

    @GetMapping()
    public List<Workspace> getAllWorkspaces() {
        return workspaceService.getAllWorkspaces();
    }

    @GetMapping("/{id}")
    public Workspace getWorkspaceById(@PathVariable Long id) {
        return workspaceService.getWorkspaceById(id);
    }

    @PostMapping()
    public Result createWorkspace(@RequestBody WorkspaceDto workspaceDto) {
        return workspaceService.createWorkspace(workspaceDto);
    }

    @PutMapping("/{id}")
    public Result updateWorkspace(@PathVariable Long id, @RequestBody WorkspaceDto workspaceDto) {
        return workspaceService.updateWorkspace(workspaceDto, id);
    }

    @DeleteMapping("/{id}")
    public Result deleteWorkspace(@PathVariable Long id) {
        return workspaceService.deleteWorkspace(id);
    }

}
