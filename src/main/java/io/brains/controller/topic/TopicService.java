package io.brains.controller.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics;

	@Autowired
	private TopicRepository topicRepository;

	public TopicService() {
		topics = new ArrayList<Topic>();
	}

	public List<Topic> getAllTopics() {
		List<Topic> list = new ArrayList<Topic>();

//		Iterable<Topic> findAll = topicRepository.findAll();
//		 for (Topic topic : findAll) {
//			list.add(topic);
//		}
//		 lambd
		topicRepository.findAll().forEach(list::add);

		return list;
	}

	public Topic getTopic(String id) {
		Optional<Topic> findById = topicRepository.findById(id);
		return findById.get();
//		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
//		topics.add(topic);
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
//		for (int i = 0; i < topics.size(); i++) {
//			if (topics.get(i).getId().equals(id)) {
//				topics.set(i, topic);
//				return;
//			}
//		}
		
		topicRepository.save(topic);
	}
 
	public void deleteTopic(String id) {
//		topics.removeIf(t -> t.getId().equals(id));
		topicRepository.deleteById(id);
	}

}
