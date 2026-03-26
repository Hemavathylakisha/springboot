package com.relation.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relation.onetomany.entity.Videos;

@Repository
public interface VideosRepository extends JpaRepository<Videos,Long> {

}
