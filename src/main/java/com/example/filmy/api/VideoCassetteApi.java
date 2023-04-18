package com.example.filmy.api;

import com.example.filmy.dao.entities.VideoCassette;
import com.example.filmy.manager.VideoCassetteManager;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cassettes")
public class VideoCassetteApi {
    private final VideoCassetteManager videoCassetteManager;

    public VideoCassetteApi(VideoCassetteManager videoCassetteManager) {
        this.videoCassetteManager = videoCassetteManager;
    }

    @GetMapping("/all")
    public Iterable<VideoCassette> getVideoCassettes() {
        return videoCassetteManager.findAll();
    }

    @GetMapping
    public Optional<VideoCassette> getCassetteById(@RequestParam int id) {
        return videoCassetteManager.getVideoCassetteById((long) id);
    }

    @PostMapping
    public VideoCassette addVideo(@RequestBody VideoCassette videoCassette) {
        return videoCassetteManager.save(videoCassette);
    }

    @PutMapping
    public VideoCassette updateVideo(@RequestParam int id, @RequestBody VideoCassette videoCassette) {
        return videoCassetteManager.save(videoCassette);
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam int id) {
        videoCassetteManager.deleteById((long)id);
    }
}
