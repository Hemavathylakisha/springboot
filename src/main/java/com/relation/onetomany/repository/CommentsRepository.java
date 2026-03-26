package com.relation.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relation.onetomany.entity.Comments;

@Repository
public interface CommentsRepository extends JpaRepository<Comments,Long> {

}
