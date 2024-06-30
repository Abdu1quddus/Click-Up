package org.example.click_up.service;

import org.example.click_up.dto.TaskDto;
import org.example.click_up.model.*;
import org.example.click_up.repository.CategoryRepository;
import org.example.click_up.repository.PriorityRepository;
import org.example.click_up.repository.StatusRepository;
import org.example.click_up.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    PriorityRepository priorityRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Result createTask(TaskDto taskDto) {
        Task task = new Task();
        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        Optional<Status> optionalStatus = statusRepository.findById(taskDto.getStatusId());
        Status status = optionalStatus.get();
        task.setStatus(status);
        Optional<Category> categoryOptional = categoryRepository.findById(taskDto.getCategoryId());
        Category category = categoryOptional.get();
        task.setCategoryId(category);
        Optional<Priority> optionalPriority = priorityRepository.findById(taskDto.getPriorityId());
        Priority priority = optionalPriority.get();
        task.setPriorityId(priority);
        task.setParentTaskId(taskDto.getParentTaskId());
        taskRepository.save(task);
        return new Result(true,"Task created successfully");
    }

    public Result updateTask(TaskDto taskDto,Long id) {
        Optional<Task> optional = taskRepository.findById(id);
        if (optional.isPresent()){
            Task task = optional.get();
            task.setName(taskDto.getName());
            task.setDescription(taskDto.getDescription());
            Optional<Status> optionalStatus = statusRepository.findById(taskDto.getStatusId());
            Status status = optionalStatus.get();
            task.setStatus(status);
            Optional<Category> categoryOptional = categoryRepository.findById(taskDto.getCategoryId());
            Category category = categoryOptional.get();
            task.setCategoryId(category);
            Optional<Priority> optionalPriority = priorityRepository.findById(taskDto.getPriorityId());
            Priority priority = optionalPriority.get();
            task.setPriorityId(priority);
            task.setParentTaskId(taskDto.getParentTaskId());
            taskRepository.save(task);
            return new Result(true,"Task updated successfully");
        }
        return new Result(false,"Task not found");
    }

    public Result deleteTask(Long id) {
        taskRepository.deleteById(id);
        return new Result(true,"Task deleted successfully");
    }
}
