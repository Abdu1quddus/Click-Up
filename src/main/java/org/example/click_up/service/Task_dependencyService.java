package org.example.click_up.service;

import org.example.click_up.dto.Task_dependencyDto;
import org.example.click_up.model.Result;
import org.example.click_up.model.Task;
import org.example.click_up.model.Task_dependency;
import org.example.click_up.repository.TaskRepository;
import org.example.click_up.repository.Task_dependencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Task_dependencyService {

    @Autowired
    Task_dependencyRepository task_dependencyRepository;

    @Autowired
    TaskRepository taskRepository;

    public List<Task_dependency> getAllTask_dependencies() {
        return task_dependencyRepository.findAll();
    }

    public Result createTask_dependency(Task_dependencyDto task_dependencyDto) {
        Task_dependency task_dependency = new Task_dependency();
        Optional<Task> taskOptional = taskRepository.findById(task_dependencyDto.getTaskId());
        Task task = taskOptional.get();
        task_dependency.setTaskId(task);
        task_dependency.setDependency_taskId(task_dependencyDto.getDependency_taskId());
        task_dependencyRepository.save(task_dependency);
        return new Result(true,"Task dependency created");
    }

    public Result updateTask_dependency(Task_dependencyDto task_dependencyDto,Long id) {
        Optional<Task_dependency> optional = task_dependencyRepository.findById(id);
        if (optional.isPresent()){
            Task_dependency task_dependency = optional.get();
            Optional<Task> taskOptional = taskRepository.findById(task_dependencyDto.getTaskId());
            Task task = taskOptional.get();
            task_dependency.setTaskId(task);
            task_dependency.setDependency_taskId(task_dependencyDto.getDependency_taskId());
            task_dependencyRepository.save(task_dependency);
            return new Result(true,"Task dependency updated");
        }
        return new Result(false,"Task dependency not found");
    }

    public Result deleteTask_dependency(Long id) {
        task_dependencyRepository.deleteById(id);
        return new Result(true,"Task dependency deleted");
    }
}
