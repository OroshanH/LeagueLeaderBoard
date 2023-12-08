package com.example.LeagueLeaderboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class LeagueLeaderboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeagueLeaderboardApplication.class, args);
	}
	List<User> users = UserManager.createUsers();
}
