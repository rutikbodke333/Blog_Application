package com.blogapplication.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "user_name", nullable = false, length = 100)
	private String name;

	private String email;

	private String password;

	private String about;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Post> post = new ArrayList<>();
	
//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinTable(name = "user_role",
//	joinColumns = @JoinColumn (name = "user", referencedColumnName = "id"),
//	inverseJoinColumns = @JoinColumn(name = "role", referencedColumnName = "id"))
//	private List<Role> roles = new ArrayList<>();
//	Third table user_role is created to establish many-to-many relationship between User and Role entities.
//	Alice becomes an ADMIN and a USER, so there are two entries in the user_role table for Alice.
//	+--------+--------+
//	| user   | role   |
//	+--------+--------+
//	|   1    |   1    |  --> Alice is ADMIN
//	|   1    |   2    |  --> Alice is USER
//	+--------+--------
	

}
