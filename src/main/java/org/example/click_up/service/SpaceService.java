package org.example.click_up.service;

import org.example.click_up.dto.SpaceDto;
import org.example.click_up.model.Icon;
import org.example.click_up.model.Result;
import org.example.click_up.model.Space;
import org.example.click_up.model.Workspace;
import org.example.click_up.repository.IconRepository;
import org.example.click_up.repository.SpaceRepository;
import org.example.click_up.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpaceService {

    @Autowired
    SpaceRepository spaceRepository;

    @Autowired
    WorkspaceRepository workspaceRepository;

    @Autowired
    IconRepository iconRepository;

    public List<Space> getAllSpaces(){
        return spaceRepository.findAll();
    }

    public Result createSpace(SpaceDto spaceDto){
        boolean exists = spaceRepository.existsByName(spaceDto.getName());
        if(exists){
            return new Result(false, "Space already exists");
        }
        Space space = new Space();
        space.setName(spaceDto.getName());
        space.setColor(spaceDto.getColor());
        space.setInitialLetter(spaceDto.getInitialLetter());
        space.setAvatarId(spaceDto.getAvatarId());
        space.setOwnerId(spaceDto.getOwnerId());
        Optional<Workspace> workspaceOptional = workspaceRepository.findById(spaceDto.getWorkspaceId());
        Workspace workspace = workspaceOptional.get();
        space.setWorkspaceId(workspace);
        Optional<Icon> iconOptional = iconRepository.findById(spaceDto.getIconId());
        Icon icon = iconOptional.get();
        space.setIcon(icon);
        spaceRepository.save(space);
        return new Result(true,"Space created");
    }

    

}
