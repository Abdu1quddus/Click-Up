package org.example.click_up.service;

import org.example.click_up.dto.Task_tagDto;
import org.example.click_up.model.Result;
import org.example.click_up.model.Tag;
import org.example.click_up.model.Task;
import org.example.click_up.model.Task_tag;
import org.example.click_up.repository.TagRepository;
import org.example.click_up.repository.TaskRepository;
import org.example.click_up.repository.Task_tagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Task_tagService {

    @Autowired
    Task_tagRepository task_tagRepository;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TagRepository tagRepository;

    public List<Task_tag> getAllTask_tags() {
        return task_tagRepository.findAll();
    }

    public Result createTask_tag(Task_tagDto task_tagDto) {
        Task_tag task_tag = new Task_tag();
        Optional<Task> optionalTask = taskRepository.findById(task_tagDto.getTaskId());
        Task task = optionalTask.get();
        task_tag.setTaskId(task);
        Optional<Tag> optionalTag = tagRepository.findById(task_tagDto.getTagId());
        Tag tag = optionalTag.get();
        task_tag.setTagId(tag);
        task_tagRepository.save(task_tag);
        return new Result(true,"Task tag created");
    }

    public Result updateTask_tag(Task_tagDto task_tagDto,Long id) {
        Optional<Task_tag> optional = task_tagRepository.findById(id);
        if (optional.isPresent()) {
            Task_tag task_tag = optional.get();
            Optional<Task> optionalTask = taskRepository.findById(task_tagDto.getTaskId());
            Task task = optionalTask.get();
            task_tag.setTaskId(task);
            Optional<Tag> optionalTag = tagRepository.findById(task_tagDto.getTagId());
            Tag tag = optionalTag.get();
            task_tag.setTagId(tag);
            task_tagRepository.save(task_tag);
            return new Result(true,"Task tag updated");
        }
        return new Result(false,"Task tag not found");
    }

    public Result deleteTask_tag(Long id) {
        task_tagRepository.deleteById(id);
        return new Result(true,"Task tag deleted");
    }

}
