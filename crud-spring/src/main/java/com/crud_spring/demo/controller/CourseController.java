package com.crud_spring.demo.controller;

import com.crud_spring.demo.dto.request.CourseRequestDTO;
import com.crud_spring.demo.dto.response.CourseResponseDTO;
import com.crud_spring.demo.model.Course;
import com.crud_spring.demo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<CourseResponseDTO> listAll(){
        return courseService.listAll();
    }

    @GetMapping("{id}")
    public CourseResponseDTO findBydId(@PathVariable String id){
        return courseService.findById(id);
    }

    @PostMapping
    public Course addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @PutMapping("{id}")
    public Course editCourse(@PathVariable String id, @RequestBody CourseRequestDTO courseRequestDTO){
        return courseService.editCourse(id, courseRequestDTO);
    }

    @DeleteMapping("{id}")
    public void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
    }

}
