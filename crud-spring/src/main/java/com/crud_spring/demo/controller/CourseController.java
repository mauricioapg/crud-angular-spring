package com.crud_spring.demo.controller;

import com.crud_spring.demo.dto.response.CourseResponseDTO;
import com.crud_spring.demo.model.Course;
import com.crud_spring.demo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<CourseResponseDTO> listAll(){
        return courseService.listAll();
    }

    @PostMapping
    public Course addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

}
