package com.example.validatesong.service;

import com.example.validatesong.model.Song;
import com.example.validatesong.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService{
    @Autowired
   private ISongRepository songRepository;
    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song findById(int id) {
        return songRepository.findById(id).orElse(null);
    }
}
