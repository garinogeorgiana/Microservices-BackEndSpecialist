package com.dh.subscriptionservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dh.subscriptionservice.model.Subscription;
import com.dh.subscriptionservice.repository.SubscriptionRepository;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    @Autowired
    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public Subscription findByUserId(Integer userId) {
        return this.subscriptionRepository.findByUserId(userId);
    }
}
