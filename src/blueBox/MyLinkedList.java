package blueBox;

/**
 * Created by Jarred on 11/7/16.
 */

import java.io.*;

public class MyLinkedList<E> implements LinkedListInterface<E> {

    protected int count;
    protected DoublyLinkedNode<E> head;
    protected DoublyLinkedNode<E> tail;

    public MyLinkedList(){
        head = null;
        tail = null;
        count = 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return size() ==0 ;
    }

    @Override
    public void clear() {
        head = tail = null;
        count = 0;
    }

    @Override
    public void addFirst(E value) {
        head = new DoublyLinkedNode<E>(value, head, null);
        if (tail == null) tail = head;
        count++;
    }

    @Override
    public void addLast(E value) {
        tail = new DoublyLinkedNode<E>(value, null, tail);

        if (head == null) head = tail;
        count++;
    }

    @Override
    public E getFirst() {
        return head.value();
    }

    @Override
    public E getLast() {
        return tail.value();
    }

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


    @Override
    public void add(E value) {
        addFirst(value);
    }

    @Override
    public E remove() {
        return remove(size() - 1);
    }

    @Override
    public E get() {
        return get(0);
    }

    @Override
    public boolean contains(E value) {
        return false;
    }

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
