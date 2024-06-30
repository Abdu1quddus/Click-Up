package org.example.click_up.controller;

import org.example.click_up.dto.CategoryDto;
import org.example.click_up.model.Category;
import org.example.click_up.model.Result;
import org.example.click_up.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{id}")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping()
    public List<Category> getAllCategories() {
        return categoryService.getAllCategory();
    }

    @PostMapping()
    public Result createCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.createCategory(categoryDto);
    }

    @PutMapping("/{id}")
    public Result updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
        return categoryService.updateCategory(categoryDto,id);
    }

    @DeleteMapping("/{id}")
    public Result deleteCategory(@PathVariable Long id) {
        return categoryService.deleteCategory(id);
    }

}
