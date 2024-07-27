package com.vinay.awsProject.service;

import com.amazonaws.services.s3.S3ClientOptions;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.vinay.awsProject.Entity.Course;
import com.vinay.awsProject.Repository.CourseRepository;
import org.springframework.web.multipart.MultipartFile;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;

import software.amazon.awssdk.services.s3.presigner.model.PresignedGetObjectRequest;

import static com.amazonaws.services.s3.model.GetObjectRequest.*;

public class CourseServiceImpl implements CourseService{
    private final CourseRepository courseRepository;
    private final S3Presigner s3Presigner;
    private final S3Client s3Client;


    public CourseServiceImpl(CourseRepository courseRepository, S3Presigner s3Presigner, S3Client s3Client) {
        this.courseRepository = courseRepository;
        this.s3Presigner = s3Presigner;
        this.s3Client = s3Client;
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(int theId) {
        Optional<Course> result = courseRepository.findById(theId);

        Course theCourse = null;

        if(result.isPresent()){
            theCourse = result.get();
        }else{
            throw new RuntimeException("Did not find course id - " + theId);
        }
        return theCourse;


    }

    @Override
    public void save(Course theCourse) {
        courseRepository.save(theCourse);


    }

    @Override
    public void deleteById(int theId) {
        courseRepository.deleteById(theId);

    }

    @Override
    public String generatePresignedUrl(String bucketName, String Key) {
        GetObjectRequest getObjectRequest = GetObjectRequest.bucket()
                .bucket(bucketName)
                .key(key)
                .build();

        GetObjectPresignRequest getObjectPresignRequest = GetObjectPresignRequest.builder()
                .signatureDuration(Duration.ofMinutes(60)).getObjectRequest(getObjectRequest).build();


        return "";
    }

    @Override
    public String uploadImageToS3(String bucketName, MultipartFile imageFile) {
        return "";
    }
}
