package org.example.click_up.controller;

import org.example.click_up.dto.ViewDto;
import org.example.click_up.model.Result;
import org.example.click_up.model.View;
import org.example.click_up.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/view")
public class ViewController {

    @Autowired
    ViewService viewService;

    @GetMapping()
    public List<View> getAllViews() {
        return viewService.getAllViews();
    }

    @GetMapping("/{id}")
    public View getViewById(@PathVariable Long id) {
        return viewService.getViewById(id);
    }

    @PostMapping()
    public Result createView(@RequestBody ViewDto viewDto) {
        return viewService.createView(viewDto);
    }

    @PutMapping("/{id}")
    public Result updateView(@PathVariable Long id, @RequestBody ViewDto viewDto) {
        return viewService.updateView(viewDto, id);
    }

    @DeleteMapping("/{id}")
    public Result deleteView(@PathVariable Long id) {
        return viewService.deleteView(id);
    }

}
