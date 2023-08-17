package com.codegym.ss4again.repository;

import com.codegym.ss4again.model.PlayerSoccer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayerSoccerRepository implements IPlayerSoccerRepository {
    private static List<PlayerSoccer> soccerList = new ArrayList<>();

    static {
        soccerList.add(new PlayerSoccer(1, "ps-001", "Chanh TV", "01-01-1987", "2 year", "trung ve", "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSYWhI7TCv3XhwY1rcvjB7B_sFrAYUvLKQMgPJIaGO-qlIx2pSa"));
        soccerList.add(new PlayerSoccer(2, "ps-002", "Chanh TV", "01-01-1987", "2 year", "trung ve", "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSYWhI7TCv3XhwY1rcvjB7B_sFrAYUvLKQMgPJIaGO-qlIx2pSa"));
        soccerList.add(new PlayerSoccer(3, "ps-003", "Chanh TV", "01-01-1987", "2 year", "trung ve", "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSYWhI7TCv3XhwY1rcvjB7B_sFrAYUvLKQMgPJIaGO-qlIx2pSa"));
        soccerList.add(new PlayerSoccer(4, "ps-004", "Chanh TV", "01-01-1987", "2 year", "trung ve", "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSYWhI7TCv3XhwY1rcvjB7B_sFrAYUvLKQMgPJIaGO-qlIx2pSa"));
        soccerList.add(new PlayerSoccer(5, "ps-005", "Chanh TV", "01-01-1987", "2 year", "trung ve", "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSYWhI7TCv3XhwY1rcvjB7B_sFrAYUvLKQMgPJIaGO-qlIx2pSa"));
    }

    @Override
    public List<PlayerSoccer> getAll() {
        return soccerList;
    }

    @Override
    public PlayerSoccer findById(int id) {
        for (PlayerSoccer playerSoccer : soccerList) {
            if (playerSoccer.getId() == id) {
                return playerSoccer;
            }
        }
        return null;
    }

    @Override
    public void remove(PlayerSoccer playerSoccer) {
        soccerList.remove(playerSoccer);
    }

    @Override
    public boolean update(PlayerSoccer playerSoccer, int id) {
        for (int i = 0; i < soccerList.size(); i++) {
            if (soccerList.get(i).getId()==id){
                soccerList.set(i,playerSoccer);
                return true;
            }
        }
        return false;
    }

    @Override
    public void save(PlayerSoccer playerSoccer) {
        soccerList.add(playerSoccer);
    }
}
