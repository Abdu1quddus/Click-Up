package org.example.click_up.controller;

import org.example.click_up.dto.Click_appsDto;
import org.example.click_up.model.Click_apps;
import org.example.click_up.model.Result;
import org.example.click_up.service.Click_appsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/click_apps")
public class Click_appsController {

    @Autowired
    Click_appsService click_appsService;

    @GetMapping()
    public List<Click_apps> getAllClick_apps() {
        return click_appsService.getAllClickApps();
    }

    @PostMapping()
    public Result createClick_apps(@RequestBody Click_appsDto click_appsDto) {
        return click_appsService.createClickApp(click_appsDto);
    }

    @PutMapping("/{id}")
    public Result updateClick_apps(@PathVariable Long id, @RequestBody Click_appsDto click_appsDto) {
        return click_appsService.updateClickApp(click_appsDto,id);
    }

    @DeleteMapping("/{id}")
    public Result deleteClick_apps(@PathVariable Long id) {
        return click_appsService.deleteClickApp(id);
    }

}
