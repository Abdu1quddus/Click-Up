package org.example.click_up.service;

import org.example.click_up.dto.Check_listDto;
import org.example.click_up.model.Check_list;
import org.example.click_up.model.Result;
import org.example.click_up.model.Task;
import org.example.click_up.repository.Check_listRepository;
import org.example.click_up.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Check_listService {

    @Autowired
    Check_listRepository check_listRepository;

    @Autowired
    TaskRepository taskRepository;

    public List<Check_list> getAllCheck_list() {
        return check_listRepository.findAll();
    }

    public Result createCheck_list(Check_listDto check_listDto) {
        Check_list check_list = new Check_list();
        check_list.setName(check_listDto.getName());
        Optional<Task> optional = taskRepository.findById(check_listDto.getTaskId());
        Task task = optional.get();
        check_list.setTaskId(task);
        check_listRepository.save(check_list);
        return new Result(true,"Check_list created successfully");
    }

    public Result updateCheck_list(Check_listDto check_listDto,Long id) {
        Optional<Check_list> optional = check_listRepository.findById(id);
        if (optional.isPresent()){
            Check_list check_list = optional.get();
            check_list.setName(check_listDto.getName());
            Optional<Task> optionalTask = taskRepository.findById(check_listDto.getTaskId());
            Task task = optionalTask.get();
            check_list.setTaskId(task);
            check_listRepository.save(check_list);
            return new Result(true,"Check_list updated successfully");
        }
        return new Result(false,"Check_list not found");
    }

    public Result deleteCheck_list(Long id) {
        check_listRepository.deleteById(id);
        return new Result(true,"Check_list deleted successfully");
    }
}
