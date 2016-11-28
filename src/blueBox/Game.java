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
*/

public class Game extends DVD {

    private PlayerType player;   // Xbox 360, PS3, Xbox720.

    public double getCost(GregorianCalendar dat) {
        int compare = dat.compareTo(this.getDueBack());
        return compare < 0 ? 5 : 10;
    }

    public Game() {
        super();
    }

    public Game(GregorianCalendar rentedOn, GregorianCalendar dueBack,
                String title, String name, PlayerType player) {
        super(rentedOn, dueBack, title, name);
        this.player = player;
    }

    public Game(PlayerType player) {
        super();
        this.player = player;
    }

    public PlayerType getPlayer() {
        return player;
    }

    public void setPlayer(PlayerType player) {
        this.player = player;
    }


 }