package com.example.secondapidata.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {
    // startup spring look @RestController and create instance
    // see the @Autowired and look the dependency and
    // take that instance and inject
    //to declare dependency @Autowired
    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getTopic(){
        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    //tell it is a variable
    public Topic getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }

    //map any of request that suppose on slash (/) topic
    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    //Annotation indicating a method parameter should be bound to
    // the body of the web request. The body of the request is
    // passed through an HttpMessageConverter to resolve the
    // method argument depending on the content type of the request.
    // Optionally, automatic validation can be applied by annotating
    // the argument with @Valid.
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic,@PathVariable String id){
        topicService.updateTopic(id, topic);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);

    }
}
