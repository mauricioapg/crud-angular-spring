package com.crud_spring.demo.services;

import com.crud_spring.demo.dto.response.CourseResponseDTO;
import com.crud_spring.demo.model.Course;
import com.crud_spring.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

//    private final CourseRepository courseRepository;
//    CourseService (CourseRepository courseRepository) {
//        this.courseRepository = courseRepository;
//    }

    public List<CourseResponseDTO> listAll(){
        List<Course> courses = courseRepository.findAll();
        List<CourseResponseDTO> responseList = new ArrayList<>();

        if(!courses.isEmpty()){
            courses.forEach(course -> {
                CourseResponseDTO dto = new CourseResponseDTO();
                dto.setName(course.getName());
                dto.setCategory(course.getCategory());
                responseList.add(dto);
            });
        }

        return responseList;
    }

    public Course addCourse(Course course){

        course.setName(course.getName());
        course.setCategory(course.getCategory());

        return courseRepository.save(course);
    }

}
