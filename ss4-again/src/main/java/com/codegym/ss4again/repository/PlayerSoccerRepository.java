package com.codegym.ss4again.repository;

import com.codegym.ss4again.model.PlayerSoccer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PlayerSoccerRepository implements IPlayerSoccerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PlayerSoccer> getAll() {
        TypedQuery<PlayerSoccer> query=entityManager.createQuery("from PlayerSoccer ",PlayerSoccer.class);
        return query.getResultList();
    }

    @Override
    public PlayerSoccer findById(int id) {
        PlayerSoccer playerSoccer=entityManager.find(PlayerSoccer.class,id);
        return playerSoccer;
    }
    @Transactional
    @Override
    public void remove(PlayerSoccer playerSoccer) {
        PlayerSoccer playerSoccer1=findById(playerSoccer.getId());
        entityManager.remove(playerSoccer1);
    }
    @Transactional
    @Override
    public boolean update(PlayerSoccer playerSoccer, int id) {
        PlayerSoccer playerSoccer1=findById(id);
        if (playerSoccer1!=null){
            playerSoccer1.setCode(playerSoccer.getCode());
            playerSoccer1.setName(playerSoccer.getName());
            playerSoccer1.setBirth(playerSoccer.getBirth());
            playerSoccer1.setExperience(playerSoccer.getExperience());
            playerSoccer1.setPosition(playerSoccer.getPosition());
            playerSoccer1.setImage(playerSoccer.getImage());
            entityManager.merge(playerSoccer1);
            return true;
        }
        return false;
    }
    @Transactional
    @Override
    public void save(PlayerSoccer playerSoccer) {
        entityManager.persist(playerSoccer);
    }
}
