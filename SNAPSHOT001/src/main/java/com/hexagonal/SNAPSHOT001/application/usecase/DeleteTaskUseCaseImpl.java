package com.hexagonal.SNAPSHOT001.application.usecase;

import com.hexagonal.SNAPSHOT001.domain.models.AdditionalTaskInfo;
import com.hexagonal.SNAPSHOT001.domain.models.Task;
import com.hexagonal.SNAPSHOT001.domain.ports.in.IDeleteTaskUseCase;
import com.hexagonal.SNAPSHOT001.domain.ports.in.IGetAdditionalTaskInfoUseCase;
import com.hexagonal.SNAPSHOT001.domain.ports.out.ITaskRepositoryPort;

import java.util.Optional;

public class DeleteTaskUseCaseImpl implements IDeleteTaskUseCase, IGetAdditionalTaskInfoUseCase {

    private final ITaskRepositoryPort iTaskRepositoryPort;

    public DeleteTaskUseCaseImpl(ITaskRepositoryPort iTaskRepositoryPort) {
        this.iTaskRepositoryPort = iTaskRepositoryPort;
    }

    @Override
    public boolean deleteTask(Long Id) {
        return iTaskRepositoryPort.deleteById(Id);
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return null;
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updateTaks) {
        return Optional.empty();
    }
}
