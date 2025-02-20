package org.example.click_up.service;

import org.example.click_up.dto.UserDto;
import org.example.click_up.model.Result;
import org.example.click_up.model.User;
import org.example.click_up.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public Result createUser(UserDto userDto) {
        boolean exists = userRepository.existsByEmailAndFullName(userDto.getEmail(), userDto.getFullName());
        if (exists) {
            return new Result(false, "Email already exists");
        }
        User user = new User();
        user.setFullName(userDto.getFullName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setColor(userDto.getColor());
        user.setInitialLetter(userDto.getInitialLetter());
        user.setAvatarId(userDto.getAvatarId());
        userRepository.save(user);
        return new Result(true, "User created");
    }

    public Result updateUser(Long id, UserDto userDto) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setFullName(userDto.getFullName());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            user.setColor(userDto.getColor());
            user.setInitialLetter(userDto.getInitialLetter());
            user.setAvatarId(userDto.getAvatarId());
            userRepository.save(user);
            return new Result(true, "User updated");
        }
        return new Result(false, "User not found");
    }

    public Result deleteUser(Long id) {
        userRepository.deleteById(id);
        return new Result(true, "User deleted");
    }

}
