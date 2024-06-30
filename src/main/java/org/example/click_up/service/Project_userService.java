package org.example.click_up.service;

import org.example.click_up.dto.Project_userDto;
import org.example.click_up.model.Project;
import org.example.click_up.model.Project_user;
import org.example.click_up.model.Result;
import org.example.click_up.model.User;
import org.example.click_up.repository.ProjectRepository;
import org.example.click_up.repository.Project_userRepository;
import org.example.click_up.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Project_userService {

    @Autowired
    Project_userRepository project_userRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProjectRepository projectRepository;

    public List<Project_user> getAllProject_users() {
        return project_userRepository.findAll();
    }

    public Result createProject_user(Project_userDto project_userDto) {
        Project_user project_user = new Project_user();
        Optional<Project> projectOptional = projectRepository.findById(project_userDto.getProjectId());
        Project project = projectOptional.get();
        project_user.setProjectId(project);
        Optional<User> userOptional = userRepository.findById(project_userDto.getUserId());
        User user = userOptional.get();
        project_user.setUserId(user);
        project_userRepository.save(project_user);
        return new Result(true,"Project user created successfully");
    }

    public Result updateProject_user(Project_userDto project_userDto,Long id) {
        Optional<Project_user> projectUserOptional = project_userRepository.findById(id);
        if (projectUserOptional.isPresent()) {
            Project_user project_user = projectUserOptional.get();
            Optional<Project> projectOptional = projectRepository.findById(project_userDto.getProjectId());
            Project project = projectOptional.get();
            project_user.setProjectId(project);
            Optional<User> userOptional = userRepository.findById(project_userDto.getUserId());
            User user = userOptional.get();
            project_user.setUserId(user);
            project_userRepository.save(project_user);
            return new Result(true,"Project user updated successfully");
        }
        return new Result(false,"Project user not found");
    }

    public Result deleteProject_user(Long id) {
        project_userRepository.deleteById(id);
        return new Result(true,"Project user deleted successfully");
    }

}
