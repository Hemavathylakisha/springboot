package com.relation.onetomany.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relation.onetomany.dto.CommentRequestDTO;
import com.relation.onetomany.dto.CommentResponseDTO;
import com.relation.onetomany.entity.Comments;
import com.relation.onetomany.mapper.CommentMapper;
import com.relation.onetomany.repository.CommentsRepository;

@Service
public class CommentsService implements CommentsInterface{
	@Autowired
    private CommentsRepository commentRepo;

    @Override
    public CommentResponseDTO create(CommentRequestDTO dto) {
        Comments comment = CommentMapper.toEntity(dto);
        return CommentMapper.toDTO(commentRepo.save(comment));
    }

    @Override
    public CommentResponseDTO getById(Long id) {
        Comments comment = commentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        return CommentMapper.toDTO(comment);
    }

    @Override
    public List<CommentResponseDTO> getAll() {
        return commentRepo.findAll()
                .stream()
                .map(CommentMapper::toDTO)
                .toList();
    }

    @Override
    public CommentResponseDTO update(Long id, CommentRequestDTO dto) {
        Comments comment = commentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));

        comment.setText(dto.getText());
        comment.setUserName(dto.getUserName());

        return CommentMapper.toDTO(commentRepo.save(comment));
    }

    @Override
    public void delete(Long id) {
        commentRepo.deleteById(id);
    }
}
