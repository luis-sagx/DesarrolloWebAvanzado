package com.prueba.grades.services;

import com.prueba.grades.models.entities.Grade;
import com.prueba.grades.repositories.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {
    
    @Autowired
    private GradeRepository gradeRepository;
    
    public List<Grade> findAll() {
        return gradeRepository.findAll();
    }
    
    public Optional<Grade> findById(Long id) {
        return gradeRepository.findById(id);
    }
    
    public List<Grade> findByStudentId(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }
    
    public List<Grade> findByCourseId(Long courseId) {
        return gradeRepository.findByCourseId(courseId);
    }
    
    public Optional<Grade> findByStudentIdAndCourseId(Long studentId, Long courseId) {
        return gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
    }
    
    public Grade save(Grade grade) {
        // Verificar si ya existe una nota para este estudiante en este curso
        if (gradeRepository.existsByStudentIdAndCourseId(grade.getStudentId(), grade.getCourseId())) {
            throw new RuntimeException("Ya existe una nota para el estudiante " + grade.getStudentId() + 
                                     " en el curso " + grade.getCourseId());
        }
        return gradeRepository.save(grade);
    }
    
    public Grade update(Long id, Grade gradeDetails) {
        Grade grade = gradeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grade not found with id: " + id));
        
        // Verificar si la actualización crearía un duplicado
        if (!grade.getStudentId().equals(gradeDetails.getStudentId()) || 
            !grade.getCourseId().equals(gradeDetails.getCourseId())) {
            if (gradeRepository.existsByStudentIdAndCourseId(gradeDetails.getStudentId(), gradeDetails.getCourseId())) {
                throw new RuntimeException("Ya existe una nota para el estudiante " + gradeDetails.getStudentId() + 
                                         " en el curso " + gradeDetails.getCourseId());
            }
        }
        
        grade.setStudentId(gradeDetails.getStudentId());
        grade.setCourseId(gradeDetails.getCourseId());
        grade.setNota(gradeDetails.getNota());
        
        return gradeRepository.save(grade);
    }
    
    public void deleteById(Long id) {
        if (!gradeRepository.existsById(id)) {
            throw new RuntimeException("Grade not found with id: " + id);
        }
        gradeRepository.deleteById(id);
    }
}
