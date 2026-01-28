package se.axel.taskmanager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import se.axel.taskmanager.enums.TaskStatus;
import se.axel.taskmanager.model.Task;
import se.axel.taskmanager.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    public record createTaskRequest(String title) {
    }

    public record updateTaskRequest(TaskStatus status) {
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody createTaskRequest createTaskRequest) {
        return service.createTask(createTaskRequest.title);
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return service.getTaskById(id);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return service.getAllTasks();
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody updateTaskRequest updateTaskRequest) {
        return service.updateTask(id, updateTaskRequest.status);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
    }
}
