package org.example.click_up.controller;

import org.example.click_up.dto.Task_attachmentDto;
import org.example.click_up.model.Result;
import org.example.click_up.model.Task_attachment;
import org.example.click_up.service.Task_attachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task_attachment")
public class Task_attachmentController {

    @Autowired
    Task_attachmentService task_attachmentService;

    @GetMapping()
    public List<Task_attachment> getTask_attachment() {
        return task_attachmentService.getAllTask_attachments();
    }

    @PostMapping()
    public Result createTask_attachment(@RequestBody Task_attachmentDto task_attachmentDto) {
        return task_attachmentService.createTask_attachment(task_attachmentDto);
    }

    @PutMapping("/{id}")
    public Result updateTask_attachment(@PathVariable Long id, @RequestBody Task_attachmentDto task_attachmentDto) {
        return task_attachmentService.updateTask_attachment(task_attachmentDto,id);
    }

    @DeleteMapping("/{id}")
    public Result deleteTask_attachment(@PathVariable Long id) {
        return task_attachmentService.deleteTask_attachment(id);
    }
}
