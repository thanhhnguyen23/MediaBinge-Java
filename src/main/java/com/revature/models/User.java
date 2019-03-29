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

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private String lastName;
	
	@Column(name="password")
	private String password;
	

	@Column(name = "role_id")
	private int roleId;
	

	//TODO -- come back here
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Post> posts;
	

	@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
	@JsonIgnore
	private Profile profile;
	public User() {
		super();
	}
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Response> responses;
	public User(int id, String username, String firstName, String lastName, String password)
	{
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.roleId = 2;
		System.out.println("hi");
	}
	public User(int id, String username, String firstName, String lastName, String password, Profile profile) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.profile = profile;
		System.out.println("maybe");
	}
	public void addPost(Post post) {
		if(posts == null) posts = new ArrayList<>();
		posts.add(post);
		post.setUser(this);
	}
	public void addResponse(Response response) {
		if(responses == null) responses = new ArrayList<>();
		responses.add(response);
		response.setUser(this);
	}
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

	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	public int getRole() {
		return roleId;
	}


	public void setRole(int role) {
		this.roleId = role;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((profile == null) ? 0 : profile.hashCode());
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
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
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
		if (profile == null) {
			if (other.profile != null)
				return false;
		} else if (!profile.equals(other.profile))
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
		return "User [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + "]";
	}

	

	


	

	
	


}
