package com.example.online_test_sys_proj.web;

import com.example.online_test_sys_proj.dto.UserProfileInfoDTO;
import com.example.online_test_sys_proj.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomePageController {
    private final UserService userService;

    public HomePageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String homePage(Model model){
        UserProfileInfoDTO userInfo = userService.findById(1L);
        model.addAttribute("userDataDemo",userInfo);
        return "index.html";
    }
}
