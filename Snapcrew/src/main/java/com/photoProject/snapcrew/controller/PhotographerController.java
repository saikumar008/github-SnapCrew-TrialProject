package com.photoProject.snapcrew.controller;

import com.photoProject.snapcrew.dto.PhotographerDto;
import com.photoProject.snapcrew.service.PhotographyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/photographers")
public class PhotographerController {

    @Autowired
    private PhotographyService photographerService;

    @GetMapping("/getAllPhotographers")
    public ResponseEntity<Page<PhotographerDto>> getAllPhotographers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<PhotographerDto> photographerPage = photographerService.getAllPhotographers(page, size);
        return ResponseEntity.ok(photographerPage);
    }

    @PostMapping("/createPhotographer")
    public PhotographerDto createPhotographer(@RequestBody PhotographerDto photographerDTO) {
        return photographerService.createPhotographer(photographerDTO);
    }

    @GetMapping("/photographerById/{id}")
    public PhotographerDto getPhotographerById(@PathVariable UUID id) {
        return photographerService.getPhotographerById(id);
    }

    @DeleteMapping("/deletePhotographer/{id}")
    public void deletePhotographer(@PathVariable UUID id) {
        photographerService.deletePhotographer(id);
    }

    @PutMapping("/updatePhotographer/{id}")
    public ResponseEntity<PhotographerDto> updatePhotographer(
            @PathVariable UUID id, @RequestBody PhotographerDto photographerDto) {
        PhotographerDto updatedPhotographer = photographerService.updatePhotographer(id, photographerDto);
        return ResponseEntity.ok(updatedPhotographer);
    }

//    GET /api/photographers/search?keyword=john
    @GetMapping("/photographer/search")
    public List<PhotographerDto> searchPhotographers(@RequestParam String keyword) {
        return photographerService.searchPhotographers(keyword);
    }
}