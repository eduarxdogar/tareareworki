package com.hexagonal.SNAPSHOT001.application.usecase;

import com.hexagonal.SNAPSHOT001.domain.models.Task;
import com.hexagonal.SNAPSHOT001.domain.ports.in.IDeleteTaskUseCase;
import com.hexagonal.SNAPSHOT001.domain.ports.in.IUpdateTaskUseCase;
import com.hexagonal.SNAPSHOT001.domain.ports.out.ITaskRepositoryPort;

import java.util.Optional;

public class UpdateTaskUSeCaseImpl implements IUpdateTaskUseCase, IDeleteTaskUseCase {

    private final ITaskRepositoryPort iTaskRepositoryPort;


    public UpdateTaskUSeCaseImpl(ITaskRepositoryPort iTaskRepositoryPort) {
        this.iTaskRepositoryPort = iTaskRepositoryPort;
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updateTaks) {
        return iTaskRepositoryPort.update(updateTaks);
    }

    @Override
    public boolean deleteTask(Long Id) {
        return false;
    }
}
