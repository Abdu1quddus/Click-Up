package org.example.click_up.service;

import org.example.click_up.dto.AttachmentDto;
import org.example.click_up.model.Attachment;
import org.example.click_up.model.Result;
import org.example.click_up.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService{

    @Autowired
    AttachmentRepository attachmentRepository;

    public List<Attachment> getAttachments(){
        return attachmentRepository.findAll();
    }

    public Result createAttachment(AttachmentDto attachmentDto){
        Attachment attachment = new Attachment();
        attachment.setName(attachmentDto.getName());
        attachment.setSize(attachmentDto.getSize());
        attachment.setContent_type(attachmentDto.getContent_type());
        attachment.setOriginal_name(attachmentDto.getOriginal_name());
        attachmentRepository.save(attachment);
        return new Result(true, "Attachment created");
    }
    public Result updateAttachment(AttachmentDto attachmentDto, Long id){
        Optional<Attachment> attachmentOptional = attachmentRepository.findById(id);
        if(attachmentOptional.isPresent()){
            Attachment attachment = attachmentOptional.get();
            attachment.setName(attachmentDto.getName());
            attachment.setSize(attachmentDto.getSize());
            attachment.setContent_type(attachmentDto.getContent_type());
            attachment.setOriginal_name(attachmentDto.getOriginal_name());
            attachmentRepository.save(attachment);
            return new Result(true, "Attachment updated");
        }
        return new Result(false, "Attachment not found");
    }

    public Result deleteAttachment(Long id){
        attachmentRepository.deleteById(id);
        return new Result(true, "Attachment deleted");
    }

}
