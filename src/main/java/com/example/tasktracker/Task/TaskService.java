package com.example.tasktracker.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTask(Long id) {
        boolean exists = taskRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("A task with ID " + id + " does not exist.");
        }
        return taskRepository.findById(id);
    }

    @Transactional
    public void updateTask(Task task) {
        boolean exists = taskRepository.existsById(task.getId());
        if (!exists) {
            throw new IllegalStateException("A task with ID " + task.getId() + " does not exist.");
        }
        Task existingTask = taskRepository.getById(task.getId());
        if (!Objects.equals(existingTask.getText(), task.getText())) {
            existingTask.setText(task.getText());
        }
        if (!Objects.equals(existingTask.getDay(), task.getDay())) {
            existingTask.setDay(task.getDay());
        }
        if (!Objects.equals(existingTask.getReminder(), task.getReminder())) {
            existingTask.setReminder(task.getReminder());
        }
        taskRepository.save(existingTask);
    }
}
