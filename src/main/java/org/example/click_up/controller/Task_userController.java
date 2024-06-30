package org.example.click_up.controller;

import org.example.click_up.dto.Task_userDto;
import org.example.click_up.model.Result;
import org.example.click_up.model.Task_user;
import org.example.click_up.service.Task_userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task_user")
public class Task_userController {

    @Autowired
    Task_userService task_userService;

    @GetMapping()
    public List<Task_user> getAllTask_user() {
        return task_userService.getAllTask_users();
    }

    @PostMapping()
    public Result createTask_user(@RequestBody Task_userDto task_userDto) {
        return task_userService.createTask_user(task_userDto);
    }

    @PutMapping("/{id}")
    public Result updateTask_user(@PathVariable Long id, @RequestBody Task_userDto task_userDto) {
        return task_userService.updateTask_user(task_userDto, id);
    }

    @DeleteMapping("/{id}")
    public Result deleteTask_user(@PathVariable Long id) {
        return task_userService.deleteTask_user(id);
    }
}
