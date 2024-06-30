package org.example.click_up.controller;

import org.example.click_up.dto.Check_listDto;
import org.example.click_up.model.Check_list;
import org.example.click_up.model.Result;
import org.example.click_up.service.Check_listService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/check_list")
public class Check_listController {

    @Autowired
    Check_listService check_listService;

    @GetMapping()
    public List<Check_list> getAllCheck_list() {
        return check_listService.getAllCheck_list();
    }

    @PostMapping()
    public Result createCheck_list(@RequestBody Check_listDto check_listDto) {
        return check_listService.createCheck_list(check_listDto);
    }

    @PutMapping("/{id}")
    public Result updateCheck_list(@PathVariable Long id, @RequestBody Check_listDto check_listDto) {
        return check_listService.updateCheck_list(check_listDto, id);
    }

    @DeleteMapping("/{id}")
    public Result deleteCheck_list(@PathVariable Long id) {
        return check_listService.deleteCheck_list(id);
    }
}
