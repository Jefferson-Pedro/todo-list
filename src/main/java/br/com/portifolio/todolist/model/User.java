package br.com.portifolio.todolist.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_users")
public class User {
	
	@Id
	@GeneratedValue( generator = "UUID")
	private UUID id;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "password")
	private String password;
	
	@CreationTimestamp
	private LocalDateTime createAt;
	

	public User() {}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getUsername() {
		return userName;
	}
	
	public void setUsername(String username) {
		this.userName = username;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}
}
