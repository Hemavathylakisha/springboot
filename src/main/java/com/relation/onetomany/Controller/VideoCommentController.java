package com.relation.onetomany.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relation.onetomany.dto.CommentRequestDTO;
import com.relation.onetomany.dto.CommentResponseDTO;
import com.relation.onetomany.dto.VideoRequestDTO;
import com.relation.onetomany.dto.VideoResponseDTO;
import com.relation.onetomany.services.CommentsService;
import com.relation.onetomany.services.VideoCommentService;
import com.relation.onetomany.services.VideosService;

@RestController
@RequestMapping("/api")
public class VideoCommentController {

	    @Autowired
	    private VideosService videoService;

	    @Autowired
	    private CommentsService commentService;

	    @Autowired
	    private VideoCommentService videoCommentService;

	    // VIDEO APIs
	    @PostMapping("/videos")
	    public VideoResponseDTO createVideo(@RequestBody VideoRequestDTO dto) {
	        return videoService.create(dto);
	    }

	    @GetMapping("/videos")
	    public List<VideoResponseDTO> getAllVideos() {
	        return videoService.getAll();
	    }

	    @GetMapping("/videos/{id}")
	    public VideoResponseDTO getVideo(@PathVariable Long id) {
	        return videoService.getById(id);
	    }

	    @PutMapping("/videos/{id}")
	    public VideoResponseDTO updateVideo(@PathVariable Long id,
	                                        @RequestBody VideoRequestDTO dto) {
	        return videoService.update(id, dto);
	    }

	    @DeleteMapping("/videos/{id}")
	    public String deleteVideo(@PathVariable Long id) {
	        videoService.delete(id);
	        return "Deleted video";
	    }

	    // COMMENT APIs
	    @PostMapping("/comments")
	    public CommentResponseDTO createComment(@RequestBody CommentRequestDTO dto) {
	        return commentService.create(dto);
	    }

	    @GetMapping("/comments")
	    public List<CommentResponseDTO> getAllComments() {
	        return commentService.getAll();
	    }

	    // COMBINED APIs
	    @PostMapping("/videos/{videoId}/comments")
	    public CommentResponseDTO addCommentToVideo(
	            @PathVariable Long videoId,
	            @RequestBody CommentRequestDTO dto) {

	        return videoCommentService.addCommentToVideo(videoId, dto);
	    }

	    @GetMapping("/videos/{videoId}/comments")
	    public VideoResponseDTO getVideoWithComments(@PathVariable Long videoId) {
	        return videoCommentService.getVideoWithComments(videoId);
	    }

	    @DeleteMapping("/videos/{videoId}/comments/{commentId}")
	    public String deleteCommentFromVideo(@PathVariable Long videoId,
	                                       @PathVariable Long commentId) {

	        videoCommentService.deleteCommentFromVideo(videoId, commentId);
	        return "Deleted comment from video";
	    }
	    
	    @PutMapping("/videos/{videoId}/comments/{commentId}")
	    public CommentResponseDTO updateCommentOfVideo(
	            @PathVariable Long videoId,
	            @PathVariable Long commentId,
	            @RequestBody CommentRequestDTO dto) {

	        return videoCommentService.updateCommentOfVideo(videoId, commentId, dto);
	    }
}
