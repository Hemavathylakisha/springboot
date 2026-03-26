package com.relation.onetomany.services;

import com.relation.onetomany.dto.CommentRequestDTO;
import com.relation.onetomany.dto.CommentResponseDTO;
import com.relation.onetomany.dto.VideoResponseDTO;

public interface VideoCommentInterface {
	
	CommentResponseDTO addCommentToVideo(Long videoId, CommentRequestDTO dto);

    VideoResponseDTO getVideoWithComments(Long videoId);

    void deleteCommentFromVideo(Long videoId, Long commentId);
    
    CommentResponseDTO updateCommentOfVideo(Long videoId, Long commentId, CommentRequestDTO dto);
}
