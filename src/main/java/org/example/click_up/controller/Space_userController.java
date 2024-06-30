package org.example.click_up.controller;

import org.example.click_up.dto.Space_userDto;
import org.example.click_up.model.Result;
import org.example.click_up.model.Space_user;
import org.example.click_up.service.Space_userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/space_user")
public class Space_userController {

    @Autowired
    Space_userService space_userService;

    @GetMapping()
    public List<Space_user> getAllSpace_user() {
        return space_userService.getAllSpaceUsers();
    }

    @PostMapping()
    public Result createSpace_user(@RequestBody Space_userDto space_userDto) {
        return space_userService.createSpaceUser(space_userDto);
    }

    @PutMapping("/{id}")
    public Result updateSpace_user(@PathVariable Long id, @RequestBody Space_userDto space_userDto) {
        return space_userService.updateSpaceUser(space_userDto,id);
    }

    @DeleteMapping("/{id}")
    public Result deleteSpace_user(@PathVariable Long id) {
        return space_userService.deleteSpaceUser(id);
    }

}
