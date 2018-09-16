package com.companyname.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.companyname.demo.entity.StudentEntity;
import com.companyname.demo.repository.StudentRepository;

@RestController
public class StudentController {
@Autowired
StudentRepository studentRepository;

@PostMapping("/student")
public StudentEntity createStudent(@Valid @RequestBody StudentEntity student) {
    return studentRepository.save(student);
}
//-------------------------------------First Get Mapping------------------
@GetMapping("/student/{id}")
public StudentEntity getStudentById(@PathVariable(value="id")Long studentId) {
	return studentRepository.findById(studentId).orElseThrow(null);
}

	}
	



