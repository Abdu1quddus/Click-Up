package org.example.click_up.controller;

import lombok.Data;
import org.example.click_up.dto.CommentDto;
import org.example.click_up.model.Comment;
import org.example.click_up.model.Result;
import org.example.click_up.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping()
    public List<Comment> getComments() {
        return commentService.getAllComments();
    }

    @PostMapping()
    public Result createComment(@RequestBody CommentDto commentDto) {
        return commentService.createComment(commentDto);
    }

    @PutMapping("/{id}")
    public Result updateComment(@PathVariable Long id, @RequestBody CommentDto commentDto) {
        return commentService.updateComment(commentDto, id);
    }

    @DeleteMapping("/{id}")
    public Result deleteComment(@PathVariable Long id) {
        return commentService.deleteComment(id);
    }
}
