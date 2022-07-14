package com.example.course.controller;

import com.example.course.entities.Course;
import com.example.course.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private CourseService courseSerivice;

    @GetMapping("/home")
    public String home(){
        return "Welcome to Courses Application";
    }

    //get the courses
    @GetMapping("/courses")
    public List<Course> getCourses(){
        return this.courseSerivice.getCourses();
    }


    //get course using courseId
    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId){
        return this.courseSerivice.getCourse(Long.parseLong(courseId));
    }

    //add a course
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        return this.courseSerivice.addCourse(course);
    }

    //update course details
    @PutMapping("/courses")
    public Course putCourse(@RequestBody Course course){
        return this.courseSerivice.putCourse(course);
    }

    //delete course
    @DeleteMapping("/courses/{crsId}")
    public ResponseEntity<HttpStatus> removeCourse(@PathVariable String crsId){
        try{
            this.courseSerivice.removeCourse(Long.parseLong(crsId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
