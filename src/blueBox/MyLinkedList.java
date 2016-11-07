package blueBox;

/**
 * Created by Jarred on 11/7/16.
 */
import java.io.*;

public class MyLinkedList<E> implements Serializable
{
    private DNode<E> top;
    public int size;

    public MyLinkedList() {
        top = null;
        size = 0;
    }


}
