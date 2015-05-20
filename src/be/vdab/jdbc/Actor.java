package be.vdab.jdbc;

/**
 * Created by jeansmits on 20/05/15.
 */
public class Actor {
    private String firstname;
    private String lastname;
    private int actorid;

    public Actor(String firstname, String lastname, int actorid) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.actorid = actorid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getActorid() {
        return actorid;
    }

    public void setActorid(int actorid) {
        this.actorid = actorid;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname + "\n";
    }
}
