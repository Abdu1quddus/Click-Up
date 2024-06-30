package org.example.click_up.controller;

import org.example.click_up.dto.Project_userDto;
import org.example.click_up.model.Project_user;
import org.example.click_up.model.Result;
import org.example.click_up.service.Project_userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project_user")
public class Project_userController {

    @Autowired
    Project_userService project_userService;

    @GetMapping()
    public List<Project_user> getAllProject_user() {
        return project_userService.getAllProject_users();
    }

    @PostMapping()
    public Result createProject_user(@RequestBody Project_userDto project_userDto) {
        return project_userService.createProject_user(project_userDto);
    }

    @PutMapping("/{id}")
    public Result updateProject_user(@PathVariable Long id, @RequestBody Project_userDto project_userDto) {
        return project_userService.updateProject_user(project_userDto,id);
    }

    @DeleteMapping("/{id}")
    public Result deleteProject_user(@PathVariable Long id) {
        return project_userService.deleteProject_user(id);
    }
}
