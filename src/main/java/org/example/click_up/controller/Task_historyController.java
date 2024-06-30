package org.example.click_up.controller;

import org.example.click_up.dto.Task_historyDto;
import org.example.click_up.model.Result;
import org.example.click_up.model.Task_history;
import org.example.click_up.service.Task_historyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task_history")
public class Task_historyController {

    @Autowired
    Task_historyService task_historyService;

    @GetMapping()
    public List<Task_history> getAllTaskHistory() {
        return task_historyService.getAllTask_history();
    }

    @PostMapping()
    public Result createTaskHistory(@RequestBody Task_historyDto task_historyDto) {
        return task_historyService.createTask_history(task_historyDto);
    }

    @PutMapping("/{id}")
    public Result updateTaskHistory(@PathVariable Long id, @RequestBody Task_historyDto task_historyDto) {
        return task_historyService.updateTask_history(task_historyDto, id);
    }

    @DeleteMapping("/{id}")
    public Result deleteTaskHistory(@PathVariable Long id) {
        return task_historyService.deleteTask_history(id);
    }
}
