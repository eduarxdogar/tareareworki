package com.hexagonal.SNAPSHOT001.domain.ports.out;

import com.hexagonal.SNAPSHOT001.domain.models.AdditionalTaskInfo;

public interface IExternalServicePort {
    AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);

    AdditionalTaskInfo getAdditionalTaslInfo (Long taskId);
}
