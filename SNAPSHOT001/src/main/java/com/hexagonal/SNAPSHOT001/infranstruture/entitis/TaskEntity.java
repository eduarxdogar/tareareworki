package com.hexagonal.SNAPSHOT001.infranstruture.entitis;

import com.hexagonal.SNAPSHOT001.domain.models.Task;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String title;

    private String description;

    private LocalDateTime creationdate;
    private boolean completed;

    public TaskEntity() {
    }

    public TaskEntity(Long id,String title, String description,LocalDateTime creationdate,boolean completed){
        this.id=id;
        this.title=title;
        this.description=description;
        this.creationdate=creationdate;
        this.completed=completed;

    }
    public  static  TaskEntity fromDomainModel(Task task){
        return  new TaskEntity(task.getId(), task.getTitle(), task.getDescription(),task.getCreationDate(),task.isCompleted());
    }
    public Task toDomainModel(){
      return new Task(id,title,description,creationdate,completed);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(LocalDateTime creationdate) {
        this.creationdate = creationdate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
