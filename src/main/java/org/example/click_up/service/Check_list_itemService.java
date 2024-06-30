package org.example.click_up.service;

import org.example.click_up.dto.Check_list_itemDto;
import org.example.click_up.model.Check_list;
import org.example.click_up.model.Check_list_item;
import org.example.click_up.model.Result;
import org.example.click_up.repository.Check_listRepository;
import org.example.click_up.repository.Check_list_itemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Service
public class Check_list_itemService {

    @Autowired
    Check_list_itemRepository check_list_itemRepository;

    @Autowired
    Check_listRepository check_listRepository;

    public List<Check_list_item> getAllCheck_list_items() {
        return check_list_itemRepository.findAll();
    }

    public Result createCheck_list_item(Check_list_itemDto check_list_itemDto) {
        Check_list_item check_list_item = new Check_list_item();
        check_list_item.setName(check_list_itemDto.getName());
        Optional<Check_list> checkListOptional = check_listRepository.findById(check_list_itemDto.getCheck_listId());
        Check_list checkList = checkListOptional.get();
        check_list_item.setCheck_listId(checkList);
        check_list_item.setResolved(check_list_itemDto.getResolved());
        check_list_item.setAssigned_userId(check_list_itemDto.getAssigned_userId());
        check_list_itemRepository.save(check_list_item);
        return new Result(true,"Successfully created check_list_item");
    }

    public Result updateCheck_list_item(Check_list_itemDto check_list_itemDto,Long id) {
        Optional<Check_list_item> optional = check_list_itemRepository.findById(id);
        if (optional.isPresent()) {
            Check_list_item check_list_item = optional.get();
            check_list_item.setName(check_list_itemDto.getName());
            Optional<Check_list> checkListOptional = check_listRepository.findById(check_list_itemDto.getCheck_listId());
            Check_list checkList = checkListOptional.get();
            check_list_item.setCheck_listId(checkList);
            check_list_item.setResolved(check_list_itemDto.getResolved());
            check_list_item.setAssigned_userId(check_list_itemDto.getAssigned_userId());
            check_list_itemRepository.save(check_list_item);
            return new Result(true,"Successfully updated check_list_item");
        }
        return new Result(false,"Check_list_item not found");
    }

    public Result deleteCheck_list_item(Long id) {
        check_list_itemRepository.deleteById(id);
        return new Result(true,"Successfully deleted check_list_item");
    }

}
