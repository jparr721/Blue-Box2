package blueBox;

/**
 * Created by Jarred on 11/6/16.
 */
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DVD implements Serializable {

    private static final long serialVersionUID = 1L;

    /** The Date the DVD/Game was Rented **/
    protected GregorianCalendar rentedOn;

    /** The Date the DVD/Game is due back **/
    protected GregorianCalendar dueBack;

    /** The title of the DVD/Game **/
    protected String title;

    /** Name of the person who is renting the DVD **/
    protected String nameOfRenter;

    private MovieType movie;

    public double getCost(GregorianCalendar date) {
        double cost = 1.2;
        return cost;
    }

    public DVD() {
    }

    public DVD(GregorianCalendar rentedOn, GregorianCalendar dueBack,
               String title, String name, MovieType movie) {
        super();
        this.rentedOn = rentedOn;
        this.dueBack = dueBack;
        this.title = title;
        this.nameOfRenter = name;
        this.movie = movie;
    }

    public GregorianCalendar getRentedOn() {
        return rentedOn;
    }
    public void setRentedOn(GregorianCalendar rentedOn) {
        this.rentedOn = rentedOn;
    }
    public GregorianCalendar getDueBack() {
        return dueBack;
    }
    public void setDueBack(GregorianCalendar dueBack) {
        this.dueBack = dueBack;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public MovieType getMovieTitle() { return movie; }
    public void setMovieTitle(MovieType movie) { this.movie = movie; }

    public String getNameOfRenter() {
        return nameOfRenter;
    }
    public void setNameOfRenter(String nameOfRenter) {
        this.nameOfRenter = nameOfRenter;
    }
}
