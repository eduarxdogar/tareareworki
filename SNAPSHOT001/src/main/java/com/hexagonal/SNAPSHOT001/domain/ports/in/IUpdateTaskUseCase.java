package com.hexagonal.SNAPSHOT001.domain.ports.in;

import com.hexagonal.SNAPSHOT001.domain.models.Task;

import java.util.Optional;

public interface IUpdateTaskUseCase {
    Optional<Task> updateTask(Long id,Task updateTaks);
}
