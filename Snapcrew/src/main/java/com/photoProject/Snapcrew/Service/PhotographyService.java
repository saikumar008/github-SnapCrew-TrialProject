package com.photoProject.Snapcrew.Service;

import com.photoProject.Snapcrew.Dto.PhotographerDto;
import com.photoProject.Snapcrew.Entity.Photographer;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface PhotographyService {

    public PhotographerDto createPhotographer(PhotographerDto photographerDto);

    public PhotographerDto getPhotographerById(UUID id);

    public void deletePhotographer(UUID id);

    public Page<PhotographerDto> getAllPhotographers(int page, int size);

    public PhotographerDto updatePhotographer(UUID id, PhotographerDto photographerDto);

    public List<PhotographerDto> searchPhotographers(String keyword);
}
