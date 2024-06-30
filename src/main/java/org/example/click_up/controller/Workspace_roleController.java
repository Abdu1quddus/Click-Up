package org.example.click_up.controller;

import org.example.click_up.dto.Workspace_roleDto;
import org.example.click_up.model.Result;
import org.example.click_up.model.Workspace_role;
import org.example.click_up.service.Workspace_roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workspace_role")
public class Workspace_roleController {

    @Autowired
    Workspace_roleService workspace_roleService;

    @GetMapping()
    public List<Workspace_role> getAllWorkspaceRoles() {
        return workspace_roleService.getAllWorkspaceRoles();
    }

    @PostMapping()
    public Result createWorkspaceRole(@RequestBody Workspace_roleDto workspace_roleDto) {
        return workspace_roleService.createWorkspaceRole(workspace_roleDto);
    }

    @PutMapping("/{id}")
    public Result updateWorkspaceRole(@PathVariable Long id, @RequestBody Workspace_roleDto workspace_roleDto) {
        return workspace_roleService.updateWorkspaceRole(workspace_roleDto,id);
    }

    @DeleteMapping("/{id}")
    public Result deleteWorkspaceRole(@PathVariable Long id) {
        return workspace_roleService.deleteWorkspaceRole(id);
    }

}
