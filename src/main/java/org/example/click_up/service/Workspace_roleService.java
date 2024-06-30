package org.example.click_up.service;

import org.example.click_up.dto.Workspace_roleDto;
import org.example.click_up.model.Result;
import org.example.click_up.model.Workspace;
import org.example.click_up.model.Workspace_role;
import org.example.click_up.repository.WorkspaceRepository;
import org.example.click_up.repository.Workspace_roleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Workspace_roleService {

    @Autowired
    Workspace_roleRepository workspace_roleRepository;

    @Autowired
    WorkspaceRepository workspaceRepository;

    public List<Workspace_role> getAllWorkspaceRoles() {
        return workspace_roleRepository.findAll();
    }

    public Result createWorkspaceRole(Workspace_roleDto workspace_roleDto) {
        Workspace_role workspace_role = new Workspace_role();
        workspace_role.setName(workspace_roleDto.getName());
        workspace_role.setExtends_role(workspace_roleDto.getExtends_role());
        Optional<Workspace> workspaceOptional = workspaceRepository.findById(workspace_roleDto.getWorkspaceId());
        Workspace workspace = workspaceOptional.get();
        workspace_role.setWorkspaceId(workspace);
        workspace_roleRepository.save(workspace_role);
        return new Result(true,"Successfully created Workspace_role");
    }

    public Result updateWorkspaceRole(Workspace_roleDto workspace_roleDto,Long id){
        Optional<Workspace_role> workspaceRoleOptional = workspace_roleRepository.findById(id);
        if (workspaceRoleOptional.isPresent()){
            Workspace_role workspaceRole = workspaceRoleOptional.get();
            workspaceRole.setName(workspace_roleDto.getName());
            workspaceRole.setExtends_role(workspace_roleDto.getExtends_role());
            Optional<Workspace> workspaceOptional = workspaceRepository.findById(workspace_roleDto.getWorkspaceId());
            Workspace workspace = workspaceOptional.get();
            workspaceRole.setWorkspaceId(workspace);
            workspace_roleRepository.save(workspaceRole);
            return new Result(true,"Successfully updated Workspace_role");
        }
        return new Result(false,"Workspace_role not found");
    }

    public Result deleteWorkspaceRole(Long id){
        workspace_roleRepository.deleteById(id);
        return new Result(true,"Successfully deleted Workspace_role");
    }
}