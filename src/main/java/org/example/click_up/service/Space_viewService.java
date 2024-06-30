package org.example.click_up.service;

import org.example.click_up.dto.Space_viewDto;
import org.example.click_up.model.Result;
import org.example.click_up.model.Space;
import org.example.click_up.model.Space_view;
import org.example.click_up.model.View;
import org.example.click_up.repository.SpaceRepository;
import org.example.click_up.repository.Space_viewRepository;
import org.example.click_up.repository.ViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Space_viewService {

    @Autowired
    Space_viewRepository space_viewRepository;

    @Autowired
    SpaceRepository spaceRepository;

    @Autowired
    ViewRepository viewRepository;

    public List<Space_view> getAllSpace_views() {
        return space_viewRepository.findAll();
    }

    public Result createSpace_view(Space_viewDto space_viewDto) {
        Space_view space_view = new Space_view();
        Optional<Space> optionalSpace = spaceRepository.findById(space_viewDto.getSpaceId());
        Space space = optionalSpace.get();
        space_view.setSpaceId(space);
        Optional<View> viewOptional = viewRepository.findById(space_viewDto.getViewId());
        View view = viewOptional.get();
        space_view.setViewId(view);
        space_viewRepository.save(space_view);
        return new Result(true,"Successfully created space view");
    }

    public Result updateSpace_view(Space_viewDto space_viewDto,Long id) {
        Optional<Space_view> spaceViewOptional = space_viewRepository.findById(id);
        if (spaceViewOptional.isPresent()) {
            Space_view space_view = spaceViewOptional.get();
            Optional<Space> optionalSpace = spaceRepository.findById(space_viewDto.getSpaceId());
            Space space = optionalSpace.get();
            space_view.setSpaceId(space);
            Optional<View> viewOptional = viewRepository.findById(space_viewDto.getViewId());
            View view = viewOptional.get();
            space_view.setViewId(view);
            space_viewRepository.save(space_view);
            return new Result(true,"Successfully updated space view");
        }
        return new Result(false,"Space not found");
    }

    public Result deleteSpace_view(Long id) {
        space_viewRepository.deleteById(id);
        return new Result(true,"Successfully deleted space view");
    }

}
