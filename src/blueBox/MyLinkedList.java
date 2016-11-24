package blueBox;

/**
 * Created by Jarred on 11/7/16.
 */
import javax.xml.soap.Node;
import java.io.*;

public class MyLinkedList implements Serializable {

    private Node head;
    public int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public void add(Object data) {

        Node temp = new Node(data);
        Node curr = head;

        if (head == null) {
            head = temp;
        } else {
            while (curr.getNext() != null){
                curr = curr.getNext();
            }
        }

    }

}
