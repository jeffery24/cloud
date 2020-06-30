package com.emory.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.security.Provider;
import java.util.List;

public interface LoadBalancer {
    ServiceInstance INSTANCES(List<ServiceInstance> servicesInstances);
}
