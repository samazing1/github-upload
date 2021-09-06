
package LinkedInventoryManagement.test;
//Samuel Osezua SOO190000

import LinkedInventoryManagement.InventoryLinkedList;

import static org.junit.Assert.assertTrue;

public class Test {




    @org.junit.Test
    public void LinkedInventoryManagementContainsTest() {

        InventoryLinkedList<Integer> test = new InventoryLinkedList<>();
        test.add(1);
        test.add(2);
        test.add(3);

        boolean value = test.contains(2);

        if (value == true) {
            assertTrue("present", true);
        } else {
            assertTrue("absent", false);
        }



    }



    @org.junit.Test
    public void LinkedInventoryManagementGetFirstTest() {

        InventoryLinkedList<Integer> test = new InventoryLinkedList<>();
        test.add(1);
        test.add(2);
        test.add(3);

         int value = test.getFirst();

        if (value == 1) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }



    }

    @org.junit.Test
    public void LinkedInventoryManagementGetLastTest() {

        InventoryLinkedList<Integer> test = new InventoryLinkedList<>();
        test.add(1);
        test.add(2);
        test.add(3);

        int value = test.getLast();

        if (value == 3) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }



    }


    @org.junit.Test
    public void LinkedInventoryManagementInsertTest() {

        InventoryLinkedList<Integer> test = new InventoryLinkedList<>();
        test.add(1);
        test.add(2);
        test.add(3);

        test.insert(1,5);

        int value = test.getNodeVal(1);

        if (value == 5) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }



    }


    @org.junit.Test
    public void LinkedInventoryManagementRemoveTest() {

        InventoryLinkedList<Integer> test = new InventoryLinkedList<>();
        test.add(1);
        test.add(2);
        test.add(3);

        test.remove(1);

        if (test.getLength() == 2) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }


    }


    @org.junit.Test
    public void LinkedInventoryManagementSetElementTest() {

        InventoryLinkedList<Integer> test = new InventoryLinkedList<>();
        test.add(1);
        test.add(2);
        test.add(3);

        int value = test.setElement(1, 6);

        if (value == 6) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }


    }


    @org.junit.Test
    public void LinkedInventoryManagementGetElementTest() {

        InventoryLinkedList<Integer> test = new InventoryLinkedList<>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);

        //get Element
        int value = test.getNodeVal(2);

        if (value == 3) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }


    }





}