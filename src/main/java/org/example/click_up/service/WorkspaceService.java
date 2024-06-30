package org.example.click_up.service;

import org.example.click_up.dto.WorkspaceDto;
import org.example.click_up.model.Attachment;
import org.example.click_up.model.Result;
import org.example.click_up.model.User;
import org.example.click_up.model.Workspace;
import org.example.click_up.repository.AttachmentRepository;
import org.example.click_up.repository.UserRepository;
import org.example.click_up.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkspaceService {
    @Autowired
    WorkspaceRepository workspaceRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AttachmentRepository attachmentRepository;

    public List<Workspace> getAllWorkspaces() {
        return workspaceRepository.findAll();
    }

    public Workspace getWorkspaceById(Long id) {
        Optional<Workspace> workspaceOptional = workspaceRepository.findById(id);
        return workspaceOptional.get();
    }

    public Result createWorkspace(WorkspaceDto workspaceDto) {
        boolean existsByName = workspaceRepository.existsByName(workspaceDto.getName());
        if (existsByName) {
            return new Result(false, "workspace with name " + workspaceDto.getName() + " already exists");
        }
        Workspace workspace = new Workspace();
        workspace.setName(workspaceDto.getName());
        workspace.setColor(workspaceDto.getColor());
        workspace.setInitialLetter(workspaceDto.getInitialLetter());
        Optional<User> userOptional = userRepository.findById(workspaceDto.getUserId());
        User user = userOptional.get();
        workspace.setUsers(user);
        Optional<Attachment> attachmentOptional = attachmentRepository.findById(workspaceDto.getAvatarId());
        Attachment attachment = attachmentOptional.get();
        workspace.setAvatarId(attachment);
        workspaceRepository.save(workspace);
        return new Result(true, "workspace created");
    }

    public Result updateWorkspace(WorkspaceDto workspaceDto,Long id) {
        Optional<Workspace> workspaceOptional = workspaceRepository.findById(id);
        if (workspaceOptional.isPresent()) {
            Workspace workspace = workspaceOptional.get();
            workspace.setName(workspaceDto.getName());
            workspace.setColor(workspaceDto.getColor());
            workspace.setInitialLetter(workspaceDto.getInitialLetter());
            Optional<User> userOptional = userRepository.findById(workspaceDto.getUserId());
            User user = userOptional.get();
            workspace.setUsers(user);
            Optional<Attachment> attachmentOptional = attachmentRepository.findById(workspaceDto.getAvatarId());
            Attachment attachment = attachmentOptional.get();
            workspace.setAvatarId(attachment);
            workspaceRepository.save(workspace);
            return new Result(true, "workspace updated");
        }
        return new Result(false, "workspace not found");
    }

    public Result deleteWorkspace(Long id) {
        workspaceRepository.deleteById(id);
        return new Result(true, "workspace deleted");
    }
}
