public class DoublyListTester {
    public static void main(String[] args) {

        System.out.println("\n/////  Test 01  /////");
        Object[] a1 = { 10, 20, 30, 40 };
        DoublyList h1 = new DoublyList(a1); // Creates a linked list using the values from the array

        Object[] a2 = { 10, 20, 30, 40 };
        DoublyList h2 = new DoublyList(a2); // uses the first constructor: LinkedList(Object [] a)
        h2.forwardprint(); // This should print: 10,20,30,40.

        // inserts Node containing the given element at the given index. Check validity
        // of index.
        h2.insertStart(85);
        h2.forwardprint(); // This should print: 85,10,20,30,40.
        h2.backwardprint(); // This should print: 40,30,20,10,85.

        System.out.println();
        h2.insertEnd(95);
        h2.forwardprint(); // This should print: 85,10,20,95,30,40.
        h2.backwardprint(); // This should print: 40,30,95,20,10,80.

        System.out.println();
        h2.insert(75, 6);
        h2.forwardprint(); // This should print: 85,10,20,95,30,40,75.
        h2.backwardprint(); // This should print: 75,40,30,95,20,10,85.

        System.out.println("\n/////  Test  /////");
        Object[] a3 = { 10, 20, 30, 40, 50, 60, 70 };
        DoublyList h3 = new DoublyList(a3); // uses the first constructor: LinkedList(Object [] a)
        h3.forwardprint(); // This should print: 10,20,30,40,50,60,70.

        /*
         * removes Node at the given index. returns element of the removed node. Check
         * validity of index. return null if index is invalid.
         */
        System.out.println("Removed element: " + h3.delete(0)); // This should print: Removed element: 10
        h3.forwardprint(); // This should print: 20,30,40,50,60,70.
        h3.backwardprint(); // This should print: 70,60,50,40,30,20.
        System.out.println("Removed element: " + h3.delete(3)); // This should print: Removed element: 50
        h3.forwardprint(); // This should print: 20,30,40,60,70.
        h3.backwardprint(); // This should print: 70,60,40,30,20.
        System.out.println("Removed element: " + h3.delete(4)); // This should print: Removed element: 70
        h3.forwardprint(); // This should print: 20,30,40,60.
        h3.backwardprint(); // This should print: 60,40,30,20.

        System.out.println("Removed element: " + h3.deleteStart()); // This should print: Removed element: 70
        h3.forwardprint(); // This should print: 30,40,60.
        h3.backwardprint(); // This should print: 60,40,30.

        System.out.println("Removed element: " + h3.deleteEnd()); // This should print: Removed element: 70
        h3.forwardprint(); // This should print: 20,30,40.
        h3.backwardprint(); // This should print: 40,30,20.

    }

}