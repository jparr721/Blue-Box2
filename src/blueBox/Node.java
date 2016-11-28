package blueBox;

import java.io.Serializable;

/**
 * Created by Jarred on 11/24/16.
 */
public class Node<E> implements Serializable{

    private E value;
    private Node<E> next;


    public Node(E value){
        this.value = value;
        this.next = null;
    }

    public void setValue(E value){
        this.value = value;
    }

    public void setNext(Node next){ this.next = next; }

    public Node getNext() {
        return this.next;
    }

    public E getValue() { return value; }

}
