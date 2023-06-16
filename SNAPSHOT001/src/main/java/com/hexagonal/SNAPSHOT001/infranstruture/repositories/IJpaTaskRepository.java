package com.hexagonal.SNAPSHOT001.infranstruture.repositories;

import com.hexagonal.SNAPSHOT001.infranstruture.entitis.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJpaTaskRepository  extends JpaRepository<TaskEntity,Long> {
}
