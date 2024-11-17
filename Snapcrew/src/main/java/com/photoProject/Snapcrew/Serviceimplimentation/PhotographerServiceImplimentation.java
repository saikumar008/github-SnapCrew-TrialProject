package com.photoProject.Snapcrew.Serviceimplimentation;

import com.photoProject.Snapcrew.Dto.PhotographerDto;
import com.photoProject.Snapcrew.Entity.Photographer;
import com.photoProject.Snapcrew.Repository.PhotographerRepository;
import com.photoProject.Snapcrew.Service.PhotographyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PhotographerServiceImplimentation implements PhotographyService{


    @Autowired
    private PhotographerRepository photographerRepository;

    @Autowired
    private ModelMapper modelMapper;



    private PhotographerDto convertToDto(Photographer photographer) {
        return modelMapper.map(photographer, PhotographerDto.class);
    }

    // Convert PhotographerDTO to Photographer entity
    private Photographer convertToEntity(PhotographerDto photographerDTO) {
        return modelMapper.map(photographerDTO, Photographer.class);
    }

    public Page<PhotographerDto> getAllPhotographers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Photographer> photographerPage = photographerRepository.findAll(pageable);

        // Convert Page<Photographer> to Page<PhotographerDto>
        return photographerPage.map(this::convertToDto);
    }

    @Override
    public PhotographerDto updatePhotographer(UUID id, PhotographerDto photographerDto) {
        Optional<Photographer> existingPhotographerOpt = photographerRepository.findById(id);

        if (existingPhotographerOpt.isPresent()) {
            Photographer existingPhotographer = existingPhotographerOpt.get();

            // Map updated fields from DTO to the entity using ModelMapper
            modelMapper.map(photographerDto, existingPhotographer);

            // Save updated entity
            Photographer updatedPhotographer = photographerRepository.save(existingPhotographer);

            // Return the updated DTO
            return convertToDto(updatedPhotographer);
        } else {
            throw new RuntimeException("Photographer with ID: " + id + " not found");
        }
    }

    public List<PhotographerDto> searchPhotographers(String keyword) {
        List<Photographer> photographers = photographerRepository.searchByKeyword(keyword);
        return photographers.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }


    public PhotographerDto createPhotographer(PhotographerDto photographerDTO) {
        Photographer photographer = convertToEntity(photographerDTO);
        Photographer savedPhotographer = photographerRepository.save(photographer);
        return convertToDto(savedPhotographer);
    }

    public PhotographerDto getPhotographerById(UUID id) {
        Photographer photographer = photographerRepository.findById(id).orElse(null);
        return photographer != null ? convertToDto(photographer) : null;
    }

    public void deletePhotographer(UUID id) {
        photographerRepository.deleteById(id);
    }
}
