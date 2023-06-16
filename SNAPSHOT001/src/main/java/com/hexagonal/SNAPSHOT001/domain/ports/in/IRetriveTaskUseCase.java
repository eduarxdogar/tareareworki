package com.hexagonal.SNAPSHOT001.domain.ports.in;

import com.hexagonal.SNAPSHOT001.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface IRetriveTaskUseCase {
    Optional<Task> getTask (Long id);
    List<Task> getAllTask();
}
