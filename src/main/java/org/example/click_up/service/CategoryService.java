package org.example.click_up.service;

import org.example.click_up.dto.CategoryDto;
import org.example.click_up.dto.ProjectDto;
import org.example.click_up.model.Category;
import org.example.click_up.model.Project;
import org.example.click_up.model.Result;
import org.example.click_up.model.Space;
import org.example.click_up.repository.CategoryRepository;
import org.example.click_up.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProjectRepository projectRepository;

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public Result createCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        Optional<Project> projectOptional = projectRepository.findById(categoryDto.getProjectId());
        Project project = projectOptional.get();
        category.setProjectId(project);
        category.setAccess_type(categoryDto.getAccess_type());
        category.setArchived(categoryDto.getArchived());
        category.setColor(categoryDto.getColor());
        categoryRepository.save(category);
        return new Result(true,"Category created");
    }

    public Result updateCategory(CategoryDto categoryDto,Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            category.setName(categoryDto.getName());
            Optional<Project> projectOptional = projectRepository.findById(categoryDto.getProjectId());
            Project project = projectOptional.get();
            category.setProjectId(project);
            category.setAccess_type(categoryDto.getAccess_type());
            category.setArchived(categoryDto.getArchived());
            category.setColor(categoryDto.getColor());
            categoryRepository.save(category);
            return new Result(true,"Category updated");
        }
        return new Result(false,"Category not found");
    }

    public Result deleteCategory(Long id) {
        categoryRepository.deleteById(id);
        return new Result(true,"Category deleted");
    }
}
