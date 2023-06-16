package com.hexagonal.SNAPSHOT001.domain.ports.out;

import com.hexagonal.SNAPSHOT001.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface ITaskRepositoryPort {
    Task save(Task task);
    Optional<Task> findById(Long id);
    List<Task> findAll();

    Optional<Task> update(Task task);
    boolean deleteById(Long id);
}
