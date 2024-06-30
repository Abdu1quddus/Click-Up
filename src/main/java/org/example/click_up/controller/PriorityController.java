package org.example.click_up.controller;

import org.example.click_up.dto.PriorityDto;
import org.example.click_up.model.Priority;
import org.example.click_up.model.Result;
import org.example.click_up.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/priority")
public class PriorityController {

    @Autowired
    PriorityService priorityService;

    @GetMapping()
    public List<Priority> getAllPriority() {
        return priorityService.getAllPriority();
    }

    @PostMapping()
    public Result createPriority(@RequestBody PriorityDto priorityDto) {
        return priorityService.createPriority(priorityDto);
    }

    @PutMapping("/{id}")
    public Result updatePriority(@PathVariable Long id, @RequestBody PriorityDto priorityDto) {
        return priorityService.updatePriority(id, priorityDto);
    }

    @DeleteMapping("/{id}")
    public Result deletePriority(@PathVariable Long id) {
        return priorityService.deletePriority(id);
    }

}
