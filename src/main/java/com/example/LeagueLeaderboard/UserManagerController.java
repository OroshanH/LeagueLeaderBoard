package com.example.LeagueLeaderboard;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserManagerController {

    @GetMapping
    public List<User> getUsers() {
        return UserManager.createUsers();
    }
}
