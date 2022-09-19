package com.dh.courseservice.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.dh.courseservice.model.dto.SubscriptionDTO;
import com.dh.courseservice.repository.CourseRepository;

@Service
public class CourseService {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final CourseRepository courseRepository;
    private final SubscriptionFeignClient subscriptionFeignClient;

    @Autowired
    public CourseService(CourseRepository courseRepository, SubscriptionFeignClient subscriptionFeignClient) {
        this.courseRepository = courseRepository;
        this.subscriptionFeignClient = subscriptionFeignClient;
    }

    public ResponseEntity<?> findCourseById(Integer courseId, Integer userId) {
        ResponseEntity<SubscriptionDTO> response =subscriptionFeignClient.findByUserId(userId);
        System.out.println(response.getHeaders().get("port"));
        SubscriptionDTO subscriptionDTO = response.getBody();
        if (Objects.nonNull(subscriptionDTO)) {
            LocalDate endOfSubscription = LocalDate.parse(subscriptionDTO.getEndDate(), formatter);
            return endOfSubscription.isAfter(LocalDate.now())
                ? new ResponseEntity<>(courseRepository.findById(courseId).orElse(null), HttpStatus.OK)
                : new ResponseEntity<>("La subscripción del usuario ha finalizado", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("No existe una subscripción para este usuario", HttpStatus.BAD_REQUEST);
    }
}
