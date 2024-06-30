package org.example.click_up.controller;

import org.example.click_up.dto.TagDto;
import org.example.click_up.model.Result;
import org.example.click_up.model.Tag;
import org.example.click_up.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    TagService tagService;

    @GetMapping()
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }

    @PostMapping()
    public Result createTag(@RequestBody TagDto tagDto) {
        return tagService.createTag(tagDto);
    }

    @PutMapping("/{id}")
    public Result updateTag(@PathVariable Long id, @RequestBody TagDto tagDto) {
        return tagService.updateTag(tagDto,id);
    }

    @DeleteMapping("/{id}")
    public Result deleteTag(@PathVariable Long id) {
        return tagService.deleteTag(id);
    }
}
