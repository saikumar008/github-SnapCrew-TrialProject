package com.photoProject.Snapcrew.Service;

import com.photoProject.Snapcrew.Dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {

    public List<UserDto> getAllUsers();

    public UserDto getUserById(UUID id);

    public UserDto updateUser(UUID id, UserDto userDto);

    public void deleteUser(UUID id);

    public UserDto createUser(UserDto userDto);

//    public List<UserDto> searchUsers(String keyword);


}
