public class SLLTester {

    public static void main(String[] args) {
        SLL list = new SLL();

        Node first = new Node("One");
        Node second = new Node("Two");
        Node third = new Node("Three");
        Node fourth = new Node("Four");
        Node fifth = new Node("Five");
        Node sixth = new Node("Six");

        System.out.println("Added the first node to the list? " + list.addLast(first) + ". data: " + first.getData());
        System.out.println("Added the second node to the list? " + list.addLast(second) + ". data: " + second.getData());
        System.out.println("Added the third node to the list? " + list.addLast(third) + ". data: " + third.getData());
        System.out.println("Added the fourth node to the list? " + list.addLast(fourth) + ". data: " + fourth.getData());
        System.out.println("Added the fifth node to the list? " + list.addLast(fifth) + ". data: " + fifth.getData());
        System.out.println("Added the sixth node to the list? " + list.addLast(sixth) + ". data: " + sixth.getData());
        System.out.println();
        String backwards = list.printBackwardsTo(list.peekFirst().getNext().getNext());
        System.out.printf("The list printed backwards to the third node: %s%n", backwards);
        backwards = list.printBackwardsFrom("Three");
        System.out.printf("%nThe list printed backwards from the third node: %s%n", backwards);
    }
}
