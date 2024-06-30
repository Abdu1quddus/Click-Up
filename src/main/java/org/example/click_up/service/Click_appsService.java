package org.example.click_up.service;

import org.example.click_up.dto.Click_appsDto;
import org.example.click_up.model.Click_apps;
import org.example.click_up.model.Icon;
import org.example.click_up.model.Result;
import org.example.click_up.repository.Click_appsRepository;
import org.example.click_up.repository.IconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Click_appsService {

    @Autowired
    Click_appsRepository click_appsRepository;

    @Autowired
    IconRepository iconRepository;

    public List<Click_apps> getAllClickApps() {
        return click_appsRepository.findAll();
    }

    public Result createClickApp(Click_appsDto click_appsDto) {
        Click_apps click_apps = new Click_apps();
        click_apps.setName(click_appsDto.getName());
        Optional<Icon> iconOptional = iconRepository.findById(click_appsDto.getIconId());
        Icon icon = iconOptional.get();
        click_apps.setIconId(icon);
        click_appsRepository.save(click_apps);
        return new Result(true, "Successfully created click_apps");
    }

    public Result updateClickApp(Click_appsDto click_appsDto,Long id) {
        Optional<Click_apps> clickAppsOptional = click_appsRepository.findById(id);
        if (clickAppsOptional.isPresent()) {
            Click_apps clickApps = clickAppsOptional.get();
            clickApps.setName(click_appsDto.getName());
            Optional<Icon> iconOptional = iconRepository.findById(click_appsDto.getIconId());
            Icon icon = iconOptional.get();
            clickApps.setIconId(icon);
            click_appsRepository.save(clickApps);
            return new Result(true, "Successfully updated click_apps");
        }
        return new Result(false, "Click_apps not found");
    }

    public Result deleteClickApp(Long id) {
        click_appsRepository.deleteById(id);
        return new Result(true, "Successfully deleted click_apps");
    }
}
