package MyLinkedList;

public interface StudentLinkedList {
    boolean isEmpty();
    void addAtFirst(String name, int age, String course);
    void addAtLast(String name, int age, String course);
    void addAtPosition(String name, int age, String course, int position);
    void deleteAtFirst();
    void deleteAtLast();
    void deleteAtPosition(int position);
    Student getFirst();
    Student getLast();
    Student getAtPosition(int position);
    int currentSize();
    String traverse();
    void addInMiddle(String name, int age, String course);
    void deleteInMiddle();
    void deleteValue(String name, int age, String course);
    int indexAt(String name, int age, String course);
}
