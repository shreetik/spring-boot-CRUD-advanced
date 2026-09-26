package com.shreetik.CRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shreetik.CRUD.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
