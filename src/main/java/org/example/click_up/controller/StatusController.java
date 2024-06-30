package org.example.click_up.controller;

import org.example.click_up.dto.StatusDto;
import org.example.click_up.model.Result;
import org.example.click_up.model.Status;
import org.example.click_up.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    StatusService statusService;

    @GetMapping()
    public List<Status> getStatus() {
        return statusService.getAllStatus();
    }

    @PostMapping()
    public Result createStatus(@RequestBody StatusDto statusDto) {
        return statusService.createStatus(statusDto);
    }

    @PutMapping("/{id}")
    public Result updateStatus(@PathVariable Long id, @RequestBody StatusDto statusDto) {
        return statusService.updateStatus(statusDto, id);
    }

    @DeleteMapping("/{id}")
    public Result deleteStatus(@PathVariable Long id) {
        return statusService.deleteStatus(id);
    }
}
