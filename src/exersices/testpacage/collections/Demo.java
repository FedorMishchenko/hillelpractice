package exersices.testpacage.collections;


public class Demo {
    public static void main(String[] args) {
        Node node = Node.generateRec(9);
        Node node2 = new Node(9,null);
        Node.generateReverseRec(node2);

        Node n = new Node(12,null);
        node2.add(n);

        System.out.println(Node.toString(node));
        System.out.println(Node.toString(node2));
    }
}
