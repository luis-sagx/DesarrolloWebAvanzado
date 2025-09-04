package com.prueba.student.services;

import com.prueba.student.models.entities.Student;
import com.prueba.student.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;
    
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
    
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }
    
    public Optional<Student> findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }
    
    public Student save(Student student) {
        // Verificar si el email ya existe
        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new RuntimeException("Ya existe un estudiante con el email: " + student.getEmail());
        }
        return studentRepository.save(student);
    }
    
    public Student update(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        
        // Verificar si el nuevo email ya existe en otro estudiante
        if (!student.getEmail().equals(studentDetails.getEmail()) && 
            studentRepository.existsByEmail(studentDetails.getEmail())) {
            throw new RuntimeException("Ya existe un estudiante con el email: " + studentDetails.getEmail());
        }
        
        student.setNombre(studentDetails.getNombre());
        student.setApellido(studentDetails.getApellido());
        student.setEmail(studentDetails.getEmail());
        
        return studentRepository.save(student);
    }
    
    public void deleteById(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }
}
