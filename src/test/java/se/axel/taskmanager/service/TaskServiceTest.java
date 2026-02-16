package se.axel.taskmanager.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import se.axel.taskmanager.exceptions.TaskNotFoundException;
import se.axel.taskmanager.model.Task;
import se.axel.taskmanager.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static se.axel.taskmanager.enums.TaskStatus.DONE;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    TaskRepository repo;

    @InjectMocks
    TaskService service;

    @Test
    public void createTask() {
        String title = "Clean apartment";

        service.createTask(title);

        Mockito.verify(repo).save(Mockito.argThat(task ->
                task.getTaskName().equals(title)));
    }

    @Test
    public void getTaskById_found() {
        Long id = 1L;
        Task task = new Task("Cook dinner");

        Mockito.when(repo.findById(id)).thenReturn(Optional.of(task));

        Task result = service.getTaskById(id);

        assertEquals(task, result);
        Mockito.verify(repo).findById(id);
    }

    @Test
    public void getTaskById_notFound() {
        Long id = 1L;

        Mockito.when(repo.findById(id)).thenReturn(Optional.empty());

        assertThrows(TaskNotFoundException.class, () ->
                service.getTaskById(id));

        Mockito.verify(repo).findById(id);
    }

    @Test
    public void getAllTasks() {
        List<Task> taskList = List.of(
                new Task("Grocery shopping"),
                new Task("Pay bills")
        );

        Mockito.when(repo.findAll()).thenReturn(taskList);

        List<Task> result = service.getAllTasks();

        assertEquals(taskList, result);
        Mockito.verify(repo).findAll();
    }

    @Test
    public void updateTask() {
        Long id = 1L;
        Task task = new Task("Make dinner");

        Mockito.when(repo.findById(id)).thenReturn(Optional.of(task));

        service.updateTask(1L, DONE);

        assertEquals(DONE, task.getStatus());
        Mockito.verify(repo).findById(id);
        Mockito.verify(repo).save(task);
    }

    @Test
    public void deleteTask_found() {
        Long id = 1L;

        Mockito.when(repo.existsById(id)).thenReturn(true);

        service.deleteTask(id);

        Mockito.verify(repo).deleteById(id);
    }

    @Test
    public void deleteTask_notFound() {
        Long id = 1L;

        Mockito.when(repo.existsById(id)).thenReturn(false);

        assertThrows(TaskNotFoundException.class, () ->
                service.deleteTask(id));

        Mockito.verify(repo).existsById(id);
    }
}
