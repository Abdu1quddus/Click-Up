package org.example.click_up.controller;

import org.example.click_up.dto.ProjectDto;
import org.example.click_up.model.Project;
import org.example.click_up.model.Result;
import org.example.click_up.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping()
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping()
    public Result createProject(@RequestBody ProjectDto projectDto) {
        return projectService.createProject(projectDto);
    }

    @PutMapping("/{id}")
    public Result updateProject(@PathVariable Long id, @RequestBody ProjectDto projectDto) {
        return projectService.updateProject(projectDto,id);
    }

    @DeleteMapping("/{id}")
    public Result deleteProject(@PathVariable Long id) {
        return projectService.deleteProject(id);
    }
}
