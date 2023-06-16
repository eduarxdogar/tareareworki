package com.hexagonal.SNAPSHOT001.application.service;

import com.hexagonal.SNAPSHOT001.domain.models.AdditionalTaskInfo;
import com.hexagonal.SNAPSHOT001.domain.models.Task;
import com.hexagonal.SNAPSHOT001.domain.ports.in.*;

import java.util.List;
import java.util.Optional;

public class TaskService implements ICreateTaskUseCase, IRetriveTaskUseCase, IDeleteTaskUseCase, IGetAdditionalTaskInfoUseCase, IUpdateTaskUseCase {

    private final  ICreateTaskUseCase iCreateTaskUseCase;
    private final  IRetriveTaskUseCase iRetriveTaskUseCase;
    private final  IDeleteTaskUseCase iDeleteTaskUseCase;
    private final  IGetAdditionalTaskInfoUseCase iGetAdditionalTaskInfoUseCase;
    private final  IUpdateTaskUseCase iUpdateTaskUseCase;

    public TaskService(ICreateTaskUseCase iCreateTaskUseCase, IRetriveTaskUseCase iRetriveTaskUseCase, IDeleteTaskUseCase iDeleteTaskUseCase, IGetAdditionalTaskInfoUseCase iGetAdditionalTaskInfoUseCase, IUpdateTaskUseCase iUpdateTaskUseCase) {
        this.iCreateTaskUseCase = iCreateTaskUseCase;
        this.iRetriveTaskUseCase = iRetriveTaskUseCase;
        this.iDeleteTaskUseCase = iDeleteTaskUseCase;
        this.iGetAdditionalTaskInfoUseCase = iGetAdditionalTaskInfoUseCase;
        this.iUpdateTaskUseCase = iUpdateTaskUseCase;
    }

    @Override
    public Task createTask(Task task) {
        return iCreateTaskUseCase.createTask(task);
    }

    @Override
    public boolean deleteTask(Long Id) {
        return false;
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return iGetAdditionalTaskInfoUseCase.getAdditionalTaskInfo(id);
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return iRetriveTaskUseCase.getTask(id);
    }

    @Override
    public List<Task> getAllTask() {
        return null;
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updateTaks) {
        return Optional.empty();
    }
}
