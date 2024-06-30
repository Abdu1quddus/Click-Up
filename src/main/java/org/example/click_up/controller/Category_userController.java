package org.example.click_up.controller;

import org.example.click_up.dto.Category_userDto;
import org.example.click_up.model.Category_user;
import org.example.click_up.model.Result;
import org.example.click_up.service.Category_userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category_user")
public class Category_userController {

    @Autowired
    Category_userService category_userService;

    @GetMapping()
    public List<Category_user> getAllCategory_user() {
        return category_userService.getAllCategory_users();
    }

    @PostMapping()
    public Result createCategory_user(@RequestBody Category_userDto category_userDto) {
        return category_userService.createCategory_user(category_userDto);
    }

    @PutMapping("/{id}")
    public Result updateCategory_user(@PathVariable Long id, @RequestBody Category_userDto category_userDto) {
        return category_userService.updateCategory_user(category_userDto,id);
    }

    @DeleteMapping("/{id}")
    public Result deleteCategory_user(@PathVariable Long id) {
        return category_userService.deleteCategory_user(id);
    }
}
