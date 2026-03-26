package com.relation.onetomany.services;

import java.util.List;

import com.relation.onetomany.dto.CommentRequestDTO;
import com.relation.onetomany.dto.CommentResponseDTO;

public interface CommentsInterface {
	//create
	CommentResponseDTO create(CommentRequestDTO dto);

	//getbyid
    CommentResponseDTO getById(Long id);

    //getalldata
    List<CommentResponseDTO> getAll();

    //update
    CommentResponseDTO update(Long id, CommentRequestDTO dto);

    //delete
    void delete(Long id);
}
