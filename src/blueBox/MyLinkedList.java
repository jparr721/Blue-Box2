package blueBox;

/**
 * Created by Jarred on 11/7/16.
 */

import java.io.*;

public class MyLinkedList<E> implements LinkedListInterface<E>, Serializable {

    /** Variable to keep count of the number of objects in the Linked List **/
    protected int count;

    /** Doubly Linked Node objects **/
    protected DoublyLinkedNode<E> head;
    protected DoublyLinkedNode<E> tail;

    /************************************************************
     * Default constructor to initialize instance variables
     ***********************************************************/
    public MyLinkedList(){
        head = null;
        tail = null;
        count = 0;
    }

    /************************************************************
     * Returns the size of the Linked List
     * @return count
     ***********************************************************/
    @Override
    public int size() {
        return count;
    }

    /************************************************************
     * Checks if the size of the linked list if 0
     * @return true or false
     ***********************************************************/
    @Override
    public boolean isEmpty() {
        return size() ==0 ;
    }

    /************************************************************
     * Clears the Linked List of all values
     ***********************************************************/
    @Override
    public void clear() {
        head = tail = null;
        count = 0;
    }

    /************************************************************
     * Add a value to the beginning of the Linked List
     * @param value specifies what will be placed
     ***********************************************************/
    @Override
    public void addFirst(E value) {
        head = new DoublyLinkedNode<E>(value, head, null);
        if (tail == null) tail = head;
        count++;
    }

    /************************************************************
     * Add a value to the end of the Linked List
     * @param value specifies what will be placed
     ***********************************************************/
    @Override
    public void addLast(E value) {
        tail = new DoublyLinkedNode<E>(value, null, tail);

        if (head == null) head = tail;
        count++;
    }

    /************************************************************
     * Returns the value of the head, or the first value in the
     * Linked List
     * @return Value of the head
     ***********************************************************/
    @Override
    public E getFirst() {
        return head.value();
    }

    /************************************************************
     * Rerturns the value of the tail, or the last value in the
     * Linked List
     * @return Value of the tail
     ***********************************************************/
    @Override
    public E getLast() {
        return tail.value();
    }

    /************************************************************
     * Renmove the first value of the Linked List
     * @return The removed value
     ***********************************************************/
    @Override
    public E removeFirst() {

        if (isEmpty()){
            throw new RuntimeException("List is empty");
        }

        DoublyLinkedNode<E> temp = head;

        head = head.next();
        if (head != null) {
            head.setPrevious(null);
        } else {
            tail = null; //Remove final value
        }
        temp.setNext(null);
        count--;
        return temp.value();
    }

    /************************************************************
     * Remove the last value of the Linked list
     * @return The removed value
     ***********************************************************/
    @Override
    public E removeLast() {
        if (isEmpty())
            throw new RuntimeException("List is empty");


        DoublyLinkedNode<E> temp = tail;
        tail = tail.previous();
        tail.setNext(null);
        count--;
        return temp.value();
    }

    /************************************************************
     * Remove a specified value
     * @param value Specifies which value in the Linked List will
     *              be removed upon invocation of the method
     * @return null
     ***********************************************************/
    @Override
    public E remove(E value) {
        DoublyLinkedNode<E> pointer = head;
        while (pointer != null &&
                !pointer.value().equals(value))
        {
            pointer = pointer.next();
        }
        if (pointer != null)
        {
            // fix next field of element above
            if (pointer.previous() != null)
            {
                pointer.previous().setNext(pointer.next());
            } else {
                head = pointer.next();
            }
            // fix previous field of element below
            if (pointer.next() != null)
            {
                pointer.next().setPrevious(pointer.previous());
            } else {
                tail = pointer.previous();
            }
            count--;            // fewer elements
            return pointer.value();
        }
        return null;
    }

    /************************************************************
     * Add a specified value to the Linked List at the head
     * @param value Specifies what will be added to the Linked
     *              List upon invocation of the method
     ***********************************************************/
    @Override
    public void add(E value) {
        addFirst(value);
    }

    /************************************************************
     * Remove a specified value from the Linked List
     * @return The Linked List that is one increment smaller
     ***********************************************************/
    @Override
    public E remove() {
        return remove(size() - 1);
    }

    /************************************************************
     * Get the first value of the Linked List
     * @return Value at location "0" in the Linked list
     ***********************************************************/
    @Override
    public E get() {
        return get(0);
    }

    /************************************************************
     * Checks if the Linked List contains a specified value
     * @param value Specifies which value will be checked
     * @return false;
     ***********************************************************/
    @Override
    public boolean contains(E value) {
        return false;
    }

    /************************************************************
     * Check the index of an element of the Linked List
     * @param value Specifies which value you want the index of
     *              in the Linked List
     * @return The index of the specified value
     ***********************************************************/
    @Override
    public int indexOf(E value) {
        int i = 0;
        DoublyLinkedNode<E> pointer = head;
        //Search for value or end of the list, counts
        while (pointer != null && !pointer.value().equals(value)){
            pointer = pointer.next();
            i++;
        }
        //Pointer points, with index i
        if (pointer == null){
            return -1;
        } else {
            //Find value, return index
            return i;
        }
    }

    /************************************************************
     * Check the end for the presence of an element of the Linked
     * List
     * @param value Specifies which value you would want the index
     *              of in the Linked List
     * @return The index of the specified value
     ***********************************************************/
    @Override
    public int lastIndexOf(E value) {
        int i = size()-1;
        DoublyLinkedNode<E> pointer = tail;
        // search for last matching value, result is desired index
        while (pointer != null && !pointer.value().equals(value))
        {
            pointer = pointer.previous();
            i--;
        }
        if (pointer == null)
        {   // value not found, return indicator
            return -1;
        } else {
            // value found, return index
            return i;
        }
    }

    /************************************************************
     * Gets the value at a specified location
     * @param i Stores a value in the pointer variable and searches
     *          through the list from there to get the desired value
     * @return The value of the pointer
     ***********************************************************/
    @Override
    public E get(int i) {
        if (i >= size()){
            return null;
        }
        DoublyLinkedNode<E> pointer = head;
        //Search for ith element or end of list
        while (i > 0){
            pointer = pointer.next();
            i--;
        }
        return pointer.value();
    }

    /************************************************************
     * Sets a value at a specified index and places an object
     * there as well
     * @param i Specifies the index to insert the value
     * @param o Specified the Object to be placed it the location
     *          that is specified by parameter i
     * @return the resulting data stored in that location in the
     * Linked Lists
     ***********************************************************/
    @Override
    public E set(int i, E o) {
        if (i >= size()) return null;
        DoublyLinkedNode<E> pointer = head;
        // search for ith element or end of list
        while (i > 0)
        {
            pointer = pointer.next();
            i--;
        }
        // get old value, update new value
        E result = pointer.value();
        pointer.setValue(o);
        return result;
    }

    /************************************************************
     * Add a new value at the specified index
     * @param i Specifies the index to insert the value
     * @param o Specifies the object to be placed in the location
     *          that is specified by parameter i
     ***********************************************************/
    @Override
    public void add(int i, E o) {
        if ((i < 0 || i >= size()))
            throw new IndexOutOfBoundsException();
            //throw error here
        if (i == 0) {
            addFirst(o);
        }
        else if (i == size()) {
            addLast(o);
        } else {
            DoublyLinkedNode<E> before = null;
            DoublyLinkedNode<E> after = head;
            //Search for ith position, or the end of the list
            while (i > 0){
                before = after;
                after = after.next();
                i--;
            }
            //Create new value to place
            DoublyLinkedNode<E> current =
                    new DoublyLinkedNode<E>(o, after, before);
            count++;
            //Point the new values
            before.setNext(current);
            after.setPrevious(current);
        }
    }

    /************************************************************
     * Removes an object of the Linked List at a specified index
     * i
     * @param i Specifies the index
     * @return The value of the pointer, which is where the object
     * we are referencing lies.
     ***********************************************************/
    @Override
    public E remove(int i) {
        if ((i < 0) || (i >= size()))
            throw new IndexOutOfBoundsException();


        if (i == 0) return removeFirst();
        else if (i == size()-1) return removeLast();
        DoublyLinkedNode<E> previous = null;
        DoublyLinkedNode<E> pointer = head;
        // search for value indexed, keep track of previous
        while (i > 0)
        {
            previous = pointer;
            pointer = pointer.next();
            i--;
        }
        previous.setNext(pointer.next());
        pointer.next().setPrevious(previous);
        count--;
        // pointer's value is old value, return it
        return pointer.value();
    }
}
