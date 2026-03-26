package com.relation.onetomany.mapper;

import com.relation.onetomany.dto.CommentRequestDTO;
import com.relation.onetomany.dto.CommentResponseDTO;
import com.relation.onetomany.entity.Comments;

public class CommentMapper {
	 public static Comments toEntity(CommentRequestDTO dto) {
	        Comments comment = new Comments();
	        comment.setText(dto.getText());
	        comment.setUserName(dto.getUserName());
	        return comment;
	    }

	    public static CommentResponseDTO toDTO(Comments comment) {
	        CommentResponseDTO dto = new CommentResponseDTO();
	        dto.setId(comment.getId());
	        dto.setText(comment.getText());
	        dto.setUserName(comment.getUserName());
	        return dto;
	    }
}
