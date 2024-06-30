package org.example.click_up.controller;

import org.example.click_up.dto.Space_click_appsDto;
import org.example.click_up.model.Result;
import org.example.click_up.model.Space_click_apps;
import org.example.click_up.service.Space_click_appsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/space_click_apps")
public class Space_click_appsController {

    @Autowired
    Space_click_appsService space_click_appsService;

    @GetMapping()
    public List<Space_click_apps> getAllSpaceClickApps() {
        return space_click_appsService.getAllSpace_click_apps();
    }

    @PostMapping()
    public Result createSpaceClickApps(@RequestBody Space_click_appsDto space_click_appsDto) {
        return space_click_appsService.createSpace_click_apps(space_click_appsDto);
    }
    
    @PutMapping("/{id}")
    public Result updateSpaceClickApps(@RequestBody Space_click_appsDto space_click_appsDto,@PathVariable Long id){
        return space_click_appsService.updateSpace_click_apps(space_click_appsDto,id);
    }

    @DeleteMapping("/{id}")
    public Result deleteSpaceClickApps(@PathVariable Long id){
        return space_click_appsService.deleteSpace_click_apps(id);
    }

}
