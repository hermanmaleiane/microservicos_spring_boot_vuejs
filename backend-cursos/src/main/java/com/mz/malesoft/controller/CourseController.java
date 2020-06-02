package com.mz.malesoft.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.mz.malesoft.model.Course;
import com.mz.malesoft.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins = { "http://localhost:4000", "http://localhost:4200", "http://localhost:8081" })
@RestController
public class CourseController {

	@Autowired
	private CursoService cursoService;

	@GetMapping("/service/courses")
	public List<Course> getAllCourses() {
        List<Course> cursos = cursoService.findAll();

        return cursos;
	}
	@GetMapping("/instructors/{username}/courses/{id}")
	public Optional<Course> getCourse(@PathVariable String username, @PathVariable long id) {
		return cursoService.findById(id);
	}

	@DeleteMapping("/instructors/{username}/courses/{id}")
	public ResponseEntity<Void> deleteCourse(@PathVariable String username, @RequestBody Course course) {
		cursoService.delete(course);
		if (course != null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/instructors/{username}/courses/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable String username, @PathVariable long id,
											   @RequestBody Course course) {

		Course courseUpdated = cursoService.save(course);

		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}

	@PostMapping("/instructors/{username}/courses")
	public ResponseEntity<Void> createCourse(@PathVariable String username, @RequestBody Course course) {

		Course createdCourse = cursoService.save(course);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdCourse.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

}