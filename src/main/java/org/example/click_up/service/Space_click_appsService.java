package org.example.click_up.service;

import org.example.click_up.dto.Space_click_appsDto;
import org.example.click_up.model.Click_apps;
import org.example.click_up.model.Result;
import org.example.click_up.model.Space;
import org.example.click_up.model.Space_click_apps;
import org.example.click_up.repository.Click_appsRepository;
import org.example.click_up.repository.SpaceRepository;
import org.example.click_up.repository.Space_click_appsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Space_click_appsService {

    @Autowired
    Space_click_appsRepository space_click_appsRepository;

    @Autowired
    SpaceRepository spaceRepository;

    @Autowired
    Click_appsRepository click_appsRepository;

    public List<Space_click_apps> getAllSpace_click_apps() {
        return space_click_appsRepository.findAll();
    }

    public Result createSpace_click_apps(Space_click_appsDto space_click_appsDto) {
        Space_click_apps spaceClickApps = new Space_click_apps();
        Optional<Space> optionalSpace = spaceRepository.findById(space_click_appsDto.getSpaceId());
        Space space = optionalSpace.get();
        spaceClickApps.setSpaceId(space);
        Optional<Click_apps> clickAppsOptional = click_appsRepository.findById(space_click_appsDto.getClick_appsId());
        Click_apps clickApps = clickAppsOptional.get();
        spaceClickApps.setClick_appsId(clickApps);
        space_click_appsRepository.save(spaceClickApps);
        return new Result(true,"Successfully created space click apps");
    }

    public Result updateSpace_click_apps(Space_click_appsDto space_click_appsDto,Long id) {
        Optional<Space_click_apps> spaceClickAppsOptional = space_click_appsRepository.findById(id);
        if (spaceClickAppsOptional.isPresent()) {
            Space_click_apps spaceClickApps = spaceClickAppsOptional.get();
            Optional<Space> optionalSpace = spaceRepository.findById(space_click_appsDto.getSpaceId());
            Space space = optionalSpace.get();
            spaceClickApps.setSpaceId(space);
            Optional<Click_apps> clickAppsOptional = click_appsRepository.findById(space_click_appsDto.getClick_appsId());
            Click_apps clickApps = clickAppsOptional.get();
            spaceClickApps.setClick_appsId(clickApps);
            space_click_appsRepository.save(spaceClickApps);
            return new Result(true,"Successfully updated space click apps");
        }
        return new Result(false,"Space not found");
    }

    public Result deleteSpace_click_apps(Long id) {
        space_click_appsRepository.deleteById(id);
        return new Result(true,"Successfully deleted space click apps");
    }

}
