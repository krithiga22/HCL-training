package com.hcl.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class App {

    public static void main(String[] args) {

        // 1. ArrayList: preserves insertion order and allows duplicates
        System.out.println("\n===== ARRAYLIST =====");

        List<String> alumni = new ArrayList<>();

        alumni.add("Arun");
        alumni.add("Priya");
        alumni.add("Kavin");
        alumni.add("Priya");

        System.out.println("Alumni: " + alumni);
        System.out.println("Second alumni: " + alumni.get(1));
        System.out.println("Total entries: " + alumni.size());

        // 2. LinkedList: operations at both ends
        System.out.println("\n===== LINKEDLIST =====");

        LinkedList<String> linkedAlumni = new LinkedList<>();

        linkedAlumni.addFirst("Arun");
        linkedAlumni.addLast("Priya");
        linkedAlumni.addLast("Kavin");

        System.out.println("Linked alumni: " + linkedAlumni);
        System.out.println("Removed first: " + linkedAlumni.removeFirst());
        System.out.println("After removal: " + linkedAlumni);

        // 3. HashSet: unique elements, no guaranteed iteration order
        System.out.println("\n===== HASHSET =====");

        Set<String> skills = new HashSet<>();

        skills.add("Java");
        skills.add("SQL");
        skills.add("Python");
        skills.add("Java");

        System.out.println("Unique skills: " + skills);
        System.out.println("Contains Java: " + skills.contains("Java"));

        // 4. LinkedHashSet: unique elements, insertion order
        System.out.println("\n===== LINKEDHASHSET =====");

        Set<String> orderedSkills = new LinkedHashSet<>();

        orderedSkills.add("Java");
        orderedSkills.add("SQL");
        orderedSkills.add("Python");
        orderedSkills.add("Java");

        System.out.println("Ordered skills: " + orderedSkills);

        // 5. TreeSet: unique elements, sorted order
        System.out.println("\n===== TREESET =====");

        Set<String> sortedAlumni = new TreeSet<>();

        sortedAlumni.add("Priya");
        sortedAlumni.add("Arun");
        sortedAlumni.add("Kavin");
        sortedAlumni.add("Arun");

        System.out.println("Sorted alumni: " + sortedAlumni);

        // 6. ArrayDeque: FIFO queue
        System.out.println("\n===== ARRAYDEQUE =====");

        Queue<String> mentorshipRequests = new ArrayDeque<>();

        mentorshipRequests.offer("Request A");
        mentorshipRequests.offer("Request B");
        mentorshipRequests.offer("Request C");

        System.out.println("Next request: " + mentorshipRequests.peek());
        System.out.println("Processed: " + mentorshipRequests.poll());
        System.out.println("Remaining requests: " + mentorshipRequests);

        // 7. PriorityQueue: smallest number has highest priority by default
        System.out.println("\n===== PRIORITYQUEUE =====");

        Queue<Integer> priorities = new PriorityQueue<>();

        priorities.offer(3);
        priorities.offer(1);
        priorities.offer(2);

        while (!priorities.isEmpty()) {
            System.out.println("Processed priority: " + priorities.poll());
        }

        // 8. Enhanced for loop: read each element
        System.out.println("\n===== FOR-EACH LOOP =====");

        for (String name : alumni) {
            System.out.println(name);
        }

        // 9. Iterator: safe removal during traversal
        System.out.println("\n===== ITERATOR REMOVE =====");

        List<String> iteratorAlumni =
                new ArrayList<>(List.of("Arun", "Priya", "Kavin", "Priya"));

        Iterator<String> iterator = iteratorAlumni.iterator();

        while (iterator.hasNext()) {
            String name = iterator.next();

            if (name.equals("Priya")) {
                iterator.remove();
            }
        }

        System.out.println("After removing Priya: " + iteratorAlumni);

        // 10. ListIterator: update and insert elements
        System.out.println("\n===== LISTITERATOR =====");

        List<String> editableAlumni =
                new ArrayList<>(List.of("Arun", "Priya", "Kavin"));

        ListIterator<String> listIterator = editableAlumni.listIterator();

        while (listIterator.hasNext()) {
            String name = listIterator.next();

            if (name.equals("Priya")) {
                listIterator.set("Priya B");
                listIterator.add("New Alumni");
            }
        }

        System.out.println("Updated alumni: " + editableAlumni);

        // ListIterator also supports backward traversal
        System.out.println("Backward traversal:");

        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

        // 11. ConcurrentModificationException demonstration
        System.out.println("\n===== CONCURRENT MODIFICATION =====");

        List<String> unsafeAlumni =
                new ArrayList<>(List.of("Arun", "Priya", "Kavin"));

        try {
            for (String name : unsafeAlumni) {
                if (name.equals("Priya")) {
                    unsafeAlumni.remove(name);
                }
            }
        } catch (ConcurrentModificationException exception) {
            System.out.println("Exception caught: " +
                    exception.getClass().getSimpleName());
        }

        // 12. Correct alternative using removeIf
        System.out.println("\n===== SAFE REMOVAL WITH REMOVEIF =====");

        List<String> safeAlumni =
                new ArrayList<>(List.of("Arun", "Priya", "Kavin"));

        safeAlumni.removeIf(name -> name.equals("Priya"));

        System.out.println("After safe removal: " + safeAlumni);

        System.out.println("\n===== PROGRAM COMPLETED =====");
    }
}