package com.mz.malesoft.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mz.malesoft.model.Course;

public interface CursoService {
	Optional<Course> findById(long id);
	Course save(Course course);
	void delete(Course course);
	List<Course> findAll();

}