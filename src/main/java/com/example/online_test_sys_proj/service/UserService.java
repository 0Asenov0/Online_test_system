package com.example.online_test_sys_proj.service;

import com.example.online_test_sys_proj.dto.UserProfileInfoDTO;
import com.example.online_test_sys_proj.dto.UserRegisterDTO;

public interface UserService {
    boolean registerUser(UserRegisterDTO userRegisterDTO);
    UserProfileInfoDTO getUser(String email);
    boolean passwordMatch(UserRegisterDTO userRegisterDto);
    boolean updateUser(Long id, UserProfileInfoDTO userProfileInfoDto);
    UserProfileInfoDTO findById(Long id);
}
