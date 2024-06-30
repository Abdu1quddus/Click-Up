package org.example.click_up.service;

import org.example.click_up.dto.TagDto;
import org.example.click_up.model.Result;
import org.example.click_up.model.Tag;
import org.example.click_up.model.Workspace;
import org.example.click_up.repository.TagRepository;
import org.example.click_up.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    @Autowired
    TagRepository tagRepository;

    @Autowired
    WorkspaceRepository workspaceRepository;

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public Result createTag(TagDto tagDto) {
        Tag tag = new Tag();
        tag.setName(tagDto.getName());
        tag.setColor(tagDto.getColor());
        Optional<Workspace> workspaceOptional = workspaceRepository.findById(tagDto.getWorkspaceId());
        Workspace workspace = workspaceOptional.get();
        tag.setWorkspaceId(workspace);
        tagRepository.save(tag);
        return new Result(true,"Tag created");
    }

    public Result updateTag(TagDto tagDto,Long id) {
        Optional<Tag> tagOptional = tagRepository.findById(id);
        if (tagOptional.isPresent()) {
            Tag tag = tagOptional.get();
            tag.setName(tagDto.getName());
            tag.setColor(tagDto.getColor());
            Optional<Workspace> workspaceOptional = workspaceRepository.findById(tagDto.getWorkspaceId());
            Workspace workspace = workspaceOptional.get();
            tag.setWorkspaceId(workspace);
            tagRepository.save(tag);
            return new Result(true,"Tag updated");
        }
        return new Result(false,"Tag not found");
    }

    public Result deleteTag(Long id) {
        tagRepository.deleteById(id);
        return new Result(true,"Tag deleted");
    }

}
