package org.example.click_up.controller;

import org.example.click_up.dto.Time_trackedDto;
import org.example.click_up.model.Result;
import org.example.click_up.model.Time_tracked;
import org.example.click_up.service.Time_trackedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time_tracked")
public class Time_trackedController {

    @Autowired
    Time_trackedService time_trackedService;

    @GetMapping()
    public List<Time_tracked> getAllTime_tracked() {
        return time_trackedService.getAllTime_tracked();
    }

    @PostMapping()
    public Result createTime_tracked(@RequestBody Time_trackedDto time_trackedDto) {
        return time_trackedService.createTime_tracked(time_trackedDto);
    }

    @PutMapping("/{id}")
    public Result updateTime_tracked(@PathVariable Long id, @RequestBody Time_trackedDto time_trackedDto) {
        return time_trackedService.updateTime_tracked(time_trackedDto, id);
    }

    @DeleteMapping("/{id}")
    public Result deleteTime_tracked(@PathVariable Long id) {
        return time_trackedService.deleteTime_tracked(id);
    }
}
