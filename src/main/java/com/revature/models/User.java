package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



//TODO - do not forget to do roles

@Entity
@Table(name="MB_users")
@SequenceGenerator(name="user_seq", sequenceName="mb_user_pk_seq", allocationSize=1)
public class User {
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_seq")
	private int id;
	
	@Column(name="username")
	private String username;

	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String LastName;
	
	@Column(name="password")
	private String password;
	
	@Column(name = "role_id")
	private int roleId;
	

	//TODO -- come back here
	// commented out so we do not get errors until we're done with DAOs


	@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
	private Profile profile;


	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<Post> posts;

	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<Response> responses;


	public User() {
		super();
	}


	public User(String username, String firstName, String lastName, String password) {
		super();
		this.username = username;
		this.firstName = firstName;
		LastName = lastName;
		this.password = password;
	}


	public User(int id, String username, String firstName, String lastName, String password) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		LastName = lastName;
		this.password = password;
	}


	
/*
	public List<Post> getPosts() {
		return posts;
	}


	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	

	public void addPost(Post post)    {        
		if(posts == null) posts = new ArrayList<>();        
		posts.add(post);        
		post.setUser(this);  
	}


	public List<Response> getResponses() {
		return responses;
	}


	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}
	

	public void addResponse(Response resp)    {        
		if(responses == null) posts = new ArrayList<>();        
		responses.add(resp);        
		resp.setUser(this);  
	}
*/

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	public Profile getProfile() {
		return profile;
	}


	public void setProfile(Profile profile) {
		this.profile = profile;
	}


	public List<Post> getPosts() {
		return posts;
	}


	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}


	public List<Response> getResponses() {
		return responses;
	}


	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((LastName == null) ? 0 : LastName.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((posts == null) ? 0 : posts.hashCode());
		result = prime * result + ((profile == null) ? 0 : profile.hashCode());
		result = prime * result + ((responses == null) ? 0 : responses.hashCode());
		result = prime * result + roleId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (LastName == null) {
			if (other.LastName != null)
				return false;
		} else if (!LastName.equals(other.LastName))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (posts == null) {
			if (other.posts != null)
				return false;
		} else if (!posts.equals(other.posts))
			return false;
		if (profile == null) {
			if (other.profile != null)
				return false;
		} else if (!profile.equals(other.profile))
			return false;
		if (responses == null) {
			if (other.responses != null)
				return false;
		} else if (!responses.equals(other.responses))
			return false;
		if (roleId != other.roleId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstName=" + firstName + ", LastName=" + LastName
				+ ", password=" + password + ", roleId=" + roleId + ", profile=" + profile + ", posts=" + posts
				+ ", responses=" + responses + "]";
	}


	
	


}
