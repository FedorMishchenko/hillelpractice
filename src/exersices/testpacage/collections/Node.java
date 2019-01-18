package exersices.testpacage.collections;

public class Node {
    private int value;
    private Node head;
    private Node next;

    public Node(int value, Node next) {
        this.head = next;
        this.next = next;
        this.value = value;
    }

    public static Node generateRec(int value) {
        if (value >= 0) {
            return new Node(value, generateRec(value - 1));
        } else {
            return null;
        }
    }

    public static void generateReverseRec(Node node) {
        if (node.value > 0) {
            node.next = new Node(node.value - 1, null);
            generateReverseRec(node.next);
        }
    }

    public static String toString(Node node) {
        if (node == null) {
            return "null";
        } else {
            return "(" + node.value + ")->" + toString(node.next);
        }
    }

    public void add(Node node) {

    }

}

