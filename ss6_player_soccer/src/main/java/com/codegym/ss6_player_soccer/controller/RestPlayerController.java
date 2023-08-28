package com.codegym.ss6_player_soccer.controller;


import com.codegym.ss6_player_soccer.dto.PlayerSoccerDto;
import com.codegym.ss6_player_soccer.model.PlayerSoccer;
import com.codegym.ss6_player_soccer.service.play_soccer.IPlayerSoccerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestPlayerController {
    @Autowired
    private IPlayerSoccerService playerSoccerService;
    @GetMapping("/list")
    public ResponseEntity<List<PlayerSoccer>> getAll(){
        List<PlayerSoccer> soccerList=playerSoccerService.getAllPlayer();
        if (soccerList.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(soccerList,HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<PlayerSoccer> findById(@PathVariable int id){
        PlayerSoccer playerSoccer=playerSoccerService.findById(id);
        if (playerSoccer==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(playerSoccer,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PlayerSoccerDto playerSoccerDto){
        PlayerSoccer playerSoccer=new PlayerSoccer();
        BeanUtils.copyProperties(playerSoccerDto,playerSoccer);
        playerSoccerService.save(playerSoccer);
        return new ResponseEntity<>("create success",HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id,@RequestBody PlayerSoccerDto playerSoccerDto){
        PlayerSoccer playerSoccer=playerSoccerService.findById(id);
        if (playerSoccer==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BeanUtils.copyProperties(playerSoccerDto,playerSoccer);
    playerSoccerService.save(playerSoccer);
    return new ResponseEntity<>("update success",HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public  ResponseEntity<?> delete(@PathVariable int id,@RequestBody PlayerSoccerDto playerSoccerDto){
        PlayerSoccer playerSoccer=playerSoccerService.findById(id);
        if (playerSoccer==null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        playerSoccerService.remove(id);
        return new ResponseEntity<>("delete success",HttpStatus.OK);
    }
}
