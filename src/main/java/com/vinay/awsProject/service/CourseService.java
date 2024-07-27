package com.vinay.awsProject.service;

import com.vinay.awsProject.Entity.Course;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CourseService {

    List<Course> findAll();

    Course findById(int theId);

    void save(Course theCourse);

    void deleteById(int theId);

    String generatePresignedUrl(String bucketName,String Key);

    String uploadImageToS3(String bucketName, MultipartFile imageFile);

}
