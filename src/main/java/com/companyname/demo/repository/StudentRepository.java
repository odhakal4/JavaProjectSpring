package com.companyname.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.companyname.demo.entity.StudentEntity;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity,Long> {

	Object getNoteById(Integer id);

}
