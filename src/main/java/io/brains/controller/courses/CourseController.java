package io.brains.controller.courses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.brains.controller.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	// how to make service sinleton
	private CourseService courseService;

	// GET
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getCourses(@PathVariable("id") String topicId) {

		return courseService.getAllCourses(topicId);
	}

	// GET
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getcourse(@PathVariable("id") String id) {
		return courseService.getCourse(id);
	}

	// Post
	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	public void addcourse(@RequestBody Course course,@PathVariable("topicId") String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}

	// Update
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
	public void updatecourse(@RequestBody Course course, @PathVariable String id,@PathVariable("topicId") String topicId) {
		course.setTopic(new Topic(topicId, "", ""));

		courseService.updateCourse( course);
	}

	// Delete
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/course/{id}")
	public void deletecourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}

}
