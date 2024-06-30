package org.example.click_up.service;

import org.example.click_up.dto.StatusDto;
import org.example.click_up.model.*;
import org.example.click_up.repository.CategoryRepository;
import org.example.click_up.repository.ProjectRepository;
import org.example.click_up.repository.SpaceRepository;
import org.example.click_up.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    SpaceRepository spaceRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public List<Status> getAllStatus() {
        return statusRepository.findAll();
    }

    public Result createStatus(StatusDto statusDto) {
        Status status = new Status();
        status.setName(statusDto.getName());
        Optional<Space> optionalSpace = spaceRepository.findById(statusDto.getSpaceId());
        Space space = optionalSpace.get();
        status.setSpaceId(space);
        Optional<Project> optionalProject = projectRepository.findById(statusDto.getProjectId());
        Project project = optionalProject.get();
        status.setProjectId(project);
        Optional<Category> optionalCategory = categoryRepository.findById(statusDto.getCategoryId());
        Category category = optionalCategory.get();
        status.setCategoryId(category);
        statusRepository.save(status);
        return new Result(true,"Successfully created status");
    }

    public Result updateStatus(StatusDto statusDto,Long id) {
        Optional<Status> optionalStatus = statusRepository.findById(id);
        if (optionalStatus.isPresent()) {
            Status status = optionalStatus.get();
            status.setName(statusDto.getName());
            Optional<Space> optionalSpace = spaceRepository.findById(statusDto.getSpaceId());
            Space space = optionalSpace.get();
            status.setSpaceId(space);
            Optional<Project> optionalProject = projectRepository.findById(statusDto.getProjectId());
            Project project = optionalProject.get();
            status.setProjectId(project);
            Optional<Category> optionalCategory = categoryRepository.findById(statusDto.getCategoryId());
            Category category = optionalCategory.get();
            status.setCategoryId(category);
            statusRepository.save(status);
            return new Result(true,"Successfully updated status");
        }
        return new Result(false,"No status found");
    }

    public Result deleteStatus(Long id) {
        statusRepository.deleteById(id);
        return new Result(true,"Successfully deleted status");
    }
}
