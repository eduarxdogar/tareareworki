package com.hexagonal.SNAPSHOT001.infranstruture.repositories;

import com.hexagonal.SNAPSHOT001.domain.models.Task;
import com.hexagonal.SNAPSHOT001.domain.ports.out.ITaskRepositoryPort;
import com.hexagonal.SNAPSHOT001.infranstruture.entitis.TaskEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
public class JpaTaskRepositoryAdapter implements ITaskRepositoryPort {

    private final IJpaTaskRepository iJpaTaskRepository;

    public JpaTaskRepositoryAdapter(IJpaTaskRepository iJpaTaskRepository) {
        this.iJpaTaskRepository = iJpaTaskRepository;
    }

    @Override
    public Task save(Task task) {
        TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
        TaskEntity saveTaskEntity = iJpaTaskRepository.save(taskEntity);
        return saveTaskEntity.toDomainModel();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return iJpaTaskRepository.findById(id).map(TaskEntity::toDomainModel);
    }

    @Override
    public List<Task> findAll() {
        return iJpaTaskRepository.findAll().stream().map(TaskEntity::toDomainModel).collect(Collectors.toList());

    }

    @Override
    public Optional<Task> update(Task task) {
        if (iJpaTaskRepository.existsById(task.getId())){
            TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
            TaskEntity updateTaskEntity = iJpaTaskRepository.save(taskEntity);
            return Optional.of(updateTaskEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (iJpaTaskRepository.existsById(id)){
            iJpaTaskRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
