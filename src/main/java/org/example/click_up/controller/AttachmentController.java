package org.example.click_up.controller;

import org.example.click_up.dto.AttachmentDto;
import org.example.click_up.model.Attachment;
import org.example.click_up.model.Result;
import org.example.click_up.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {

    @Autowired
    AttachmentService attachmentService;

    @GetMapping()
    public List<Attachment> getAttachments() {
        return attachmentService.getAttachments();
    }

    @PostMapping()
    public Result addAttachment(@RequestBody AttachmentDto attachmentDto) {
        return attachmentService.createAttachment(attachmentDto);
    }

    @PutMapping("/{id}")
    public Result updateAttachment(@PathVariable Long id, @RequestBody AttachmentDto attachmentDto) {
        return attachmentService.updateAttachment(attachmentDto, id);
    }

    @DeleteMapping("/{id")
    public Result deleteAttachment(@PathVariable Long id) {
        return attachmentService.deleteAttachment(id);
    }
}