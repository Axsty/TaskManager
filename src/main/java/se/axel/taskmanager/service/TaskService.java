package se.axel.taskmanager.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.axel.taskmanager.enums.TaskStatus;
import se.axel.taskmanager.exceptions.TaskNotFoundException;
import se.axel.taskmanager.model.Task;
import se.axel.taskmanager.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public Task createTask(String title) {
        Task task = new Task(title);
        return repo.save(task);
    }

    @Transactional(readOnly = true)
    public Task getTaskById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    @Transactional(readOnly = true)
    public List<Task> getAllTasks() {
        return repo.findAll();
    }

    @Transactional
    public Task updateTask(Long id, TaskStatus newStatus) {
        Task task = repo.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        task.setStatus(newStatus);
        return repo.save(task);
    }

    @Transactional
    public void deleteTask(Long id) {
        if (!repo.existsById(id)) {
            throw new TaskNotFoundException(id);
        }
        repo.deleteById(id);
    }
}
