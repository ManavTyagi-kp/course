package com.example.course.services;

import com.example.course.dao.CourseDao;
import com.example.course.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseDao courseDao;

//    List<Course> list;

    public CourseServiceImpl(){
//       list = new ArrayList<>();
//       list.add(new Course(125, "Java Core Course", "this course contains java concepts"));
//       list.add(new Course(1453, "Python Course", "this course contains python concepts"));
    }

    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId) {
//       Course c = null;
//       for(Course course : list){
//           if(course.getId()==courseId){
//               c = course;
//               break;
//           }
//       }
        return courseDao.getReferenceById(courseId);
    }

    @Override
    public Course addCourse(Course course) {
//        list.add(course);
        courseDao.save(course);
        return course;
    }

    @Override
    public Course putCourse(Course course) {
//       Course c = null;
//       for(Course cours : list){
//           if(cours.getId()==courseId){
//               c = cours;
//               list.remove(c);
//               break;
//           }
//       }
//       list.add(course);
        courseDao.save(course);
        return course;
    }

    @Override
    public void removeCourse(long courseId) {
//       Course c = null;
//       for(Course crs : list){
//           if(crs.getId()==courseId){
//               c = crs;
//               list.remove(c);
//               break;
//           }
//       }
//       return c;
        Course entity = courseDao.getReferenceById(courseId);
        courseDao.delete(entity);
    }
}
