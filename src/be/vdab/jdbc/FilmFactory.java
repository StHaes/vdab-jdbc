package be.vdab.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeansmits on 20/05/15.
 */
public class FilmFactory implements FilmDao {


    public FilmFactory() {
    }

    Connection c = createConnection();

    @Override
    public Film findFilmById(int id) {
        Film film = null;
        try {
            PreparedStatement s = c.prepareStatement("select * from film where film_id =?");
            s.setInt(1, id);
            ResultSet rs = s.executeQuery();
            while (rs.next())
                return new Film(rs.getString("title"), rs.getString("release_year"), rs.getInt("film_id"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return film;
    }

    @Override
    public List<Film> findAllFilms() {
        try {
            PreparedStatement p = c.prepareStatement("select * from film");
            ResultSet r = p.executeQuery();
            List l = new ArrayList<Film>();
            while (r.next()) {
                l.add(new Film(r.getString("title"), r.getString("release_year"), r.getInt("film_id")));
            }
            return l;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;


    }

    @Override
    public boolean updateFilm(Film film) throws IllegalArgumentException {
        try {
            PreparedStatement p = c.prepareStatement("update film set title = ? where film_id = ?");

            p.setString(1, film.getTitle());
            p.setInt(2, film.getFilmid());

            return p.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteFilm(int id) {
        try {
            PreparedStatement p = c.prepareStatement("delete from film where film_id = ?");
            p.setInt(1, id);
            return p.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Actor> findAllActors(int id) {
        try {
        PreparedStatement p = c.prepareStatement("SELECT * FROM actor a join film_actor fa on a.actor_id = fa.actor_id where fa.film_id = ?");
            p.setInt(1, id);
        ResultSet r = p.executeQuery();
        List l = new ArrayList<Actor>();
        while (r.next()) {
            l.add(new Actor(r.getString("first_name"), r.getString("last_name"), r.getInt("actor_id")));
        }
        return l;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
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
