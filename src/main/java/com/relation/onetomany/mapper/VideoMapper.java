package com.relation.onetomany.mapper;

import java.util.stream.Collectors;

import com.relation.onetomany.dto.VideoRequestDTO;
import com.relation.onetomany.dto.VideoResponseDTO;
import com.relation.onetomany.entity.Videos;

public class VideoMapper {
	public static Videos toEntity(VideoRequestDTO dto) {
        Videos video = new Videos();
        video.setTitle(dto.getTitle());
        video.setDescription(dto.getDescription());
        video.setUrl(dto.getUrl());
        return video;
    }

    public static VideoResponseDTO toDTO(Videos video) {
        VideoResponseDTO dto = new VideoResponseDTO();
        dto.setId(video.getId());
        dto.setTitle(video.getTitle());
        dto.setDescription(video.getDescription());
        dto.setUrl(video.getUrl());

        if (video.getComments() != null) {
            dto.setComments(
                video.getComments()
                     .stream()
                     .map(CommentMapper::toDTO)
                     .collect(Collectors.toList())
            );
        }

        return dto;
    }
}
