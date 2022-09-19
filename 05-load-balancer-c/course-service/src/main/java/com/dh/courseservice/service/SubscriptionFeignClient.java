package com.dh.courseservice.service;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.dh.courseservice.config.LoadBalancerConfig;
import com.dh.courseservice.model.dto.SubscriptionDTO;

@FeignClient(name = "subscription-service")
@LoadBalancerClient(name = "subscription-service", configuration = LoadBalancerConfig.class)
public interface SubscriptionFeignClient {

    @GetMapping("/subscriptions")
    ResponseEntity<SubscriptionDTO> findByUserId(@RequestParam Integer userId);
}
