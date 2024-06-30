package org.example.click_up.controller;

import org.example.click_up.dto.Task_tagDto;
import org.example.click_up.model.Result;
import org.example.click_up.model.Task_tag;
import org.example.click_up.service.Task_tagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task_tag")
public class Task_tagController {

    @Autowired
    Task_tagService task_tagService;

    @GetMapping()
    public List<Task_tag> getAllTask_tags() {
        return task_tagService.getAllTask_tags();
    }

    @PostMapping()
    public Result createTask_tag(@RequestBody Task_tagDto task_tagDto) {
        return task_tagService.createTask_tag(task_tagDto);
    }

    @PutMapping("/{id}")
    public Result updateTask_tag(@PathVariable Long id, @RequestBody Task_tagDto task_tagDto) {
        return task_tagService.updateTask_tag(task_tagDto, id);
    }

    @DeleteMapping("/{id}")
    public Result deleteTask_tag(@PathVariable Long id) {
        return task_tagService.deleteTask_tag(id);
    }
}
