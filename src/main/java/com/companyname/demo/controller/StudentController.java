package com.companyname.demo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
//----------------------Delete Mapping------------------------------------
@DeleteMapping("/student/{id}")
public void deleteStudent(@PathVariable(value="id")Long studentId) {
	 studentRepository.deleteById(studentId);
}
//@PutMapping("/student/{id}")
//public Optional<StudentEntity> UpdateStudent(@Valid @RequestBody StudentEntity student,@PathVariable(value="id")Long studentId) {
//   return studentRepository.findById(studentId)
//	   .map(student_entity->{
//	   student_entity.setName(student.getName());
//	   student_entity.setEmail(student.getEmail());
//	   student_entity.setId((student.getId());
//	return studentRepository.save(student);
//	)}.orElseGet(()->){
//			   )};
//	   
//   
//		   
//}

//@PutMapping("/student/{id}")
//public StudentEntity(@RequestBody Employee newEmployee, @PathVariable Long id) {
//
//	return repository.findById(id)
//		.map(employee -> {
//			employee.setName(newEmployee.getName());
//			employee.setRole(newEmployee.getRole());
//			return repository.save(employee);
//		})
//		.orElseGet(() -> {
//			newEmployee.setId(id);
//			return repository.save(newEmployee);
//		});
//}
@PutMapping("/student/{id}")
public ResponseEntity<Object> updateStudent1(@RequestBody StudentEntity student,@PathVariable(value="id") Long StudentId) {
    Optional<StudentEntity> student1= studentRepository.findById(StudentId);
    if (!student1.isPresent()) {
        return ResponseEntity.badRequest().build();
    }
    student.setId(StudentId);
    StudentEntity studentUpdated =studentRepository.save(student);
    return ResponseEntity.ok().body(studentUpdated);
}
	}
	



