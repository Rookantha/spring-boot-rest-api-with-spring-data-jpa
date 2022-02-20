package com.example.secondapidata.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Spring are singleton when application start up spring create an
// instance keep stack in memory other classes controllers
// dependent on that, can use stereotype(particular category )
// type annotation
@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourse(String topicId){
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId)
                .forEach(courses::add);
        return courses;

    }

    public Course getCourse(String id){
        //return topics.stream().filter(t-> t.getId().equals(id)).findFirst().get();
        return courseRepository.findById(id).orElse(null);
    }

    public void addCourse(Course course) {
       // topics.add(topic);
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}
