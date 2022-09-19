package com.dh.courseservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dh.courseservice.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
