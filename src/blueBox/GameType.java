package blueBox;

/**
 * Created by Jarred on 11/9/16.
 */
public enum GameType {
    THE_WITCHER("The Witcher 3"),
    CALL_OF_DUTY_AW("Call of Duty: Advanced Warfare"),
    CALL_DUTY_BLOP3("Call of Duty: Black Ops 3"),
    CALL_OF_DUTY_IW("Call of Duty: Infinite Warfare"),
    THE_ELDER_SCROLLS("The Elder Scrolls IV: Skyrim");

    private String game;

    GameType(String game) {
        this.game = game;
    }

    public String GameType() { return game; }

    @Override public String toString() { return game; }

}
