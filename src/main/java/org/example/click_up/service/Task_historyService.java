package org.example.click_up.service;

import org.example.click_up.dto.Task_historyDto;
import org.example.click_up.model.Result;
import org.example.click_up.model.Task;
import org.example.click_up.model.Task_history;
import org.example.click_up.repository.TaskRepository;
import org.example.click_up.repository.Task_historyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Task_historyService {

    @Autowired
    Task_historyRepository task_historyRepository;

    @Autowired
    TaskRepository taskRepository;

    public List<Task_history> getAllTask_history() {
        return task_historyRepository.findAll();
    }

    public Result createTask_history(Task_historyDto task_historyDto) {
        Task_history taskHistory = new Task_history();
        Optional<Task> optionalTask = taskRepository.findById(task_historyDto.getTaskId());
        Task task = optionalTask.get();
        taskHistory.setTaskId(task);
        taskHistory.setChange_field_name(task_historyDto.getChange_field_name());
        task_historyRepository.save(taskHistory);
        return new Result(true,"Task history created");
    }

    public Result updateTask_history(Task_historyDto task_historyDto,Long id) {
        Optional<Task_history> optional = task_historyRepository.findById(id);
        if (optional.isPresent()){
            Task_history taskHistory = optional.get();
            Optional<Task> optionalTask = taskRepository.findById(task_historyDto.getTaskId());
            Task task = optionalTask.get();
            taskHistory.setTaskId(task);
            taskHistory.setChange_field_name(task_historyDto.getChange_field_name());
            task_historyRepository.save(taskHistory);
            return new Result(true,"Task history updated");
        }
        return new Result(false,"Task history not found");
    }

    public Result deleteTask_history(Long id) {
        task_historyRepository.deleteById(id);
        return new Result(true,"Task history deleted");
    }
}
