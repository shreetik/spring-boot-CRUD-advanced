package com.shreetik.CRUD.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shreetik.CRUD.entity.Student;
import com.shreetik.CRUD.service.StudentService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/api/student") 
public class StudentController {

    private StudentService studentservice;

    StudentController(StudentService studentService){
        this.studentservice = studentService;
    }

    @GetMapping("/greet")
    public String greet(){
        return "Hello World";
    }

    @PostMapping("/")
    public ResponseEntity<Student> create(@RequestBody Student student){
       Student studentres = this.studentservice.create(student);

        return ResponseEntity.status(HttpStatus.CREATED).body(studentres);
    }

    @GetMapping("/")
    public ResponseEntity<List<Student>> getStudent(){
        List<Student> studentres = this.studentservice.get();

        return ResponseEntity.status(HttpStatus.OK).body(studentres);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable  Long id){
        Student student =this.studentservice.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable Long id, @RequestBody Student student){
           Student studentres = this.studentservice.update(id, student);

           return ResponseEntity.status(HttpStatus.OK).body(studentres);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id){
          String msg =  this.studentservice.delete(id);

            return ResponseEntity.status(HttpStatus.OK).body(msg);
    }

}
