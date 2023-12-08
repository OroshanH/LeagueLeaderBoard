package com.example.LeagueLeaderboard;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/brukere")
public class BrukerManagerController {

    @GetMapping
    public List<Bruker> getBrukere() {
        return BrukerManager.createBrukere();
    }
}
