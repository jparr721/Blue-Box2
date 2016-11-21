package blueBox;

/**
 * Created by Jarred on 11/7/16.
 */
public enum PlayerType {
    Xbox360("Xbox 360"),
    PS4("Playstation 4"),
    XBoxOne("Xbox One"),
    WiiU("Wii - U"),
    PS3("Playstation 3"),
    Wii("Nintendo Wii");

    private String console;

    PlayerType(String console) { this.console = console; }

    public String PlayerType() { return console; }

    @Override public String toString() { return console; }
}