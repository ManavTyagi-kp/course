package com.example.course.services;

import java.util.List;
import com.example.course.entities.Course;
public interface CourseService {
    //easy coupling
    public List<Course> getCourses();
    public Course getCourse(long courseId);
    public Course addCourse(Course course);
    public Course putCourse(Course course);
    public void removeCourse(long crsId);
}
