package blueBox;

import java.io.Serializable;

/**
 * Created by Jarred on 11/24/16.
 */
public class Node<E> implements Serializable{

    /** Holds the value of the node **/
    private E value;

    /** Refrence that holds the next and previous nodes **/
    private Node<E> next;
    private Node<E> prev;

    /****************************************************
     * Constructor to initialize the declared variables
     *
     * @param value stores the node value
     **************************************************/
    public Node(E value){
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    /***************************************
     * Sets the value of the node
     * @param value node value
     ***************************************/
    public void setValue(E value){
        this.value = value;
    }

    /***************************************
     * Sets the next node reference
     * @param next The next node
     **************************************/
    public void setNext(Node next){
        this.next = next;
    }

    /***************************************
     * Sets previous node reference
     * @param prev The previous node
     **************************************/
    public void setPrev(Node prev) {
        this.prev = prev;
    }


    public Node<E> getNext() {
        return this.next;
    }

    public Node<E> getPrev() {
        return this.prev;
    }

    public E getValue() { return value; }

}
