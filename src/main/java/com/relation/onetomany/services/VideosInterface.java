package com.relation.onetomany.services;

import java.util.List;

import com.relation.onetomany.dto.CommentRequestDTO;
import com.relation.onetomany.dto.CommentResponseDTO;
import com.relation.onetomany.dto.VideoRequestDTO;
import com.relation.onetomany.dto.VideoResponseDTO;

public interface VideosInterface {
	
//create
VideoResponseDTO create(VideoRequestDTO dto);

//getbyid
VideoResponseDTO getById(Long id);

//alldata
List<VideoResponseDTO> getAll();

//update
VideoResponseDTO update(Long id, VideoRequestDTO dto);

//delete
void delete(Long id);
}
