package se.axel.taskmanager.service;

import org.springframework.stereotype.Service;
import se.axel.taskmanager.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }
}
