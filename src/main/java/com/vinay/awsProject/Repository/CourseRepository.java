package com.vinay.awsProject.Repository;

import com.vinay.awsProject.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Integer>{

    List<Course> findAllByOrderByNameAsc();
}
