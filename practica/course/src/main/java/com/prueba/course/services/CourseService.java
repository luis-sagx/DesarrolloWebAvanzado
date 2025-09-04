package com.prueba.course.services;

import com.prueba.course.models.entities.Course;
import com.prueba.course.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    
    @Autowired
    private CourseRepository courseRepository;
    
    public List<Course> findAll() {
        return courseRepository.findAll();
    }
    
    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }
    
    public Course save(Course course) {
        return courseRepository.save(course);
    }
    
    public Course update(Long id, Course courseDetails) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
        
        course.setNombre(courseDetails.getNombre());
        course.setCreditos(courseDetails.getCreditos());
        
        return courseRepository.save(course);
    }
    
    public void deleteById(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new RuntimeException("Course not found with id: " + id);
        }
        courseRepository.deleteById(id);
    }
}
