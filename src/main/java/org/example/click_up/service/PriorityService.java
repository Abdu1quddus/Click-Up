package org.example.click_up.service;

import org.example.click_up.dto.PriorityDto;
import org.example.click_up.model.Icon;
import org.example.click_up.model.Priority;
import org.example.click_up.model.Result;
import org.example.click_up.repository.IconRepository;
import org.example.click_up.repository.PriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriorityService {

   @Autowired
   PriorityRepository priorityRepository;

   @Autowired
    IconRepository iconRepository;

   public List<Priority> getAllPriority() {
       return priorityRepository.findAll();
   }

   public Result createPriority(PriorityDto priorityDto) {
       Priority priority = new Priority();
       priority.setName(priorityDto.getName());
       Optional<Icon> iconOptional = iconRepository.findById(priorityDto.getIconId());
       Icon icon = iconOptional.get();
       priority.setIconId(icon);
       priorityRepository.save(priority);
       return new Result(true,"Priority created");
   }

   public Result updatePriority(Long id, PriorityDto priorityDto) {
       Optional<Priority> priorityOptional = priorityRepository.findById(id);
       if (priorityOptional.isPresent()){
           Priority priority = priorityOptional.get();
           priority.setName(priorityDto.getName());
           Optional<Icon> iconOptional = iconRepository.findById(priorityDto.getIconId());
           Icon icon = iconOptional.get();
           priority.setIconId(icon);
           priorityRepository.save(priority);
           return new Result(true,"Priority updated");
       }
       return new Result(false,"Priority not found");
   }

   public Result deletePriority(Long id) {
       priorityRepository.deleteById(id);
       return new Result(true,"Priority deleted");
   }

}
