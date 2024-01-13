package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		}
	}

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;
		String sql = "SELECT f.*,\n"
				+ "       l.name AS language\n"
				+ "FROM film f\n"
				+ "JOIN language l \n"
				+ " ON f.language_id  = l.id\n"
				+ "WHERE f.id = ?";
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, filmId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				List<Actor> actors = findActorsByFilmId(filmId);
				film = new Film(rs.getInt("id"), rs.getString("title"), rs.getString("description"), actors,
						rs.getInt("release_year"), rs.getString("rating"), rs.getString("language"));

			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println(e);
		}
		return film;
	}

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;
		String sql = "SELECT * FROM actor WHERE id = ?";
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, actorId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				actor = new Actor(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"));

			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println(e);
		}
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		String sql = "SELECT a.*\n" + 
					 "FROM actor a\n" + 
				     "JOIN film_actor fa\n" + 
					 " ON fa.actor_id = a.id \n" + 
				     "JOIN film f\n" + 
					 " ON f.id = fa.film_id \n" + 
				     " AND f.id = ?";
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, filmId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Actor actor = new Actor(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"));
				actors.add(actor);

			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println(e);
		}
		return actors;

	}

	public List<Film> findFilmsByKeyword(String keyword) {
		List<Film> films = new ArrayList<>();
		String sql = "SELECT f.*,\n"
				+ "          l.name AS language\n"
				+ "FROM film f\n"
				+ "JOIN language l \n"
				+ " ON f.language_id  = l.id\n"
				+ "WHERE LOWER(title) LIKE LOWER(?)"
				+ " OR LOWER(description) LIKE LOWER(?);";
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");
			ps.setString(2, "%" + keyword + "%");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				List<Actor> actors = findActorsByFilmId(id);
				Film film = new Film(id, rs.getString("title"), rs.getString("description"),
						             actors, rs.getInt("release_year"), rs.getString("rating"), rs.getString("language"));
				films.add(film);
			}
			
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println(e);
		}
		return films;

		
	}

}
