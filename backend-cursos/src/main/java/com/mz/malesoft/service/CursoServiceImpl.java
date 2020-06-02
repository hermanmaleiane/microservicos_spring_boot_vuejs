package com.mz.malesoft.service;

import com.mz.malesoft.model.Course;
import com.mz.malesoft.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {
    @Autowired
    private CourseRepository repository;

    @Override
    public Optional<Course> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public Course save(Course course) {
        return repository.save(course);    }

    @Override
    public void delete(Course course) {
         repository.delete(course);
    }

    @Override
    public List<Course> findAll() {
        return repository.findAll();
    }


}
