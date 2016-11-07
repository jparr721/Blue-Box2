package blueBox;

/**
 * Created by Jarred on 11/6/16.
 */

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Game extends DVD {

    private PlayerType player;   // Xbox 360, PS3, Xbox720.

    public double getCost(GregorianCalendar dat) {
        double cost = 5;
        return cost;
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