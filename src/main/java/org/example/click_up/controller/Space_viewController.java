package org.example.click_up.controller;

import org.example.click_up.dto.Space_viewDto;
import org.example.click_up.model.Result;
import org.example.click_up.model.Space_view;
import org.example.click_up.service.Space_viewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/space_view")
public class Space_viewController {

    @Autowired
    Space_viewService space_viewService;


    @GetMapping()
    public List<Space_view> getAllSpace_view() {
        return space_viewService.getAllSpace_views();
    }

    @PostMapping()
    public Result createSpace_view(@RequestBody Space_viewDto space_viewDto) {
        return space_viewService.createSpace_view(space_viewDto);
    }

    @PutMapping("/{id}")
    public Result updateSpace_view(@PathVariable Long id, @RequestBody Space_viewDto space_viewDto) {
        return space_viewService.updateSpace_view(space_viewDto,id);
    }

    @DeleteMapping("/{id}")
    public Result deleteSpace_view(@PathVariable Long id) {
        return space_viewService.deleteSpace_view(id);
    }

}
