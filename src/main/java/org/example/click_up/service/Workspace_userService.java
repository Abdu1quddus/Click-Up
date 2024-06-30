package org.example.click_up.service;

import org.example.click_up.dto.Workspace_userDto;
import org.example.click_up.model.*;
import org.example.click_up.repository.UserRepository;
import org.example.click_up.repository.WorkspaceRepository;
import org.example.click_up.repository.Workspace_roleRepository;
import org.example.click_up.repository.Workspace_userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class Workspace_userService {

    @Autowired
    Workspace_userRepository workspace_userRepository;

    @Autowired
    Workspace_roleRepository workspace_roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    WorkspaceRepository workspaceRepository;

    @GetMapping()
    public List<Workspace_user> getAllWorkspaceUser() {
        return workspace_userRepository.findAll();
    }

    public Result createWorkspaceUser(@RequestBody Workspace_userDto workspace_userDto) {
        Workspace_user workspaceUser = new Workspace_user();
        Optional<Workspace> workspaceOptional = workspaceRepository.findById(workspace_userDto.getWorkspaceId());
        Workspace workspace = workspaceOptional.get();
        workspaceUser.setWorkspaceId((List<Workspace>) workspace);
        Optional<User> userOptional = userRepository.findById(workspace_userDto.getUserId());
        User user = userOptional.get();
        workspaceUser.setUserId((List<User>) user);
        Optional<Workspace_role> workspaceRoleOptional = workspace_roleRepository.findById(workspace_userDto.getWorkspace_roleId());
        Workspace_role workspaceRole = workspaceRoleOptional.get();
        workspaceUser.setWorkspace_roleId((List<Workspace_role>) workspaceRole);
        workspace_userRepository.save(workspaceUser);
        return new Result(true,"Successfully created Workspace_user");
    }

    public Result updateWorkspaceUser(@RequestBody Workspace_userDto workspace_userDto, @PathVariable long id) {
        Optional<Workspace_user> workspaceUserOptional = workspace_userRepository.findById(id);
        if (workspaceUserOptional.isPresent()){
            Workspace_user workspaceUser = workspaceUserOptional.get();
            Optional<Workspace> workspaceOptional = workspaceRepository.findById(workspace_userDto.getWorkspaceId());
            Workspace workspace = workspaceOptional.get();
            workspaceUser.setWorkspaceId((List<Workspace>) workspace);
            Optional<User> userOptional = userRepository.findById(workspace_userDto.getUserId());
            User user = userOptional.get();
            workspaceUser.setUserId((List<User>) user);
            Optional<Workspace_role> workspaceRoleOptional = workspace_roleRepository.findById(workspace_userDto.getWorkspace_roleId());
            Workspace_role workspaceRole = workspaceRoleOptional.get();
            workspaceUser.setWorkspace_roleId((List<Workspace_role>) workspaceRole);
            workspace_userRepository.save(workspaceUser);
            return new Result(true,"Successfully updated Workspace_user");
        }
        return new Result(false,"Workspace not found");
    }

    public Result deleteWorkspaceUser(@RequestParam long id) {
        workspace_userRepository.deleteById(id);
        return new Result(true,"Successfully deleted Workspace_user");
    }

}
