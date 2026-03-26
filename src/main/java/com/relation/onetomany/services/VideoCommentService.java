package com.relation.onetomany.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relation.onetomany.dto.CommentRequestDTO;
import com.relation.onetomany.dto.CommentResponseDTO;
import com.relation.onetomany.dto.VideoResponseDTO;
import com.relation.onetomany.entity.Comments;
import com.relation.onetomany.entity.Videos;
import com.relation.onetomany.mapper.CommentMapper;
import com.relation.onetomany.mapper.VideoMapper;
import com.relation.onetomany.repository.CommentsRepository;
import com.relation.onetomany.repository.VideosRepository;

@Service
public class VideoCommentService implements VideoCommentInterface{
	@Autowired
    private VideosRepository videoRepo;

    @Autowired
    private CommentsRepository commentRepo;

    @Override
    public CommentResponseDTO addCommentToVideo(Long videoId, CommentRequestDTO dto) {

        Videos video = videoRepo.findById(videoId)
                .orElseThrow(() -> new RuntimeException("Video not found"));

        Comments comment = CommentMapper.toEntity(dto);
        comment.setVideo(video);

        return CommentMapper.toDTO(commentRepo.save(comment));
    }

    @Override
    public VideoResponseDTO getVideoWithComments(Long videoId) {

        Videos video = videoRepo.findById(videoId)
                .orElseThrow(() -> new RuntimeException("Video not found"));

        return VideoMapper.toDTO(video);
    }

    @Override
    public void deleteCommentFromVideo(Long videoId, Long commentId) {

        Comments comment = commentRepo.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));

        if (!comment.getVideo().getId().equals(videoId)) {
            throw new RuntimeException("Comment does not belong to this video");
        }

        commentRepo.delete(comment);
    }
    
    @Override
    public CommentResponseDTO updateCommentOfVideo(Long videoId, Long commentId, CommentRequestDTO dto) {

        // 1. Get Video
        Videos video = videoRepo.findById(videoId)
                .orElseThrow(() -> new RuntimeException("Video not found"));

        // 2. Get Comment
        Comments comment = commentRepo.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));

        // 3. Validate relationship
        if (!comment.getVideo().getId().equals(video.getId())) {
            throw new RuntimeException("Comment does not belong to this video");
        }

        // 4. Update fields
        comment.setText(dto.getText());
        comment.setUserName(dto.getUserName());

        // 5. Save
        return CommentMapper.toDTO(commentRepo.save(comment));
    }
}
