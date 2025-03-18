package com.example.online_test_sys_proj;

import com.example.online_test_sys_proj.models.UserEntity;
import com.example.online_test_sys_proj.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestInit implements CommandLineRunner {
    UserRepository userRepository;

    public TestInit(UserRepository userRepository) {
        this.userRepository = userRepository;

    }


    @Override
    public void run(String... args) throws Exception {
        if(userRepository.count() == 0){
            initUser();
        }
    }

    private void initUser(){
        UserEntity user = new UserEntity();
        user.setFirstName("John");
        user.setLastName("Wick");
        user.setEmail("cando@better.com");
        user.setPassword("1231");
        userRepository.save(user);
    }
}
