package se.axel.taskmanager.controller;

import org.springframework.web.bind.annotation.RestController;
import se.axel.taskmanager.service.TaskService;

@RestController
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }
}
