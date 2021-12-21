package com.example.tasktracker.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @CrossOrigin
    @GetMapping
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @CrossOrigin
    @GetMapping(path = "{taskId}")
    public Optional<Task> getTask(@PathVariable("taskId") Long id) {
        return taskService.getTask(id);
    }

    @CrossOrigin
    @PutMapping(path = "{taskId}")
    public void updateTask(@RequestBody Task task) {
        taskService.updateTask(task);
    }
}
