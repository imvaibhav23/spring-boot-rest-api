package com.springrest.demo.services;

import com.springrest.demo.entities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceimpl implements CourseService{
    List<Course> list;
    public CourseServiceimpl(){
        list=new ArrayList<>();
        list.add(new Course(124,"Java Core Course", "this course for rest api"));
        list.add(new Course(125,"PHP Core Course", "this course for rest api in php"));
    }
    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public Course getCourse(Long courseId) {
        Course c=null;
        for(Course course : list)
        {
            if(Course.getId()==courseId){
                c=course;
                break;
            }

        }
        return c;
    }

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        list.forEach(e -> {
            if(e.getId() == course.getId()){
                e.setTitle(course.getTitle());
                e.setDescription(course.getDescription());
            }
        });
        return course;
    }

    @Override
    public void deleteCourse(long parseLong) {
        list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
    }
}
