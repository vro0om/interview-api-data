package io.brains.controller.courses;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public CourseService() {
	}

	public List<Course> getAllCourses(String id) {
		List<Course> list = new ArrayList<Course>();

//		Iterable<course> findAll = courseRepository.findAll();
//		 for (course course : findAll) {
//			list.add(course);
//		}
//		 lambd
		courseRepository.findByTopicId(id).forEach(list::add);

		return list;
	}

	public Course getCourse(String id) {
		return courseRepository.findById(id).get();
//		return courses.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addCourse(Course course) {
//		courses.add(course);
		courseRepository.save(course);
	}

	public void updateCourse( Course course) {
//		for (int i = 0; i < courses.size(); i++) {
//			if (courses.get(i).getId().equals(id)) {
//				courses.set(i, course);
//				return;
//			}
//		}
		
		courseRepository.save(course);
	}
 
	public void deleteCourse(String id) {
//		courses.removeIf(t -> t.getId().equals(id));
		courseRepository.deleteById(id);
	}

}
