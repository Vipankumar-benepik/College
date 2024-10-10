package com.college_mgmt.college.Controllers;

import com.college_mgmt.college.Entites.Student;
import com.college_mgmt.college.Repositories.GenericRepository;
import com.college_mgmt.college.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;
    
    StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    
    @GetMapping("/getdata")
    public ResponseEntity<List<Student>> getAll(){
        Student student = new Student();
        student.getName();
        List<Student> students = studentService.findAll();
        return ResponseEntity.ok(students);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> getById(@PathVariable Long id){
        Optional<Student> student = studentService.findById(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping("/setdata")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student createdStudent = studentService.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        studentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}


