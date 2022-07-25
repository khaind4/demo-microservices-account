package com.khaind.microservices.account.controller;

import com.khaind.microservices.account.dto.UserDTO;
import com.khaind.microservices.account.entity.UserEntity;
import com.khaind.microservices.account.mapper.UserMapper;
import com.khaind.microservices.account.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Value("${name}")
    private String applicationName;

    @PostMapping
    public UserDTO upsert(@RequestBody UserDTO dto) {
        UserEntity entity = userRepository.save(userMapper.toEntity(dto));
        return userMapper.toDTO(entity);
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Long id) {
        Optional<UserEntity> entity = userRepository.findById(id);
        if (entity.isPresent()) {
            return userMapper.toDTO(entity.get());
        }
        return null;
    }

    @GetMapping
    public List<UserDTO> getUsers() {
        return userMapper.toDTOs(userRepository.findAll());
    }

    @GetMapping("/gender/{gender}")
    public List<UserDTO> findByGender(@PathVariable String gender) {
        return userMapper.toDTOs(userRepository.findByGender(gender));
    }

    @GetMapping("/name/{name}")
    public List<UserDTO> findByName(@PathVariable String name) {
        return userMapper.toDTOs(userRepository.findByNameLike("%" + name + "%"));
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        try {
            userRepository.deleteById(id);
            return "success";
        } catch (Exception e) {
            System.out.printf("Delete user error: " + e);
        }
        return "fail";
    }

    @GetMapping("/test")
    public String test() {
        return applicationName;
    }
}
