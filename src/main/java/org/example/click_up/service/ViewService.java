package org.example.click_up.service;

import org.example.click_up.dto.ViewDto;
import org.example.click_up.model.Icon;
import org.example.click_up.model.Result;
import org.example.click_up.model.View;
import org.example.click_up.repository.IconRepository;
import org.example.click_up.repository.ViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ViewService {

    @Autowired
    ViewRepository viewRepository;

    @Autowired
    IconRepository iconRepository;

    public List<View> getAllViews() {
        return viewRepository.findAll();
    }

    public View getViewById(Long id) {
        return viewRepository.getById(id);
    }

    public Result createView(ViewDto viewDto) {
        View view = new View();
        view.setName(viewDto.getName());
        Optional<Icon> iconOptional = iconRepository.findById(viewDto.getIconId());
        Icon icon = iconOptional.get();
        view.setIconId(icon);
        viewRepository.save(view);
        return new Result(true,"Successfully created view");
    }

    public Result updateView(ViewDto viewDto,Long id) {
        Optional<View> viewOptional = viewRepository.findById(id);
        if (viewOptional.isPresent()) {
            View view = viewOptional.get();
            view.setName(viewDto.getName());
            Optional<Icon> iconOptional = iconRepository.findById(viewDto.getIconId());
            Icon icon = iconOptional.get();
            view.setIconId(icon);
            viewRepository.save(view);
            return new Result(true,"Successfully updated view");
        }
        return new Result(false,"No such view");
    }

    public Result deleteView(Long id) {
        viewRepository.deleteById(id);
        return new Result(true,"Successfully deleted view");
    }

}
