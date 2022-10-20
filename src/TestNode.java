public class TestNode {
    public static void main(String[] args) {
        LNode node = new LNode();

        node.addAtFirst(12);
        node.addAtFirst(45);
        node.addAtFirst(66666);

        node.addAtLast(9);
        node.addAtLast(2);
        node.addAtLast(34);

        node.addAtPosition(999, 1);
        node.addAtPosition(998, 3);
        node.addAtPosition(997, 3);

        System.out.println(node.traverse());

        node.deleteAtFirst();

        System.out.println(node.traverse());

        node.deleteAtLast();

        System.out.println(node.traverse());

        node.deleteAtPosition(2);

        System.out.println(node.traverse());
        System.out.println(node.currentSize());
    }
}
