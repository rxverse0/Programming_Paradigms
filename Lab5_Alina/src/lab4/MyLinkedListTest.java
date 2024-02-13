package lab4;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {
    @Test
    void testRemoveFromEmptyList() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        assertThrows(NoSuchElementException.class, () -> myLinkedList.remove());
    }

    @Test
    void addingIntegers() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        assertEquals(1, myLinkedList.get(0));
        assertEquals(2, myLinkedList.get(1));
        assertEquals(3, myLinkedList.get(2));
    }

    @Test
    void getOutOfBounds() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        assertThrows(IndexOutOfBoundsException.class, () -> myLinkedList.get(4));
    }


// Added  test cases cover adding and removing elements at specific indices
// in the linked list in addition to the existing test cases.

    @Test
    void testAddAtIndex() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("A");
        myLinkedList.add("B");
        myLinkedList.add("D");
        myLinkedList.add("E");
        myLinkedList.add("F", 2);  // Add "F" at index 2
        assertEquals("A", myLinkedList.get(0));
        assertEquals("B", myLinkedList.get(1));
        assertEquals("F", myLinkedList.get(2));
        assertEquals("D", myLinkedList.get(3));
        assertEquals("E", myLinkedList.get(4));
    }

    @Test
    void testRemoveAtIndex() {
        MyLinkedList<Double> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1.1);
        myLinkedList.add(2.2);
        myLinkedList.add(3.3);
        myLinkedList.add(4.4);
        double removed = myLinkedList.remove(1);  // Remove element at index 1
        assertEquals(2.2, removed);
        assertEquals(1.1, myLinkedList.get(0));
        assertEquals(3.3, myLinkedList.get(1));
        assertEquals(4.4, myLinkedList.get(2));
    }

}