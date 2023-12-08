package com.example.LeagueLeaderboard;

public class Bruker {
    private String summonerKey;
    private String summonerName;
    private String rank;
    private int leaguePoints;
    private int wins;
    private int losses;
    private String profilePictureUrl;
    private String rolePictureUrl;


    public Bruker() {
    }

    public Bruker(String summonerKey, String summonerName, String rank, int leaguePoints, int wins, int losses, String profilePictureUrl, String rolePictureUrl) {
        this.summonerKey = summonerKey;
        this.summonerName = summonerName;
        this.rank = rank;
        this.leaguePoints = leaguePoints;
        this.wins = wins;
        this.losses = losses;
        this.profilePictureUrl = profilePictureUrl;
        this.rolePictureUrl = rolePictureUrl;
    }



    public String getSummonerKey() {
        return summonerKey;
    }

    public void setSummonerKey(String summonerKey) {
        this.summonerKey = summonerKey;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getLeaguePoints() {
        return leaguePoints;
    }

    public void setLeaguePoints(int leaguePoints) {
        this.leaguePoints = leaguePoints;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }
    public String getRolePictureUrl() {
        return rolePictureUrl;
    }

    public void setRolePictureUrl(String rolePictureUrl) {
        this.rolePictureUrl = rolePictureUrl;
    }
}
