package org.example.click_up.service;

import org.example.click_up.dto.CommentDto;
import org.example.click_up.model.Comment;
import org.example.click_up.model.Result;
import org.example.click_up.model.Task;
import org.example.click_up.repository.CommentRepository;
import org.example.click_up.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    TaskRepository taskRepository;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Result createComment(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setName(commentDto.getName());
        Optional<Task> optional = taskRepository.findById(commentDto.getTaskId());
        Task task = optional.get();
        comment.setTaskId((List<Task>) task);
        commentRepository.save(comment);
        return new Result(true,"Comment created");
    }

    public Result updateComment(CommentDto commentDto,Long id) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if (optionalComment.isPresent()) {
            Comment comment = optionalComment.get();
            comment.setName(commentDto.getName());
            Optional<Task> optional = taskRepository.findById(commentDto.getTaskId());
            Task task = optional.get();
            comment.setTaskId((List<Task>) task);
            commentRepository.save(comment);
            return new Result(true,"Comment updated");
        }
        return new Result(false,"Comment not found");
    }

    public Result deleteComment(Long id) {
        commentRepository.deleteById(id);
        return new Result(true,"Comment deleted");
    }
}
