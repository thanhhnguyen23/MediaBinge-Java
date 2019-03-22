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
	
	// foreign key goes here
//	@Column(name="user_id")
//	private int userId;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	
	
}
