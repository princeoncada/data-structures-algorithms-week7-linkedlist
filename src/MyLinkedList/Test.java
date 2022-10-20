package MyLinkedList;

public class Test {
    public static void main(String[] args) {
        Student_LNode myNode = new Student_LNode(null);
        myNode.addAtFirst("Prince", 21, "CS");
        myNode.addAtFirst("Shynn", 223, "CS");
        myNode.addAtFirst("JM", 221, "CS");
        myNode.addAtFirst("WTF", 215, "CS");
        myNode.addInMiddle("ako",222,"df");
        myNode.addInMiddle("akod",222,"df");
        myNode.addInMiddle("akods",222,"df");
        myNode.deleteInMiddle();
        myNode.addInMiddle("akods",222,"df");
        myNode.deleteInMiddle();
        System.out.println(myNode.traverse());
        System.out.println(myNode.indexAt("WTF", 215, "CS"));
    }
}
