package org.example.click_up.service;

import org.example.click_up.dto.ProjectDto;
import org.example.click_up.model.Project;
import org.example.click_up.model.Result;
import org.example.click_up.model.Space;
import org.example.click_up.repository.ProjectRepository;
import org.example.click_up.repository.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    SpaceRepository spaceRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Result createProject(ProjectDto projectDto) {
        Project project = new Project();
        project.setName(projectDto.getName());
        Optional<Space> optionalSpace = spaceRepository.findById(projectDto.getSpaceId());
        Space space = optionalSpace.get();
        project.setSpaceId(space);
        project.setAccess_type(projectDto.getAccess_type());
        project.setArchived(projectDto.getArchived());
        project.setColor(projectDto.getColor());
        projectRepository.save(project);
        return new Result(true,"Project created");
    }

    public Result updateProject(ProjectDto projectDto,Long id) {
        Optional<Project> optionalProject = projectRepository.findById(id);
        if (optionalProject.isPresent()) {
            Project project = optionalProject.get();
            project.setName(projectDto.getName());
            Optional<Space> optionalSpace = spaceRepository.findById(projectDto.getSpaceId());
            Space space = optionalSpace.get();
            project.setSpaceId(space);
            project.setAccess_type(projectDto.getAccess_type());
            project.setArchived(projectDto.getArchived());
            project.setColor(projectDto.getColor());
            projectRepository.save(project);
            return new Result(true,"Project updated");
        }
        return new Result(false,"Project not found");
    }

    public Result deleteProject(Long id) {
        projectRepository.deleteById(id);
        return new Result(true,"Project deleted");
    }
}
