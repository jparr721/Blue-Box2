package blueBox;

/**
 * Created by Jarred on 11/29/16.
 */
public class LinkedListIsEmptyException extends Exception{

    public LinkedListIsEmptyException(String error){
        super(error);
    }

    public LinkedListIsEmptyException() {
        super("ERROR: LIST IS EMPTY");
    }

}
