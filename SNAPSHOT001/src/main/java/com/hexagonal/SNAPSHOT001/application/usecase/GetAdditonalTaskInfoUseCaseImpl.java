package com.hexagonal.SNAPSHOT001.application.usecase;

import com.hexagonal.SNAPSHOT001.domain.models.AdditionalTaskInfo;
import com.hexagonal.SNAPSHOT001.domain.models.Task;
import com.hexagonal.SNAPSHOT001.domain.ports.in.IGetAdditionalTaskInfoUseCase;
import com.hexagonal.SNAPSHOT001.domain.ports.out.IExternalServicePort;

import java.util.Optional;

public class GetAdditonalTaskInfoUseCaseImpl implements IGetAdditionalTaskInfoUseCase {
    private final IExternalServicePort iExternalServicePort;


    public GetAdditonalTaskInfoUseCaseImpl(IExternalServicePort iExternalServicePort) {
        this.iExternalServicePort = iExternalServicePort;
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return iExternalServicePort.getAdditionalTaslInfo(id);
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updateTaks) {
        return Optional.empty();
    }
}
