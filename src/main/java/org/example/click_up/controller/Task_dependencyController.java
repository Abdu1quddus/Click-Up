package org.example.click_up.controller;

import org.example.click_up.dto.Task_dependencyDto;
import org.example.click_up.model.Result;
import org.example.click_up.model.Task_dependency;
import org.example.click_up.service.Task_dependencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task_dependency")
public class Task_dependencyController {

    @Autowired
    Task_dependencyService task_dependencyService;

    @GetMapping()
    public List<Task_dependency> getAllTask_dependency() {
        return task_dependencyService.getAllTask_dependencies();
    }

    @PostMapping()
    public Result createTask_dependency(@RequestBody Task_dependencyDto task_dependencyDto) {
        return task_dependencyService.createTask_dependency(task_dependencyDto);
    }

    @PutMapping("/{id}")
    public Result updateTask_dependency(@PathVariable Long id, @RequestBody Task_dependencyDto task_dependencyDto) {
        return task_dependencyService.updateTask_dependency(task_dependencyDto,id);
    }

    @DeleteMapping("/{id}")
    public Result deleteTask_dependency(@PathVariable Long id) {
        return task_dependencyService.deleteTask_dependency(id);
    }
}
