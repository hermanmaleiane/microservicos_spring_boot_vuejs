package com.mz.malesoft;

import com.mz.malesoft.model.Course;
import com.mz.malesoft.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCourseApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner setup(CourseRepository repository) {
		return (args) -> {
			repository.save(new Course("Herman", "Spring Boot and Vue Js"));
			repository.save(new Course("Gabriel", "Business Intelligence"));
			repository.save(new Course("Osvaldo", "Groovy and Grails"));
			repository.save(new Course("Evaristo", "Data Science"));
			repository.save(new Course("Inercio", "Vaadin"));
		};
	}*/

}
