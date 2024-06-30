package org.example.click_up.service;

import org.example.click_up.dto.Category_userDto;
import org.example.click_up.model.Category;
import org.example.click_up.model.Category_user;
import org.example.click_up.model.Result;
import org.example.click_up.model.User;
import org.example.click_up.repository.CategoryRepository;
import org.example.click_up.repository.Category_userRepository;
import org.example.click_up.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Category_userService {

    @Autowired
    Category_userRepository category_userRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    UserRepository userRepository;

    public List<Category_user> getAllCategory_users() {
        return category_userRepository.findAll();
    }

    public Result createCategory_user(Category_userDto category_userDto) {
        Category_user category_user = new Category_user();
        category_user.setName(category_userDto.getName());
        Optional<Category> categoryOptional = categoryRepository.findById(category_userDto.getCategoryId());
        Category category = categoryOptional.get();
        category_user.setCategoryId(category);
        Optional<User> userOptional = userRepository.findById(category_userDto.getUserId());
        User user = userOptional.get();
        category_user.setUserId(user);
        category_userRepository.save(category_user);
        return new Result(true, "Category user created");
    }

    public Result updateCategory_user(Category_userDto category_userDto,Long id) {
        Optional<Category_user> categoryUserOptional = category_userRepository.findById(id);
        if (categoryUserOptional.isPresent()) {
            Category_user category_user = categoryUserOptional.get();
            category_user.setName(category_userDto.getName());
            Optional<Category> categoryOptional = categoryRepository.findById(category_userDto.getCategoryId());
            Category category = categoryOptional.get();
            category_user.setCategoryId(category);
            Optional<User> userOptional = userRepository.findById(category_userDto.getUserId());
            User user = userOptional.get();
            category_user.setUserId(user);
            category_userRepository.save(category_user);
            return new Result(true, "Category user updated");
        }
        return new Result(false, "Category user not found");
    }

    public Result deleteCategory_user(Long id) {
        category_userRepository.deleteById(id);
        return new Result(true, "Category user deleted");
    }
}
