package com.jsonplaceholder.todos;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Todos {

	@Id
    @GeneratedValue( strategy = GenerationType.AUTO )
	private final long id;
	
	private final int userId;
	private final String title;
	private final boolean complete;
	
	public Todos(long id, int userId, String title, boolean complete) {
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.complete = complete;
	}

	public long getId() {
		return id;
	}
	
	public int getUserId() {
		return userId;
	}


	public String getTitle() {
		return title;
	}

	public boolean getComplete() {
		return complete;
	}
}