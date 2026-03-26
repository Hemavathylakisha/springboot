package com.relation.onetomany.dto;

import java.util.List;

public class VideoResponseDTO {
    private Long id;
    private String title;
    private String description;
    private String url;
    private List<CommentResponseDTO> comments;
    
	public VideoResponseDTO(Long id, String title, String description, String url, List<CommentResponseDTO> comments) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.url = url;
		this.comments = comments;
	}

	public VideoResponseDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<CommentResponseDTO> getComments() {
		return comments;
	}

	public void setComments(List<CommentResponseDTO> comments) {
		this.comments = comments;
	}
    
}
