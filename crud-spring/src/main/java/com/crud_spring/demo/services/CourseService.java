package com.crud_spring.demo.services;

import com.crud_spring.demo.dto.request.CourseRequestDTO;
import com.crud_spring.demo.dto.response.CourseResponseDTO;
import com.crud_spring.demo.model.Course;
import com.crud_spring.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public CourseResponseDTO findById(String id){
        Optional<Course> course = courseRepository.findById(id);
        CourseResponseDTO responseDTO = new CourseResponseDTO();

        if(course.isPresent()){
            responseDTO.setName(course.get().getName());
            responseDTO.setCategory(course.get().getCategory());
        }

        return responseDTO;
    }

    public Course addCourse(Course course){

        course.setName(course.getName());
        course.setCategory(course.getCategory());

        return courseRepository.save(course);
    }

    public Course editCourse(String id, CourseRequestDTO courseRequestDTO){

        Optional<Course> course = courseRepository.findById(id);

        course.get().setName(courseRequestDTO.getName());
        course.get().setCategory(courseRequestDTO.getCategory());

        return courseRepository.save(course.get());
    }

    public void deleteCourse(String id){

        Optional<Course> course = courseRepository.findById(id);
        courseRepository.delete(course.get());
    }

}
