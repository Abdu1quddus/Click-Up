package org.example.click_up.controller;

import org.example.click_up.dto.TaskDto;
import org.example.click_up.model.Result;
import org.example.click_up.model.Task;
import org.example.click_up.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping()
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping()
    public Result createTask(@RequestBody TaskDto taskDto) {
        return taskService.createTask(taskDto);
    }

    @PutMapping("/{id}")
    public Result updateTask(@PathVariable Long id, @RequestBody TaskDto taskDto) {
        return taskService.updateTask(taskDto,id);
    }

    @DeleteMapping("/{id}")
    public Result deleteTask(@PathVariable Long id) {
        return taskService.deleteTask(id);
    }
}
