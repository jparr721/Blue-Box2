package blueBox;

/**
 * Created by Jarred on 11/7/16.
 */

import java.io.*;

public class MyLinkedList<E> implements Serializable {

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList(E value) {
        head = null;
        tail = null;
        size = 0;
    }

    public E add(E data) {

        //New head
        Node<E> newHead = new Node<>(data);


        if (head == null){
            head = newHead;
            tail = newHead;
        } else {
            head.setNext(newHead);

            head = newHead;
        }

        //Increase list size
        size++;

        //Return the value at the new head
        return newHead.getValue();
    }

    public E remove(E data) throws LinkedListIsEmptyException{

        /** Node that will be removed **/
        Node<E> remove = null;

        /** Currently selected object, we use this when we look
         * through the list **/
        Node<E> current = tail;

        while (current != null){

            if (current.getValue().equals(data)) {
               //Remove the node and fill the gap
                remove = current;

                if (head == tail) {
                    clear();
                    return current.getValue();
                }

                //Check if previous node is null
                if (remove.getPrev() == null){
                    current.getNext().setPrev(null);
                    tail = current.getNext();
                } else {
                    current.getPrev().setNext(remove.getNext());
                }

                size--;

                return remove.getValue();
            }
            //Go to the next node
            current = current.getNext();
        }

        return null;
    }

    public E get(E data) {

        Node<E> current = tail;

        while (current != null) {

            if (current.getValue().equals(data)) {
                return current.getValue();
            }

            current = current.getNext();
        }
        return null;
    }


    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

}
