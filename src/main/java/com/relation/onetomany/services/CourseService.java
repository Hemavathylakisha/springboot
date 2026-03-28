package com.relation.onetomany.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relation.onetomany.dto.CourseRequestDTO;
import com.relation.onetomany.dto.CourseResponseDTO;
import com.relation.onetomany.entity.Course;
import com.relation.onetomany.mapper.CourseMapper;
import com.relation.onetomany.repository.CourseRepository;

@Service
public class CourseService implements CourseInterface{
	@Autowired
    private CourseRepository courseRepo;

    // CREATE
    public CourseResponseDTO create(CourseRequestDTO dto) {

        Course course = CourseMapper.toEntity(dto);

        Course saved = courseRepo.save(course);

        return CourseMapper.toDto(saved);
    }

    // GET ALL
    public List<CourseResponseDTO> getAll() {

        return courseRepo.findAll()
                .stream()
                .map(CourseMapper::toDto)
                .collect(Collectors.toList());
    }

    // GET BY ID
    public CourseResponseDTO getById(int id) {

        Course course = courseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        return CourseMapper.toDto(course);
    }

    // UPDATE
    public CourseResponseDTO update(int id, CourseRequestDTO dto) {

        Course course = courseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        course.setName(dto.getName());

        return CourseMapper.toDto(courseRepo.save(course));
    }

    // DELETE
    public void delete(int id) {
        courseRepo.deleteById(id);
    }

}
