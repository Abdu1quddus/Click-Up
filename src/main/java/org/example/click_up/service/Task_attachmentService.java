package org.example.click_up.service;

import org.apache.logging.log4j.message.ReusableMessage;
import org.example.click_up.dto.Task_attachmentDto;
import org.example.click_up.model.Attachment;
import org.example.click_up.model.Result;
import org.example.click_up.model.Task;
import org.example.click_up.model.Task_attachment;
import org.example.click_up.repository.AttachmentRepository;
import org.example.click_up.repository.TaskRepository;
import org.example.click_up.repository.Task_attachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Task_attachmentService {

    @Autowired
    Task_attachmentRepository task_attachmentRepository;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    AttachmentRepository attachmentRepository;

    public List<Task_attachment> getAllTask_attachments(){
        return task_attachmentRepository.findAll();
    }

    public Result createTask_attachment(Task_attachmentDto task_attachmentDto){
        Task_attachment taskAttachment = new Task_attachment();
        Optional<Task> taskOptional = taskRepository.findById(task_attachmentDto.getTaskId());
        Task task = taskOptional.get();
        taskAttachment.setTaskId(task);
        Optional<Attachment> attachmentOptional = attachmentRepository.findById(task_attachmentDto.getAttachmentId());
        Attachment attachment = attachmentOptional.get();
        taskAttachment.setAttachmentId(attachment);
        task_attachmentRepository.save(taskAttachment);
        return new Result(true,"Task attachment created");
    }

    public Result updateTask_attachment(Task_attachmentDto task_attachmentDto,Long id){
        Optional<Task_attachment> optional = task_attachmentRepository.findById(id);
        if (optional.isPresent()){
            Task_attachment taskAttachment = optional.get();
            Optional<Task> taskOptional = taskRepository.findById(task_attachmentDto.getTaskId());
            Task task = taskOptional.get();
            taskAttachment.setTaskId(task);
            Optional<Attachment> attachmentOptional = attachmentRepository.findById(task_attachmentDto.getAttachmentId());
            Attachment attachment = attachmentOptional.get();
            taskAttachment.setAttachmentId(attachment);
            task_attachmentRepository.save(taskAttachment);
            return new Result(true,"Task attachment updated");
        }
        return new Result(false,"Task attachment not found");
    }

    public Result deleteTask_attachment(Long id){
        task_attachmentRepository.deleteById(id);
        return new Result(true,"Task attachment deleted");
    }

}
