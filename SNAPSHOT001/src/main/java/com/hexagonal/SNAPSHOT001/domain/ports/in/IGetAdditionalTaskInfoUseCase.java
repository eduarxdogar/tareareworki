package com.hexagonal.SNAPSHOT001.domain.ports.in;

import com.hexagonal.SNAPSHOT001.domain.models.AdditionalTaskInfo;
import com.hexagonal.SNAPSHOT001.domain.models.Task;

import java.util.Optional;

public interface IGetAdditionalTaskInfoUseCase extends IUpdateTaskUseCase {
    AdditionalTaskInfo getAdditionalTaskInfo(Long id);

    @Override
    Optional<Task> updateTask(Long id, Task updateTaks);
}
