package be.vdab.jdbc;

import java.sql.*;


public class Main {
    public static void main(String[] args) {

        FilmFactory factory = new FilmFactory();
        //System.out.println(factory.findAllFilms().toString());

        System.out.println(factory.findAllActors(148).toString());

        //FilmDao dao = null; // instantiate a new JdbcFilmDao

        // Example usage:
        //List<Film> films = dao.findAllFilms();
        //for (Film film : films) {
        //    System.out.println(film.getTitle());
        //}

        // Example usage:
        //Film film = dao.findFilmById(1507);
        //film.setReleaseyear(2014);
        //dao.updateFilm(film);

        // Example usage:
        //dao.deleteFilm(1508);

        // ... play around with this.
    }

    private static Connection createConnection() {
        String url = "jdbc:mysql://localhost:3306/sakila";
        String username = "root";
        String password = "";
        String driverclassname = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driverclassname);
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("unable to connect: underlying error", e);
        }


    }
    }

