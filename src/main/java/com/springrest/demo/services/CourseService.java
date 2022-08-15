package com.springrest.demo.services;

import com.springrest.demo.entities.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getCourses();

    public Course getCourse(Long courseId);

    Course addCourse(Course course);

    Course updateCourse(Course course);

    void deleteCourse(long parseLong);
}
