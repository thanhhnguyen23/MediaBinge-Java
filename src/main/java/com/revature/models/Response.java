package com.revature.models;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="MB_responses")
@SequenceGenerator(name="response_seq", sequenceName="mb_response_pk_seq", allocationSize=1)

public class Response {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="response_seq")
	@Column(name="response_id")
	private int responseId;
	
	@Column(name="response_text")
	private String text;
	
	@ManyToOne(cascade={
			CascadeType.PERSIST, CascadeType.DETACH,
			CascadeType.MERGE, CascadeType.REFRESH
	})
	@JoinColumn(name="post_id")
	private Post post;

	@ManyToOne(cascade={
		CascadeType.PERSIST, CascadeType.DETACH,
		CascadeType.MERGE, CascadeType.REFRESH
	})
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name = "api_call")
	private String api_call;
	
	@Column(name = "date_posted")
	private Timestamp datePosted;
	
	public Response() {
		super();
	}
	public Response(int responseId, String text)
	{
		this.responseId = responseId;
		this.text = text;
	}
	public Response(int responseId, String text, Post post, User user, String api_call, Timestamp datePosted) {
		super();
		this.responseId = responseId;
		this.text = text;
		this.post = post;
		this.user = user;
		this.api_call = api_call;
		this.datePosted = datePosted;
	}
	
	public Response(int responseId, String text, String api_call, Timestamp datePosted)
	{
		this.responseId = responseId;
		this.text = text;
		this.api_call = api_call;
		this.datePosted = datePosted;
	}
	
	public Timestamp getDatePosted() {
		return datePosted;
	}
	public void setDatePosted(Timestamp datePosted) {
		this.datePosted = datePosted;
	}
	public String getApi_call() {
		return api_call;
	}

	public void setApi_call(String api_call) {
		this.api_call = api_call;
	}

	public int getResponseId() {
		return responseId;
	}

	public void setResponseId(int responseId) {
		this.responseId = responseId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((post == null) ? 0 : post.hashCode());
		result = prime * result + responseId;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Response other = (Response) obj;
		if (post == null) {
			if (other.post != null)
				return false;
		} else if (!post.equals(other.post))
			return false;
		if (responseId != other.responseId)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Response [responseId=" + responseId + ", text=" + text + ", post=" + post.getPostId() + ", user=" + user.getId() + "]";
	}
	
	


}