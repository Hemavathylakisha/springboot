package com.relation.onetomany.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relation.onetomany.dto.StudentRequestDTO;
import com.relation.onetomany.dto.StudentResponseDTO;
import com.relation.onetomany.entity.Course;
import com.relation.onetomany.entity.Student;
import com.relation.onetomany.mapper.StudentMapper;
import com.relation.onetomany.repository.CourseRepository;
import com.relation.onetomany.repository.StudentRepository;

@Service
public class StudentService implements StudentInterface{

	 	@Autowired
	    private StudentRepository studentRepo;

	    @Autowired
	    private CourseRepository courseRepo;
	   
	   //create
	@Override
	public StudentResponseDTO create(StudentRequestDTO dto) {
		//fetch courses from DB
        List<Course> courses = courseRepo.findAllById(dto.getCourseIds());

        // mapper
        Student student = StudentMapper.toEntity(dto, courses);

        Student saved = studentRepo.save(student);

        return StudentMapper.toDto(saved);
	
	}
	// GET ALL
    public List<StudentResponseDTO> getAll() {
    	return studentRepo.findAll().stream()
    			.map(StudentMapper::toDto)
    			.collect(Collectors.toList());
    }
 // GET BY ID
    public StudentResponseDTO getById(int id) {

        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return StudentMapper.toDto(student);
    }

    // UPDATE
    public StudentResponseDTO update(int id, StudentRequestDTO dto) {

        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setName(dto.getName());
        student.setCity(dto.getCity());

        // update courses
        List<Course> courses = courseRepo.findAllById(dto.getCourseIds());
        student.setCourse(courses);

        return StudentMapper.toDto(studentRepo.save(student));
    }

    // DELETE
    public void delete(int id) {
        studentRepo.deleteById(id);
    }
}
