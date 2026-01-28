package se.axel.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.axel.taskmanager.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
