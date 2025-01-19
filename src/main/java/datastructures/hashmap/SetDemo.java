package datastructures.hashmap;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {


    public static void main(String[] args) {

        // Create a set using HashSet
        Set<Integer> mySet = new HashSet<>();

// Add elements to the set
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);
        mySet.add(4);
        mySet.add(5);
// Add an element to a set
// If the number 6 is already in the set, it will not be added again.
        boolean add1 = mySet.add(6);
        boolean add2 = mySet.add(6);

        boolean contains = mySet.contains(2);

// Removing an element from a set
        mySet.remove(3);

// Union of two sets
        Set<Integer> otherSet = new HashSet<>();
        otherSet.add(3);
        otherSet.add(4);
        otherSet.add(5);
        otherSet.add(6);

        Set<Integer> unionSet = new HashSet<>(mySet);
        unionSet.addAll(otherSet);

        // Intersection of two sets
        Set<Integer> intersectionSet = new HashSet<>(mySet);
        intersectionSet.retainAll(otherSet);

        // Difference between two sets
        Set<Integer> differenceSet = new HashSet<>(mySet);
        differenceSet.removeAll(otherSet);

// Checking if an element is in a set
        if (mySet.contains("hello")) {
            System.out.println("Found hello in mySet");
        }

    }
}
