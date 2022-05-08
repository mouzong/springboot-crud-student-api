package com.codegrill.andreas.student.configuration;

import com.codegrill.andreas.student.entity.Student;
import com.codegrill.andreas.student.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student andreas = new Student(
                    "Andreas",
                    "fryker@gmail.com",
                    LocalDate.of(2000, Month.APRIL, 13)

            );
            Student james = new Student(
                    "James",
                    "jimmy@gmail.com",
                    LocalDate.of(2001, Month.JANUARY, 21)
            );
            Student alex = new Student(
                    "ex",
                    "alex@gmail.com",
                    LocalDate.of(2005, Month.APRIL, 13)
            );

            repository.saveAll(List.of(andreas,james,alex));
        };
    }
}
