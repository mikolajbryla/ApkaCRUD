package com.example.filmy.manager;

import com.example.filmy.dao.VideoCassetteRepo;
import com.example.filmy.dao.entities.VideoCassette;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class VideoCassetteManager {
    private final VideoCassetteRepo videoCassetteRepo;

    @Autowired
    public VideoCassetteManager(VideoCassetteRepo videoCassetteRepo) {
        this.videoCassetteRepo = videoCassetteRepo;
    }

    public Optional<VideoCassette> getVideoCassetteById(Long id) {
        return videoCassetteRepo.findById(id);
    }

    public Iterable<VideoCassette> findAll() {
        return videoCassetteRepo.findAll();
    }

    public VideoCassette save(VideoCassette videoCassette) {
        return videoCassetteRepo.save(videoCassette);
    }

    public void deleteById(Long id) {
        videoCassetteRepo.deleteById(id);
    }
    @EventListener(ApplicationReadyEvent.class)
    public void fillDb(){
        save(new VideoCassette(1L, "The Shawshank Redemption", LocalDate.of(1994, 9, 14)));
        save(new VideoCassette(2L, "The Godfather", LocalDate.of(1972, 3, 24)));
        save(new VideoCassette(3L, "The Dark Knight", LocalDate.of(2008, 7, 14)));

    }
}
