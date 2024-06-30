package org.example.click_up.service;

import org.example.click_up.dto.Space_userDto;
import org.example.click_up.model.Result;
import org.example.click_up.model.Space;
import org.example.click_up.model.Space_user;
import org.example.click_up.repository.SpaceRepository;
import org.example.click_up.repository.Space_userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Space_userService {

    @Autowired
    Space_userRepository space_userRepository;

    @Autowired
    SpaceRepository spaceRepository;

    public List<Space_user> getAllSpaceUsers() {
        return space_userRepository.findAll();
    }

    public Result createSpaceUser(Space_userDto space_userDto) {
        Space_user space_user = new Space_user();
        Optional<Space> optionalSpace = spaceRepository.findById(space_userDto.getSpaceId());
        Space space = optionalSpace.get();
        space_user.setSpaceId(space);
        space_user.setMemberId(space_userDto.getMemberId());
        space_userRepository.save(space_user);
        return new Result(true,"Space user created");
    }

    public Result updateSpaceUser(Space_userDto space_userDto, Long Id) {
        Optional<Space_user> optionalSpace_user = space_userRepository.findById(Id);
        if (optionalSpace_user.isPresent()) {
            Space_user space_user = optionalSpace_user.get();
            Optional<Space> optionalSpace = spaceRepository.findById(space_userDto.getSpaceId());
            Space space = optionalSpace.get();
            space_user.setSpaceId(space);
            space_user.setMemberId(space_userDto.getMemberId());
            space_userRepository.save(space_user);
            return new Result(true,"Space user updated");
        }
        return new Result(false,"Space user not found");
    }

    public Result deleteSpaceUser(Long id) {
        space_userRepository.deleteById(id);
        return new Result(true,"Space user deleted");
    }

}
