package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;

public class Film {
	private int id;
	private String title;
	private String description;
	private List<Actor> actors;
	
	public Film(int id, String title, String description, List<Actor> actors) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.actors = actors;
		}
	
	public Film(int id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(description, other.description) && id == other.id && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", description=" + description + ", actors=" + actors + "]";
	}

	
	
	
	
	
}
