package com.shreetik.CRUD.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.shreetik.CRUD.entity.Student;
import com.shreetik.CRUD.repository.StudentRepository;

@Service 
public class StudentService {

    private StudentRepository studentRepository;

    StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student create(Student studentreq){
     Student studentres = this.studentRepository.save(studentreq);
     return studentres;
    }

    public List<Student> get(){
        return this.studentRepository.findAll();
    }

    public Student getById(Long id){
        return this.studentRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found!!"));
    }

    public Student update(Long id,Student studentreq){
        Student result = getById(id);
        
        result.setFirstName(studentreq.getFirstName());
        result.setAddress(studentreq.getAddress());
        result.setAge(studentreq.getAge());
        result.setRollNo(studentreq.getRollNo());
       


        return this.studentRepository.save(result);

    }

    public String delete(Long id){
        this.studentRepository.deleteById(id);
        return "Deleted successfully..";
    }
}
