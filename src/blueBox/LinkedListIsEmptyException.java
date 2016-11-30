package blueBox;

/**
 * Created by Jarred on 11/29/16.
 */
public class LinkedListIsEmptyException extends Exception{

    /***********************************************************
     * Refrence parent Exception class to handle the error
     * @param error
     **********************************************************/
    public LinkedListIsEmptyException(String error){
        super(error);
    }

    /***********************************************************
     * Error thrown if the list if empty
     **********************************************************/
    public LinkedListIsEmptyException() {
        super("ERROR: LIST IS EMPTY");
    }

}
