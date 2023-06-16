package com.hexagonal.SNAPSHOT001.domain.ports.in;

import com.hexagonal.SNAPSHOT001.domain.models.Task;

public interface ICreateTaskUseCase {
    Task createTask (Task task);
}
