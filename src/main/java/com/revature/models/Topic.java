package com.revature.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MB_topics")
public class Topic {
	@Column(name="topic_id")
	@Id
	private int id;
	
	private String topicName;

	@OneToMany(mappedBy="topic", cascade=CascadeType.ALL)
	private List<Post> posts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopic() {
		return topicName;
	}

	public void setTopic(String topic) {
		this.topicName = topic;
	}

	public List<Post> getPost() {
		return posts;
	}

	public void setPost(List<Post> post) {
		this.posts = post;
	}
	
	//TODO Add a helper method to add 1 post to the topic rather than a list of posts 

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((posts == null) ? 0 : posts.hashCode());
		result = prime * result + ((topicName == null) ? 0 : topicName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topic other = (Topic) obj;
		if (id != other.id)
			return false;
		if (posts == null) {
			if (other.posts != null)
				return false;
		} else if (!posts.equals(other.posts))
			return false;
		if (topicName == null) {
			if (other.topicName != null)
				return false;
		} else if (!topicName.equals(other.topicName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Topic [id=" + id + ", topic=" + topicName + ", post=" + posts + "]";
	}
	
}
