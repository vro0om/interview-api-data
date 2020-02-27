package io.brains.controller.courses;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import io.brains.controller.topic.Topic;

@Entity
public class Course {
	@Id
	private String id;
	private String name;
	private String description;
	@ManyToOne
	private Topic topic;
	public Course()
	{
		
	}
	
	public Course(String id,String name,String description,String topicId) {
		this.setId(id);
		this.setName(name);
		this.setDescription(description);
		topic = new Topic(topicId, "", "");
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
}
