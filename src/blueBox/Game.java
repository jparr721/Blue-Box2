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
 *******************************************************/
public class Game extends DVD implements Serializable {

    /** Creating Object of type PlayerType **/
    private PlayerType player;

    /** Creating Object of type GameType **/
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
        super();
        this.rentedOn = rentedOn;
        this.dueBack = dueBack;
        this.title = title;
        this.nameOfRenter = name;
        this.game = game;
        this.player = player;

    }

    public GregorianCalendar getRentedOn() { return rentedOn; }
    public void setRentedOn(GregorianCalendar rentedOn) { this.rentedOn = rentedOn; }
    public GregorianCalendar getDueBack() { return dueBack; }
    public void setDueBack(GregorianCalendar dueBack) { this.dueBack = dueBack; }

    public GameType getGameTitle() { return game; }
    public void setGameTitle(GameType game) { this.game = game; }

    public PlayerType getPlayer() {
        return player;
    }
    public void setPlayer(PlayerType player) {
        this.player = player;
    }

    public String getNameOfRenter() { return nameOfRenter; }
    public void setNameOfRenter(String nameOfRenter) { this.nameOfRenter = nameOfRenter; }


}