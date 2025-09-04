package com.prueba.grades.controllers;

import com.prueba.grades.models.entities.Grade;
import com.prueba.grades.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/grades")
@CrossOrigin(origins = "*")
public class GradeController {
    
    @Autowired
    private GradeService gradeService;
    
    @GetMapping
    public ResponseEntity<List<Grade>> getAllGrades() {
        List<Grade> grades = gradeService.findAll();
        return ResponseEntity.ok(grades);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Grade> getGradeById(@PathVariable Long id) {
        Optional<Grade> grade = gradeService.findById(id);
        return grade.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Grade>> getGradesByStudentId(@PathVariable Long studentId) {
        List<Grade> grades = gradeService.findByStudentId(studentId);
        return ResponseEntity.ok(grades);
    }
    
    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Grade>> getGradesByCourseId(@PathVariable Long courseId) {
        List<Grade> grades = gradeService.findByCourseId(courseId);
        return ResponseEntity.ok(grades);
    }
    
    @GetMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<Grade> getGradeByStudentAndCourse(@PathVariable Long studentId, 
                                                           @PathVariable Long courseId) {
        Optional<Grade> grade = gradeService.findByStudentIdAndCourseId(studentId, courseId);
        return grade.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<?> createGrade(@Valid @RequestBody Grade grade) {
        try {
            Grade savedGrade = gradeService.save(grade);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedGrade);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateGrade(@PathVariable Long id, 
                                        @Valid @RequestBody Grade gradeDetails) {
        try {
            Grade updatedGrade = gradeService.update(id, gradeDetails);
            return ResponseEntity.ok(updatedGrade);
        } catch (RuntimeException e) {
            if (e.getMessage().contains("not found")) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrade(@PathVariable Long id) {
        try {
            gradeService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
