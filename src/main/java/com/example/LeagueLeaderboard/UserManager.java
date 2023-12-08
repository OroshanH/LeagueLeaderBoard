package com.example.LeagueLeaderboard;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    public static List<User> createUsers() {
        List<User> users = new ArrayList<>();
        String[] summonerKeys = {"TELZM7qrTB8awzxtHfXu8p8goCFhHeDRTR-IT_77yxLgz5E", "1dKoepWaQD24YOrTzGJBLyA6jcPXZykKbwwp-jEn7VNqJ7g", "rwRsKG_oYqa46cxzY_iEduqEHTpcuLWKkxk2UNSxkGZr-M43", "o8ZKeiXIP9--fMl5XhuKUcL_HlIJwSMiAWyD3pD9FoCagLM", "JQHrTrMz52CSWDCXBqJcPjfEnG39trDmosJBi2SbxzOY2HY", "zvFluL5NMOtCIQ_e5OAdjntnMlc4AO2gFmaR0z8oWzmEWFw", "mMpGbfiC8L4GB2GaP4jkP7r8s8OYsMMYtRjY9EPP1Vif8w8", "i1bysGNy6oTa34mt2yJpLOq1nRmQmgh997VNbGJ3qDtwYRE", "BohVl15AUB2RMv8qXqLl9nqcgZgD825uUdI9r3ySG_lDYFkkEbtzvnIiqg", "Wdid_3BO3DYbJeEI36Xh1r4o5zc9j-Tauj9kGDTUQCzGA_P3","uHrv44LJ-fIYPh-p0hyh-16JS_cHH3a8WDjVZ5r2qZebMAQ"};
        String[] summonerNames = {"Oro", "Ost", "Sam", "Len", "Larris", "Rasmus", "Ole", "Leon","Birk","Ibra","Peter"};
        String[] profilePictureUrls = {
                "/bilder/oro.png",
                "/bilder/ost.png",
                "/bilder/sam.png",
                "/bilder/len.png",
                "/bilder/larris.png",
                "/bilder/rasmus.jpg",
                "/bilder/ole.jpg",
                "/bilder/leon.png",
                "/bilder/birk.jpg",
                "/bilder/ibra.png",
                "/bilder/peter.png"
        };

        String[] rolePictureUrls = {
                "/bilder/mid.png",
                "/bilder/adc.png",
                "/bilder/mid.png",
                "/bilder/top.png",
                "/bilder/jungle.png",
                "/bilder/top.png",
                "/bilder/jungle.png",
                "/bilder/adc.png",
                "/bilder/jungle.png",
                "/bilder/top.png",
                "/bilder/mid.png"
        };

        for (int i = 0; i < 11; i++) {
            User user = new User();
            user.setSummonerKey(summonerKeys[i]);
            user.setSummonerName(summonerNames[i]);
            user.setProfilePictureUrl(profilePictureUrls[i]);
            user.setRolePictureUrl(rolePictureUrls[i]);

            users.add(user);
        }
        return users;
    }
    }




