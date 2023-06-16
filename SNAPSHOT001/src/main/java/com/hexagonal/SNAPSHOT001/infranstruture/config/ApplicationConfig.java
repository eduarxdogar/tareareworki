package com.hexagonal.SNAPSHOT001.infranstruture.config;

import com.hexagonal.SNAPSHOT001.application.service.TaskService;
import com.hexagonal.SNAPSHOT001.application.usecase.*;
import com.hexagonal.SNAPSHOT001.domain.ports.in.IGetAdditionalTaskInfoUseCase;
import com.hexagonal.SNAPSHOT001.domain.ports.out.IExternalServicePort;
import com.hexagonal.SNAPSHOT001.domain.ports.out.ITaskRepositoryPort;
import com.hexagonal.SNAPSHOT001.infranstruture.adapters.ExternalServiceAdapter;
import com.hexagonal.SNAPSHOT001.infranstruture.repositories.JpaTaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public TaskService taskService (ITaskRepositoryPort iTaskRepositoryPort, IGetAdditionalTaskInfoUseCase iGetAdditionalTaskInfoUseCase){
        return  new TaskService(
                new CreateTaskUseCaseImpl(iTaskRepositoryPort),
                new RetriveTaskUseCaseImpl(iTaskRepositoryPort),
                new UpdateTaskUSeCaseImpl(iTaskRepositoryPort),
                new DeleteTaskUseCaseImpl(iTaskRepositoryPort),
                iGetAdditionalTaskInfoUseCase
        );
    }
    @Bean
    public  ITaskRepositoryPort iTaskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter){
        return jpaTaskRepositoryAdapter;
    }
    @Bean
    public IGetAdditionalTaskInfoUseCase iGetAdditionalTaskInfoUseCase(IExternalServicePort iExternalServicePort){
        return  new GetAdditonalTaskInfoUseCaseImpl(iExternalServicePort);
    }
    @Bean
    public IExternalServicePort iExternalServicePort (){
        return new ExternalServiceAdapter();
    }
}
