package org.example.click_up.service;

import org.apache.logging.log4j.message.ReusableMessage;
import org.example.click_up.dto.Time_trackedDto;
import org.example.click_up.model.Result;
import org.example.click_up.model.Task;
import org.example.click_up.model.Time_tracked;
import org.example.click_up.repository.TaskRepository;
import org.example.click_up.repository.Time_trackedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Time_trackedService {

    @Autowired
    Time_trackedRepository time_trackedRepository;

    @Autowired
    TaskRepository taskRepository;

    public List<Time_tracked> getAllTime_tracked() {
        return time_trackedRepository.findAll();
    }

    public Result createTime_tracked(Time_trackedDto time_trackedDto) {
        Time_tracked timeTracked = new Time_tracked();
        Optional<Task> optional = taskRepository.findById(time_trackedDto.getTaskId());
        Task task = optional.get();
        timeTracked.setTaskId(task);
        time_trackedRepository.save(timeTracked);
        return new Result(true,"Time_tracked successfully created");
    }

    public Result updateTime_tracked(Time_trackedDto time_trackedDto,Long id) {
        Optional<Time_tracked> optional = time_trackedRepository.findById(id);
        if (optional.isPresent()) {
            Time_tracked timeTracked = optional.get();
            Optional<Task> optionalTimeTracked = taskRepository.findById(time_trackedDto.getTaskId());
            Task task = optionalTimeTracked.get();
            timeTracked.setTaskId(task);
            time_trackedRepository.save(timeTracked);
            return new Result(true,"Time_tracked successfully updated");
        }
        return new Result(false,"Time_tracked successfully updated");
    }

    public Result deleteTime_tracked(Long id) {
        time_trackedRepository.deleteById(id);
        return new Result(true,"Time_tracked successfully deleted");
    }
}
