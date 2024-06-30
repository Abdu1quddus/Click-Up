package org.example.click_up.controller;

import org.example.click_up.dto.Check_list_itemDto;
import org.example.click_up.model.Check_list_item;
import org.example.click_up.model.Result;
import org.example.click_up.service.Check_list_itemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/check_list_item")
public class Check_list_itemController {

    @Autowired
    Check_list_itemService check_list_itemService;

    @GetMapping()
    public List<Check_list_item> getAllCheck_list_item(){
        return check_list_itemService.getAllCheck_list_items();
    }

    @PostMapping()
    public Result createCheck_list_item(@RequestBody Check_list_itemDto check_list_itemDto){
        return check_list_itemService.createCheck_list_item(check_list_itemDto);
    }

    @PutMapping("/{id")
    public Result updateCheck_list_item(@RequestBody Check_list_itemDto check_list_itemDto,@PathVariable Long id){
        return check_list_itemService.updateCheck_list_item(check_list_itemDto,id);
    }

    @DeleteMapping("/{id}")
    public Result deleteCheck_list_item(@PathVariable Long id){
        return check_list_itemService.deleteCheck_list_item(id);
    }
}
