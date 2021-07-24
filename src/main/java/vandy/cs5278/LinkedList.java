package vandy.cs5278;
/* @author Vanderbilt University, copyright 2019 - All rights reserved */

import java.lang.ArrayIndexOutOfBoundsException;
import java.nio.channels.IllegalSelectorException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Provides a generic dynamically-(re)sized array abstraction.
 */
public class LinkedList<T extends Comparable<T>> implements Comparable<LinkedList<T>>, Iterable<T> {

    private int listSize = 0;

    public Node<T> head;

    private T defaultValue;
    /**
     * Constructs an array of the given size.
     *
     * @param size Nonnegative integer size of the desired array.
     * @throws NegativeArraySizeException if the specified size is negative.
     */
    public LinkedList(int size) throws NegativeArraySizeException {
        if (size < 0) {
            throw new NegativeArraySizeException();
        } 
        for (int i = 0; i < size; i++) {
            add(null); // ----------------------
        }
    }

    /**
     * Constructs an array of the given size, filled with the provided
     * default value.
     *
     * @param size         Nonnegative integer size of the desired array.
     * @param defaultValue A default value for the array.
     * @throws NegativeArraySizeException if the specified size is negative.
     */
    public LinkedList(int size, T data) throws NegativeArraySizeException {
        // TODO - you fill in here.
        if(size < 0) {
            throw new NegativeArraySizeException();
        }

        this.defaultValue = data;
        for(int i = 0; i<size; i++){
            add(data);
        }
        this.listSize = size;
    }

    /**
     * Copy constructor; creates a deep copy of the provided array.
     *
     * @param s The array to be copied.
     */
    public LinkedList(LinkedList<T> s) {

        for (int i = 0; i < s.size(); i++) {
            add(s.getNode(i).getData());
        }
        this.listSize = s.listSize;
        this.defaultValue = s.defaultValue;
        
    }

    private void add(T data) {

        if (this.head == null){
            this.head = new Node<T>(data);
        }
        else {
                Node<T> newNode = new Node<T>(data);
                Node<T> tail = getNode(listSize - 1);
                tail.setNext(newNode); //tail.setNext(newNode); 
                newNode.setPrev(tail);
            }
            this.listSize++;
       
    }

    /**
     * @return The current size of the array.
     */
    public int size() {
        return this.listSize;
    }



    private Node<T> getNode(int index) {

        // if (index < 0 || index > this.listSize) {
        //     throw new IndexOutOfBoundsException();
        // }

        if (index == 0) {
            return this.head;
        }

        int currentIndex = 0;
        Node<T> curreNode = this.head;
        while (currentIndex <= index) {
            if(currentIndex == index){
                return curreNode;
            }
            else {
                curreNode = curreNode.getNext();
                currentIndex++;
            }
        }
        return null;

    }

    /**
     * Resizes the array to the requested size.
     * Changes the size of this ListArray to hold the requested number of elements.
     * 
     * See the tests to understand how resize works when an existing array is sized
     * up / down.
     *
     * @param size Nonnegative requested new size.
     */
    public void resize(int size) {

        if (size < 0) {
            throw new NegativeArraySizeException();
        }

        if (size == 0) {
            this.head = null;
        }
        else if (size < this.listSize) {
            Node<T> currentNode = getNode(size);
            currentNode.setPrev(null);

            currentNode = getNode(size - 1);
            currentNode.next = null;
    
        }
        else if (size > this.listSize) {
            for (int i = this.listSize; i < size; i++) {
                // this.listSize++;
                add(this.defaultValue);
            }
        }
        this.listSize = size;
    }
 

    /**
     * @param index Nonnegative index of the requested element.
     * @return the element at the requested index.
     * @throws ArrayIndexOutOfBoundsException If the requested index is outside the current bounds of the array.
     */
    public T get(int index) {
        // TODO - you fill in here (replace null with proper return value).
        checkIndexOutOfBounds(index);
        Node<T> currentNode = getNode(index);
        return currentNode.getData();
        
    }

    /**
     * Sets the element at the requested index with a provided value.
     *
     * @param index Nonnegative index of the requested element.
     * @param value A provided value.
     * @throws ArrayIndexOutOfBoundsException If the requested index is outside the current bounds of the array.
     */
    public void set(int index, T data) {
        // TODO - you fill in here.
        checkIndexOutOfBounds(index);
        Node<T> currentNode = getNode(index);
        currentNode.setData(data); //currentNode.value = data; 
        
    }




    private void checkIndexOutOfBounds(int index) {
        if(index < 0 || index > this.listSize){
            throw new ArrayIndexOutOfBoundsException();
        }
    }


    /**
     * Removes the element at the specified position in this ListArray.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).  Returns the element that was removed from the ListArray.
     *
     * @param index the index of the element to remove
     * @return element that was removed
     * @throws ArrayIndexOutOfBoundsException if the index is out of range.
     */
    public T remove(int index) {
        // TODO - you fill in here (replace null with proper return value.
        checkIndexOutOfBounds(index);

        Node<T> removeNode = getNode(index);

        if (index == 0) {
            Node<T> nextNode = this.head.getNext();
            if (nextNode != null) {
                nextNode.setPrev(null);
            }
            this.head = nextNode;
        }
        else if (index == this.listSize - 1) {
            Node<T> secondLasNode = removeNode.getPrev();
            secondLasNode.setNext(null);
        }
        else {
            Node<T> previousNode = removeNode.getPrev();
            Node<T> nextNode = removeNode.getNext();
            previousNode.setNext(nextNode);
        }
        this.listSize--;
        return removeNode.getData();
    }

    /**
     * Compares this array with another array.
     * This is a requirement of the Comparable interface.  It is used to provide
     * an ordering for ListArray elements.
     *
     * @return a negative value if the provided array is "greater than" this array,
     * zero if the arrays are identical, and a positive value if the
     * provided array is "less than" this array.
     */
    @Override
    public int compareTo(LinkedList<T> s) {
        // TODO - you fill in here (replace 0 with proper return value).

        if(this == s) {
            return 0;
        }

        for (int i = 0; i < this.size() && i < s.size(); i++){
            if (this.get(i) != s.get(i)) {
                char a = this.getNode(i).getData().toString().charAt(0);
                char b = s.getNode(i).getData().toString().charAt(0);
                return a - b;
            }
        }

        if (this.size() == s.size()){
            return 0;
        }
        else
        {
            return this.size() - s.size();
        }
 
    }


    /**
     * Factory method that returns an Iterator.
    */
// public Iterator<T> iterator() { //OG
    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }


    private class Node<T> {
        Node<T> prev;
        Node<T> next;
        T value;
        /**
         * Default constructor (no op).
         */
        Node() {
            this.value = null;
            this.next = null;
            this.prev = null;
        }

        /**
         * Construct a Node from a @a prev Node.
         */
        Node(Node prev) {
            this.prev = prev;
            this.next = null;
            this.value = null;
        }


        Node(T value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }


        /**
         * Construct a Node from a @a value and a @a prev Node.
         */
        Node(T value, Node prev) {
            // TODO - you fill in here.
            this.value = value;
            this.prev = prev;
            this.next = null;
        }

        public T getData(){
            return value;
        }

        public void setData(T dataValue){
            this.value = dataValue;
        }

        public Node<T> getNext(){
            return this.next;
        }

        public void setNext(Node<T> nextValue){
            this.next = nextValue;
        }

        public Node<T> getPrev(){
            return this.prev;
        }

        public void setPrev(Node<T> prevValue){
            this.prev = prevValue;
        }
    }


    /**
     * This class implements an iterator for the list.
     */
    // private class ListIterator implements Iterator<T> {
    private class ListIterator implements Iterator<T> {
        // TODO: Fill in any fields you require.
        // private int currentIndex;
        // private Node currentIndex;
        // private Node<T> currentIndex = head;
        Node<T> currentIndex = head;
        // private Node<T> prev = null;
        private boolean calledNext = true;

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next() {  // OG
            calledNext = false;
        // public Node next() {
            // TODO - you fill in here.
            if(!(hasNext())){
                throw new NoSuchElementException(); 
            }
            // Node<T> currentNode = currentIndex.next;
            // Node<T> tempNode = currentIndex;
            // currentIndex = currentIndex.next;
            // return (T) tempNode;    // temp.value; --------------------------------------- FIX ----------------------------------------
            T data = currentIndex.value;
            currentIndex = currentIndex.next;
            return data;
        }

        /**
         * Removes from the underlying collection the last element returned
         * by this iterator (optional operation).  This method can be called
         * only once per call to {@link #next}.  The behavior of an iterator
         * is unspecified if the underlying collection is modified while the
         * iteration is in progress in any way other than by calling this
         * method.
         *
         * @throws UnsupportedOperationException if the {@code remove} operation is not supported by this iterator
         * @throws IllegalStateException         if the {@code next} method has not
         *                                       yet been called, or the {@code remove} method has already
         *                                       been called after the last call to the {@code next} method
         * @implSpec The default implementation throws an instance of
         * {@link UnsupportedOperationException} and performs no other action.
         */
        @Override
        public void remove() {
            // TODO - you fill in here.
            if(calledNext){
                throw new IllegalStateException();
            } else {
                throw new UnsupportedOperationException("Remove not implemented.");
            }
            //     if (currentIndex != null) {
            //         if (prev != null) {
            //             prev.next = currentIndex.next;
            //         } else {
            //             head = currentIndex.next;
            //         }
            //     }
            }
           
            // throw new UnsupportedOperationException();
            
        
        

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            // TODO - you fill in here.
            // if(currentIndex != null) return true;       // --------------------------------------- FIX -> REMOVE LINKEDLIST ----------------------------------------if(currentIndex.next != null) return true; 

            if (this.currentIndex != null) return true;

            return false;
        }
    }

  

}
