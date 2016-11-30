package blueBox;

/**
 * Created by Jarred on 11/6/16.
 */

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/********************************************************
 * This method is a child of the DVD class and extends
 * its methods. Its main purpose is to set up getters and
 * setters for anything that would pertain to the Game
 * selection and dialog box.
***********************************************************/

public class Game extends DVD {

    /** PlayerType Object **/
    private PlayerType player;   // Xbox 360, PS3, Xbox720.

    /************************************************************
     * Return the cost of the Game, uses a ternary statement to
     * differentiate between whether or not the cost is 0 or $5.00
     * @param dat Takes the date
     * @return The cost of a Game
     ***********************************************************/
    public double getCost(GregorianCalendar dat) {
        int compare = dat.compareTo(this.getDueBack());
        return compare < 0 ? 5 : 10;
    }

    /************************************************************
     * Default constructor which uses super() to refrence the
     * parent DVD class that gives it its methods
     ***********************************************************/
    public Game() {
        super();
    }

    /************************************************************
     * Constructor that takes all of the necessary variables as
     * input parameters to then be organized and stored in the
     * Linked List
     * @param rentedOn Date Rented on
     * @param dueBack Date Due back
     * @param title Title of the DVD
     * @param name Name of the renter
     * @param player PlayerType object
     ***********************************************************/
    public Game(GregorianCalendar rentedOn, GregorianCalendar dueBack,
                String title, String name, PlayerType player) {
        super(rentedOn, dueBack, title, name);
        this.player = player;
    }

    /***********************************************************
     * Constructor that refrences the parent DVD class and
     * @param player Stores the PlayerType
     **********************************************************/
    public Game(PlayerType player) {
        super();
        this.player = player;
    }

    /***********************************************************
     * Returns the player that is selected in the GUI
     * @return Player
     **********************************************************/
    public PlayerType getPlayer() {
        return player;
    }

    /***********************************************************
     * Sets the player that is being used based on the enum class
     * @param player Is the enum choice that is entered and is then
     *               set equal to the player global variable
     **********************************************************/
    public void setPlayer(PlayerType player) {
        this.player = player;
    }


 }