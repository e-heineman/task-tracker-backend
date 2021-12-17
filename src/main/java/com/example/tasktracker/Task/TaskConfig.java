package com.example.tasktracker.Task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class TaskConfig {

    @Bean
    CommandLineRunner commandLineRunner(TaskRepository repository) {
        return args -> {
            Task first = new Task(
                    "Feed Murray",
                    LocalDate.of(2021, Month.DECEMBER, 18),
                    false
            );
            Task second = new Task(
                    "Take drugs",
                    LocalDate.of(2021, Month.DECEMBER, 18),
                    true
            );

            repository.saveAll(
                    List.of(first, second)
            );
        };
    }
}
