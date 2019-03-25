package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="MB_profile")
@SequenceGenerator(name="profile_seq", sequenceName="mb_profile_pk_seq", allocationSize=1)

public class Profile {
	@Id
	@Column(name="profile_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="profile_seq")
	private int profileId;
	
	@Column(name="favorite_movies")
	private String favoriteMovies;

	@Column(name="favorite_books")
	private String favoriteBooks;

	@Column(name="favorite_tv_shows")
	private String favoriteTvShows;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
//	@JsonIgnore
	private User user;
	

	public Profile() {
		super();
	}

//	public Profile(int profileId, String favoriteMovies, String favoriteBooks, String favoriteTvShows, User user) {
//		super();
//		this.profileId = profileId;
//		this.favoriteMovies = favoriteMovies;
//		this.favoriteBooks = favoriteBooks;
//		this.favoriteTvShows = favoriteTvShows;
//		this.user = user;
//	}
	
//	public Profile(int userId) {
//		this.user = new User();
//		user.setId(userId);
//	}
	
	public Profile(String favoriteMovies, String favoriteBooks, String favoriteTvShows) {
		super();
		this.favoriteMovies = favoriteMovies;
		this.favoriteBooks = favoriteBooks;
		this.favoriteTvShows = favoriteTvShows;
	}

//	public Profile(String favoriteMovies, String favoriteBooks, String favoriteTvShows, int userId) {
//		super();
//		this.favoriteMovies = favoriteMovies;
//		this.favoriteBooks = favoriteBooks;
//		this.favoriteTvShows = favoriteTvShows;
//		this.user = new User();
//		user.setId(userId);
//	}

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public String getFavoriteMovies() {
		return favoriteMovies;
	}

	public void setFavoriteMovies(String favoriteMovies) {
		this.favoriteMovies = favoriteMovies;
	}

	public String getFavoriteBooks() {
		return favoriteBooks;
	}

	public void setFavoriteBooks(String favoriteBooks) {
		this.favoriteBooks = favoriteBooks;
	}

	public String getFavoriteTvShows() {
		return favoriteTvShows;
	}

	public void setFavoriteTvShows(String favoriteTvShows) {
		this.favoriteTvShows = favoriteTvShows;
	}
	
	public User getUser() {
		return user;
	}
	
//	public int getUserId() {
//		return this.user.getId();
//	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((favoriteBooks == null) ? 0 : favoriteBooks.hashCode());
		result = prime * result + ((favoriteMovies == null) ? 0 : favoriteMovies.hashCode());
		result = prime * result + ((favoriteTvShows == null) ? 0 : favoriteTvShows.hashCode());
		result = prime * result + profileId;
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
		Profile other = (Profile) obj;
		if (favoriteBooks == null) {
			if (other.favoriteBooks != null)
				return false;
		} else if (!favoriteBooks.equals(other.favoriteBooks))
			return false;
		if (favoriteMovies == null) {
			if (other.favoriteMovies != null)
				return false;
		} else if (!favoriteMovies.equals(other.favoriteMovies))
			return false;
		if (favoriteTvShows == null) {
			if (other.favoriteTvShows != null)
				return false;
		} else if (!favoriteTvShows.equals(other.favoriteTvShows))
			return false;
		if (profileId != other.profileId)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

//	@Override
//	public String toString() {
//		return "Profile [profileId=" + profileId + ", favoriteMovies=" + favoriteMovies + ", favoriteBooks="
//				+ favoriteBooks + ", favoriteTvShows=" + favoriteTvShows + "user= " + this.getUserId() + "]";
//	}
	
	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", favoriteMovies=" + favoriteMovies + ", favoriteBooks="
				+ favoriteBooks + ", favoriteTvShows=" + favoriteTvShows +"]";
	}

}
