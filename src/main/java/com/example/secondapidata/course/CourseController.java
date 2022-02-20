package com.example.secondapidata.course;

import com.example.secondapidata.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    // startup spring look @RestController and create instance
    // see the @Autowired and look the dependency and
    // take that instance and inject
    //to declare dependency @Autowired
    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourse(@PathVariable String id){
        return courseService.getAllCourse(id);
    }

    @RequestMapping("/topics/{topicId}/courses/{id}")
    //tell it is a variable
    public Course getCourse(@PathVariable String id){
        return courseService.getCourse(id);
    }

    //map any of request that suppose on slash (/) topic
    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId ){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);

    }
}
