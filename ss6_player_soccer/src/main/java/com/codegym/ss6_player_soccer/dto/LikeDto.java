package com.codegym.ss6_player_soccer.dto;

import java.util.HashMap;
import java.util.Map;

public class LikeDto {
    Map<PlayerSoccerDto,Integer> likeMap=new HashMap<>();

    public LikeDto() {
    }

    public Map<PlayerSoccerDto, Integer> getLikeMap() {
        return likeMap;
    }

    public void setLikeMap(Map<PlayerSoccerDto, Integer> likeMap) {
        this.likeMap = likeMap;
    }
    public void addPlayerLike(PlayerSoccerDto playerSoccerDto){
        if (likeMap.containsKey(playerSoccerDto)){
            Integer currentValue =likeMap.get(playerSoccerDto);
            likeMap.replace(playerSoccerDto,currentValue+1);
        }else {
            likeMap.put(playerSoccerDto,1);
        }
    }
}
