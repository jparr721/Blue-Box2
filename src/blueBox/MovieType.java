package blueBox;

/**
 * Created by Jarred on 11/9/16.
 */
public enum MovieType {
    AVENGERS("The Avengers"),
    AVENGERS_2("The Avengers 2: Age of Ultron"),
    THE_CONJURING("The Conjuring"),
    THE_CONJURING_2("The Conjuring 2"),
    DOCTOR_STRANGE("Doctor Strange"),
    JARRED_ADVENTURE("The Adventures of Jarred Parr");

    private String movieName;

    MovieType(String movieName) {
        this.movieName = movieName;
    }

    public String movieName() { return movieName; }

    @Override public String toString() { return movieName; }
}
