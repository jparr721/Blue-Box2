package blueBox;

/**
 * Created by Jarred on 11/6/16.
 */

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Game extends DVD implements Serializable {

    protected GregorianCalendar rentedOn;

    protected GregorianCalendar dueBack;

    protected String title;

    protected String nameOfRenter;

    private PlayerType player;
    private GameType game;

    public double getCost(GregorianCalendar date) {
        double cost = 5;
        return cost;
    }

    public Game() {
        super();
    }

    public Game(GregorianCalendar rentedOn, GregorianCalendar dueBack,
                String title, String name, PlayerType player, GameType game) {

    }

    public Game(PlayerType player, GameType game) {
        super();
        this.player = player;
        this.game = game;
    }

    public PlayerType getPlayer() {
        return player;
    }

    public void setPlayer(PlayerType player) {
        this.player = player;
    }


}