package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	private DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		app.launch();
	}

	private void test() {
		Film film = db.findFilmById(1);
		System.out.println(film);
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		DatabaseAccessorObject dao = new DatabaseAccessorObject();

        
        int choice = 0;
        do {
        	displayMenu();
        	choice = input.nextInt();
	        switch (choice) {
	        case 1:
	            System.out.println("Please enter a film id.");
	            int filmId = input.nextInt();
	            Film film = dao.findFilmById(filmId);
	            if (film != null) {
	            	film.printInfo();
	            } else {
	            	System.out.println("No film found with id: " + filmId);
	            }
	            break;
	        case 2:
	            System.out.println("Enter the keyword for the search: ");
	            String kw = input.next();
	            List<Film> films = dao.findFilmsByKeyword(kw);
	            if (films.isEmpty()) {
	            	System.out.println("No films match");
	            } else {
	            	for(Film currentFilm : films) {
	            		currentFilm.printInfo();
	            	}
	            }
	            break;
	        case 3:
	        	System.out.println("Exiting program");
	            break;
	        default:
	            System.out.println("Invalid choice. Please enter a valid option.");
	        }
        } while (choice != 3) ;
    }
	
	public void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Look up a film by its ID");
        System.out.println("2. Look up a film by a search keyword");
        System.out.println("3. Exit the application");
        System.out.print("Enter your choice: ");
	}
	
	public void subMenu() {
        System.out.println("Menu:");
        System.out.println("1. Return to main menu");
        System.out.println("2. View all film details");
        System.out.print("Enter your choice: ");
	}
	}
