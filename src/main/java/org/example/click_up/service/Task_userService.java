package org.example.click_up.service;

import org.example.click_up.dto.Task_userDto;
import org.example.click_up.model.Result;
import org.example.click_up.model.Task;
import org.example.click_up.model.Task_user;
import org.example.click_up.model.User;
import org.example.click_up.repository.TaskRepository;
import org.example.click_up.repository.Task_userRepository;
import org.example.click_up.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Task_userService {

    @Autowired
    Task_userRepository task_userRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskRepository taskRepository;

    public List<Task_user> getAllTask_users() {
        return task_userRepository.findAll();
    }

    public Result createTask_user(Task_userDto task_userDto) {
        Task_user task_user = new Task_user();
        Optional<Task> optionalTask = taskRepository.findById(task_userDto.getTaskId());
        Task task = optionalTask.get();
        task_user.setTaskId(task);
        Optional<User> optionalUser = userRepository.findById(task_userDto.getUserId());
        User user = optionalUser.get();
        task_user.setUserId(user);
        task_userRepository.save(task_user);
        return new Result(true,"Task user created");
    }

    public Result updateTask_user(Task_userDto task_userDto,Long id) {
        Optional<Task_user> optional = task_userRepository.findById(id);
        if (optional.isPresent()) {
            Task_user task_user = optional.get();
            Optional<Task> optionalTask = taskRepository.findById(task_userDto.getTaskId());
            Task task = optionalTask.get();
            task_user.setTaskId(task);
            Optional<User> optionalUser = userRepository.findById(task_userDto.getUserId());
            User user = optionalUser.get();
            task_user.setUserId(user);
            task_userRepository.save(task_user);
            return new Result(true,"Task user updated");
        }
        return new Result(false,"Task user not found");
    }

    public Result deleteTask_user(Long id) {
        task_userRepository.deleteById(id);
        return new Result(true,"Task user deleted");
    }
}
