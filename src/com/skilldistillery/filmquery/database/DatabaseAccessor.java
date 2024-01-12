package com.skilldistillery.filmquery.database;

import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public interface DatabaseAccessor {
	public static final String USER = "student";
	public static final String PASS = "student";
	public static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=America/New_York";

	public Film findFilmById(int filmId);
	public Actor findActorById(int actorId);
	public List<Actor> findActorsByFilmId(int filmId);



}
