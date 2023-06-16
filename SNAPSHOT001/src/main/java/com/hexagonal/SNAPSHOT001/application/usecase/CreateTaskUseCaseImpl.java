package com.hexagonal.SNAPSHOT001.application.usecase;

import com.hexagonal.SNAPSHOT001.domain.models.Task;
import com.hexagonal.SNAPSHOT001.domain.ports.in.ICreateTaskUseCase;
import com.hexagonal.SNAPSHOT001.domain.ports.out.ITaskRepositoryPort;

public class CreateTaskUseCaseImpl implements ICreateTaskUseCase {
    private final ITaskRepositoryPort iTaskRepositoryPort;


    public CreateTaskUseCaseImpl(ITaskRepositoryPort iTaskRepositoryPort) {
        this.iTaskRepositoryPort = iTaskRepositoryPort;
    }

    @Override
    public Task createTask(Task task) {
        return iTaskRepositoryPort.save(task);
    }
}
