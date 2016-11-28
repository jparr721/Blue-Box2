package blueBox;

/**
 * Created by Jarred on 11/7/16.
 */

import java.io.*;

public class MyLinkedList<E> implements Serializable {

    private Node head;
    private int size;

    public MyLinkedList(E value) {
        head = null;
        size = 0;
    }

    public E add(E data) {

        //New head
        Node<E> newHead = new Node<>(data);


        if (head == null){
            head = newHead;
        } else {
            head.setNext(newHead);

            head = newHead;
        }

        //Increase list size
        size++;

        //Return the value at the new head
        return newHead.getValue();
    }


    public void clear() {
        head = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

}
