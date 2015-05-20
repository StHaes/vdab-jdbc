package be.vdab.jdbc;

/**
 * Created by jeansmits on 20/05/15.
 */
public class Film {
    private String title;
    private String releaseyear;
    private int filmid;
    private Actor [] actors;


    public Film(String title, String releaseyear, int filmid) {
        this.title = title;
        this.releaseyear = releaseyear;
        this.filmid = filmid;
    }

    public String getReleaseyear() {
        return releaseyear;
    }

    public void setReleaseyear(String releaseyear) {
        this.releaseyear = releaseyear;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getFilmid() {
        return filmid;
    }

    public void setFilmid(int filmid) {
        this.filmid = filmid;
    }

    @Override
    public String toString() {
        return "titel " + title + "\n";
    }
}
