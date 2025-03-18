package com.example.online_test_sys_proj.service;

import com.example.online_test_sys_proj.dto.UserProfileInfoDTO;
import com.example.online_test_sys_proj.dto.UserRegisterDTO;
import com.example.online_test_sys_proj.models.UserEntity;
import com.example.online_test_sys_proj.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;

   private final UserRepository userRepository;

    public UserServiceImpl( UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public boolean registerUser(UserRegisterDTO userRegisterDTO) {
       String email = userRegisterDTO.getEmail();
       if(userRepository.findUserByEmail(email).isEmpty()){
           userRepository.save(mapToUser(userRegisterDTO));
       }
       return false;
    }

    @Override
    public UserProfileInfoDTO getUser(String email) {
        UserEntity user = userRepository.findUserByEmail(email).get();

        if(user == null){
            return null;
        }

         UserProfileInfoDTO userProfileInfoDTO = mapToUserInfo(user);
         // TODO: ADD LIST OF GRADES IN THR INFO DTO
        return userProfileInfoDTO;

    }

    @Override
    public boolean passwordMatch(UserRegisterDTO userRegisterDto) {
        return userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword());
    }

    @Override
    public boolean updateUser(Long id, UserProfileInfoDTO userProfileInfoDto) {
        return false;
    }

    @Override
    public UserProfileInfoDTO findById(Long id) {
        UserEntity user = userRepository.findById(id).get();
        if(user == null){

        }
        UserProfileInfoDTO userInfo;
        return  userInfo= mapToUserInfo(user);
    }

    public UserEntity mapToUser(UserRegisterDTO userRegisterDTO){
        UserEntity user = new UserEntity();
        user.setActive(false);
        user.setFirstName(userRegisterDTO.getFirstName());
        user.setLastName(userRegisterDTO.getFirstName());
        user.setEmail(userRegisterDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        return user;
    }
    public UserProfileInfoDTO mapToUserInfo(UserEntity user){
        UserProfileInfoDTO userInfoDto = new UserProfileInfoDTO();
        userInfoDto.setActive(user.isActive());
        userInfoDto.setFirstName(user.getFirstName());
        userInfoDto.setLastName(user.getFirstName());
        userInfoDto.setEmail(user.getEmail());

        return userInfoDto;
    }
}
