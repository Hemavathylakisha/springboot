package com.relation.onetomany.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relation.onetomany.dto.VideoRequestDTO;
import com.relation.onetomany.dto.VideoResponseDTO;
import com.relation.onetomany.entity.Videos;
import com.relation.onetomany.mapper.VideoMapper;
import com.relation.onetomany.repository.VideosRepository;

@Service
public class VideosService implements VideosInterface{
	@Autowired
    private VideosRepository videoRepo;

    @Override
    public VideoResponseDTO create(VideoRequestDTO dto) {
        Videos video = VideoMapper.toEntity(dto);
        return VideoMapper.toDTO(videoRepo.save(video));
    }

    @Override
    public VideoResponseDTO getById(Long id) {
        Videos video = videoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Video not found"));
        return VideoMapper.toDTO(video);
    }

    @Override
    public List<VideoResponseDTO> getAll() {
        return videoRepo.findAll()
                .stream()
                .map(VideoMapper::toDTO)
                .toList();
    }

    @Override
    public VideoResponseDTO update(Long id, VideoRequestDTO dto) {
        Videos video = videoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Video not found"));

        video.setTitle(dto.getTitle());
        video.setDescription(dto.getDescription());
        video.setUrl(dto.getUrl());

        return VideoMapper.toDTO(videoRepo.save(video));
    }

    @Override
    public void delete(Long id) {
        videoRepo.deleteById(id);
    }
}
