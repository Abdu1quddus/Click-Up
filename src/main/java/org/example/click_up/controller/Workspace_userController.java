package org.example.click_up.controller;

import org.example.click_up.dto.Workspace_userDto;
import org.example.click_up.model.Result;
import org.example.click_up.model.Workspace_user;
import org.example.click_up.service.Workspace_userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workspace_user")
public class Workspace_userController {

    @Autowired
    Workspace_userService workspace_userService;

    @GetMapping()
    public List<Workspace_user> getAllWorkspace_user() {
        return workspace_userService.getAllWorkspaceUser();
    }

    @PostMapping()
    public Result createWorkspace_user(@RequestBody Workspace_userDto workspace_userDto) {
        return workspace_userService.createWorkspaceUser(workspace_userDto);
    }

    @PutMapping("/{id}")
    public Result updateWorkspace_user(@PathVariable Long id, @RequestBody Workspace_userDto workspace_userDto) {
        return workspace_userService.updateWorkspaceUser(workspace_userDto, id);
    }

    @DeleteMapping("/{id}")
    public Result deleteWorkspace_user(@PathVariable Long id) {
        return workspace_userService.deleteWorkspaceUser(id);
    }

}
