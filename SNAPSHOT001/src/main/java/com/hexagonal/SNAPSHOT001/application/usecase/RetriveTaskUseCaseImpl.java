package com.hexagonal.SNAPSHOT001.application.usecase;

import com.hexagonal.SNAPSHOT001.domain.models.Task;
import com.hexagonal.SNAPSHOT001.domain.ports.in.IRetriveTaskUseCase;
import com.hexagonal.SNAPSHOT001.domain.ports.out.ITaskRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetriveTaskUseCaseImpl implements IRetriveTaskUseCase {
    private final ITaskRepositoryPort iTaskRepositoryPort;


    public RetriveTaskUseCaseImpl(ITaskRepositoryPort iTaskRepositoryPort) {
        this.iTaskRepositoryPort = iTaskRepositoryPort;
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return iTaskRepositoryPort.findById(id);
    }

    @Override
    public List<Task> getAllTask() {
        return iTaskRepositoryPort.findAll();
    }
}
