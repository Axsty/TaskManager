package se.axel.taskmanager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import se.axel.taskmanager.enums.TaskStatus;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @Column(nullable = false)
    private String taskName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskStatus status;

    public Task(String taskName, TaskStatus status) {
        this.taskName = taskName;
        this.status = status != null ? status : TaskStatus.TODO;
    }

    public Task(String taskName) {
        this.taskName = taskName;
    }
}
