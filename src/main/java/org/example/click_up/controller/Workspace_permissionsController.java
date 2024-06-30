package org.example.click_up.controller;

import org.example.click_up.dto.Workspace_permissionsDto;
import org.example.click_up.model.Result;
import org.example.click_up.model.Workspace_permissions;
import org.example.click_up.service.Workspace_permissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workspace_permissions")
public class Workspace_permissionsController {

    @Autowired
    Workspace_permissionsService workspace_permissionsService;

    @GetMapping()
    public List<Workspace_permissions> getAllWorkspace_permissions() {
        return workspace_permissionsService.getAllWorkspace_permissions();
    }

    @PostMapping()
    public Result createWorkspace_permissions(@RequestBody Workspace_permissionsDto workspace_permissionsDto) {
        return workspace_permissionsService.createWorkspace_permissions(workspace_permissionsDto);
    }

    @PutMapping("/{id}")
    public Result updateWorkspace_permissions(@PathVariable Long id, @RequestBody Workspace_permissionsDto workspace_permissionsDto) {
        return workspace_permissionsService.updateWorkspace_permissions(workspace_permissionsDto, id);
    }

    @DeleteMapping("/{id}")
    public Result deleteWorkspace_permissions(@PathVariable Long id) {
        return workspace_permissionsService.deleteWorkspace_permissions(id);
    }

}
