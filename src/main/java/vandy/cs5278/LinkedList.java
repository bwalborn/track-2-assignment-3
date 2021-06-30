/* @author Vanderbilt University, copyright 2019 - All rights reserved */
package vandy.cs5278;

import java.lang.ArrayIndexOutOfBoundsException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Provides a generic dynamically-(re)sized array abstraction.
 */
public class LinkedList<T extends Comparable<T>> implements Comparable<LinkedList<T>>, Iterable<T> {
    /**
     * The underlying list of type T.
     */
    // TODO - you fill in here.

    /**
     * The current size of the array.
     */
    // TODO - you fill in here.

    /**
     * Default value for elements in the array.
     */
    // TODO - you fill in here.

    /**
     * Constructs an array of the given size.
     *
     * @param size Nonnegative integer size of the desired array.
     * @throws NegativeArraySizeException if the specified size is negative.
     */
    public LinkedList(int size) throws NegativeArraySizeException {
        // TODO - you fill in here.
    }

    /**
     * Constructs an array of the given size, filled with the provided
     * default value.
     *
     * @param size         Nonnegative integer size of the desired array.
     * @param defaultValue A default value for the array.
     * @throws NegativeArraySizeException if the specified size is negative.
     */
    public LinkedList(int size, T defaultValue) throws NegativeArraySizeException {
        // TODO - you fill in here.
    }

    /**
     * Copy constructor; creates a deep copy of the provided array.
     *
     * @param s The array to be copied.
     */
    public LinkedList(LinkedList<T> s) {
        // TODO - you fill in here.

    }

    /**
     * @return The current size of the array.
     */
    public int size() {
        // TODO - you fill in here (replace 0 with proper return value).
        return 0;
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
        // TODO - you fill in here.
    }

    /**
     * @param index Nonnegative index of the requested element.
     * @return the element at the requested index.
     * @throws ArrayIndexOutOfBoundsException If the requested index is outside the current bounds of the array.
     */
    public T get(int index) {
        // TODO - you fill in here (replace null with proper return value).
        return null;
    }

    /**
     * Sets the element at the requested index with a provided value.
     *
     * @param index Nonnegative index of the requested element.
     * @param value A provided value.
     * @throws ArrayIndexOutOfBoundsException If the requested index is outside the current bounds of the array.
     */
    public void set(int index, T value) {
        // TODO - you fill in here.
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
        return null;
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
        return 0;
    }


    /**
     * Factory method that returns an Iterator.
     */
    public Iterator<T> iterator() {
        // TODO - you fill in here (replace null with proper return value).
        return new ListIterator();
    }

    private class Node {
        // TODO: Fill in any fields you require.

        /**
         * Default constructor (no op).
         */
        Node() {
            // TODO - you fill in here.
        }

        /**
         * Construct a Node from a @a prev Node.
         */
        Node(Node prev) {
            // TODO - you fill in here.
        }

        /**
         * Construct a Node from a @a value and a @a prev Node.
         */
        Node(T value, Node prev) {
            // TODO - you fill in here.
        }
    }

    /**
     * This class implements an iterator for the list.
     */
    private class ListIterator implements Iterator<T> {
        // TODO: Fill in any fields you require.

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next() {
            // TODO - you fill in here.
            return null;
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
        }

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
            return false;
        }
    }
}
