package be.vdab.jdbc;

public class Main {
    public static void main(String[] args) {
        FilmDao dao = null; // instantiate a new JdbcFilmDao

        // Example usage:
        List<Film> films = dao.findAllFilms();
        for (Film film : films) {
            System.out.println(film.getTitle());
        }

        // Example usage:
        Film film = dao.findFilmById(1507);
        film.setReleaseYear(2014);
        dao.updateFilm(film);

        // Example usage:
        dao.deleteFilm(1508);

        // ... play around with this.
    }
}
