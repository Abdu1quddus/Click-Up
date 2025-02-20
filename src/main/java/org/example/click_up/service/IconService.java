package org.example.click_up.service;

import org.example.click_up.model.Icon;
import org.example.click_up.repository.AttachmentRepository;
import org.example.click_up.repository.IconRepository;
import org.example.click_up.dto.IconDto;
import org.example.click_up.model.Attachment;
import org.example.click_up.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class IconService {
    @Autowired
    IconRepository iconRepository;
    @Autowired
    AttachmentRepository attachmentRepository;

    public List<Icon> getAllIcons(){
        return iconRepository.findAll();
    }

    public Result createIcon(IconDto iconDto){
        Icon icon = new Icon();
        icon.setIcon(iconDto.getIcon());
        icon.setColor(iconDto.getColor());
        icon.setInitialLetter(iconDto.getInitialLetter());
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(iconDto.getAttachmentId());
        Attachment attachment = optionalAttachment.get();
        icon.setAttachmentId(attachment);
        iconRepository.save(icon);
        return new Result(true,"Icon created successfully");
    }

    public Result updateIcon(IconDto iconDto,Long id){
        Optional<Icon> optionalIcon = iconRepository.findById(id);
        if(optionalIcon.isPresent()){
            Icon icon = optionalIcon.get();
            icon.setIcon(iconDto.getIcon());
            icon.setColor(iconDto.getColor());
            icon.setInitialLetter(iconDto.getInitialLetter());
            Optional<Attachment> optionalAttachment = attachmentRepository.findById(iconDto.getAttachmentId());
            Attachment attachment = optionalAttachment.get();
            icon.setAttachmentId(attachment);
            iconRepository.save(icon);
            return new Result(true,"Icon updated successfully");
        }
        return new Result(false,"Icon not found");
    }

    public Result deleteIcon(Long id){
        iconRepository.deleteById(id);
        return new Result(true,"Icon deleted successfully");
    }
}