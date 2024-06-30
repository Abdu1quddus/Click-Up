package org.example.click_up.service;

import org.example.click_up.dto.Workspace_permissionsDto;
import org.example.click_up.model.Result;
import org.example.click_up.model.Workspace_permissions;
import org.example.click_up.model.Workspace_role;
import org.example.click_up.model.temporale.Permission;
import org.example.click_up.repository.Workspace_permissionsRepository;
import org.example.click_up.repository.Workspace_roleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Workspace_permissionsService {

    @Autowired
    Workspace_permissionsRepository workspace_permissionsRepository;

    @Autowired
    Workspace_roleRepository workspace_roleRepository;

    public List<Workspace_permissions> getAllWorkspace_permissions() {
        return workspace_permissionsRepository.findAll();
    }

    public Result createWorkspace_permissions(Workspace_permissionsDto workspace_permissionsDto) {
        Workspace_permissions workspace_permissions = new Workspace_permissions();
        Optional<Workspace_role> workspaceRoleOptional = workspace_roleRepository.findById(workspace_permissionsDto.getWorkspace_roleId());
        Workspace_role workspaceRole = workspaceRoleOptional.get();
        workspace_permissions.setWorkspace_roleId(workspaceRole);
        workspace_permissions.setPermission(Permission.ADMIN);
        workspace_permissionsRepository.save(workspace_permissions);
        return new Result(true,"Workspace permissions created");
    }

    public Result deleteWorkspace_permissions(Long id) {
        workspace_permissionsRepository.deleteById(id);
        return new Result(true,"Workspace permissions deleted");
    }
}
