package blueBox;

/**
 * Created by Jarred on 11/6/16.
 */
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DVD implements Serializable {

    /** Assigns a serial ID so that we can save serials of the rentals **/
    private static final long serialVersionUID = 1L;

    /** Gregorian calendar objects for date variable storage **/
    protected GregorianCalendar rentedOn;
    protected GregorianCalendar dueBack;

    /** String variables for Title of the DVD and name of whomever is renting it **/
    protected String title;
    protected String nameOfRenter;

    /************************************************************
     * Return the cost of the DVD, uses a ternary statement to
     * differentiate between whether or not the cost is 0 or $1.20
     * @param dat Takes the date
     * @return The cost of a DVD
     ***********************************************************/
    public double getCost(GregorianCalendar dat) {
        int compare = dat.compareTo(this.getDueBack());
        return compare < 0 ? 1.2 : 2;
    }

    public DVD() {
    }

    /************************************************************
     * Constructor that takes all of the necessary variables as
     * input parameters to then be organized and stored in the
     * Linked List
     * @param rentedOn Date Rented on
     * @param dueBack Date Due back
     * @param title Title of the DVD
     * @param name Name of the renter
     ***********************************************************/
    public DVD(GregorianCalendar rentedOn, GregorianCalendar dueBack, String title, String name) {
        super();
        this.rentedOn = rentedOn;
        this.dueBack = dueBack;
        this.title = title;
        this.nameOfRenter = name;
    }

    /************************************************************
     * Methods to get and set Rented on and Due back, getter methods
     * @return rentedOn or Dueback
     *
     * Setter methods take a GregorianCalendar Object to then set
     * to the rentedOn and DueBack variables
     * @param rentedOn, dueBack
     ***********************************************************/
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

    /************************************************************
     * Setters and Getters for the title of the movie. Getter
     * returns the title of the DVD
     * @return title
     *
     * Setter method takes parameter title as a String then sets
     * it equal to the global variable title
     * @param title
     ***********************************************************/
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    /************************************************************
     * Getters and setters for the name of the renter. Getter
     * returns the name of the renter
     * @return nameOfRenter
     *
     * Setter takes the parameter nameOfRenter as a String and then
     * stores it in the global nameOfRenter variable
     * @param nameOfRenter
     ***********************************************************/
    public String getNameOfRenter() {
        return nameOfRenter;
    }
    public void setNameOfRenter(String nameOfRenter) {
        this.nameOfRenter = nameOfRenter;
    }
}
