package com.giannis.usermanagement.service;

import com.giannis.usermanagement.dto.UserDTO;
import com.giannis.usermanagement.model.User;
import com.giannis.usermanagement.repository.UserRepository;
import com.giannis.usermanagement.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDTO> getAllUsers() {
        List<User> usersFromDb = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();

        for (User user : usersFromDb) {
            UserDTO dto = userMapper.toDTO(user);
            userDTOs.add(dto);
        }

        return userDTOs;
    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        return userMapper.toDTO(user);
    }

    public UserDTO saveUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}