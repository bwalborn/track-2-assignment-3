# CS 5278: Intermediate Software Design
## Programming Assignment 2 - LinkedList

### Overview of the CharArray Assignment

The purpose of this assignment is to give you experience using your IDE to develop a generic Java LinkedList class.  A List is an abstract data type (ADT) with operations such as get(), set(), size(), and iterator(). Your task is to implement a generic List ADT in Java using a LinkedList. You should NOT rely on any existing LinkedList implementation in Java, but should instead create your own.  
 
You are also going to have to implement the following capabilities on your class:  
* Implement the requirements of the <a href="http://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html">Iterable</a> interface.

As much as possible, you should avoid using loops in this assignment. Wherever possible, you should use Java Streams and/or recursion. You must implement the array using an underlying doubly-linked list as the primary data structure.  The starter code gives you a good structure for this approach.

The following resources may be helpful in completing this assignment:

* [Java For Each Loops](https://docs.oracle.com/javase/1.5.0/docs/guide/language/foreach.html)
* [The Oracle Java Generics Tutorial](http://docs.oracle.com/javase/tutorial/java/generics)

### Skeleton Code

This repository contains all of the starter code you need to get going.  Look carefully over the provided, especially at the TODO comments.
Also look very closely at the automated tests that are executed against your class.  Your class must successfully pass of the provided tests without having to alter the tests. 

### Additional Test Development ###

We also want you to start developing your own testing code.  Use the provided test skeletons in the testing file to define an additional set of tests that fully cover the expected behavior of the ```remove()``` method. 

### Concluding Remarks

This assignment is intentionally designed to be easy to help you get
familiar with installing/using your IDE and Java.  If you find it
extremely hard to complete this assignment you may not be ready to
take this class.  If this is the case, please meet with the instructors ASAP to
discuss.

### REMINDERS:

* Only alter project files that you are explicitly permitted to.

* For full credit, your program must compile with a recent version of the `jdk` and pass all of the tests.

* Your program(s) should always have an exit code of 0.  A non-zero exit code (generally indicative of a segmentation fault or some other system error) is reason to worry and must be corrected for full points.
  
* When submitting the assignment, all files that are provided to you, plus your solution files have been submitted. All files necessary to compile and run your program must reside in the GitHub.com repository. 
