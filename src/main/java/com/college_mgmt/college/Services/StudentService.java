package com.college_mgmt.college.Services;

import com.college_mgmt.college.Entites.Student;
import com.college_mgmt.college.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Optional<Student> findById(Long id){
        return studentRepository.findById(id);
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student save(Student student){
        return studentRepository.save(student);
    }

    public void deleteById(Long id){
        studentRepository.deleteById(id);
    }

}
