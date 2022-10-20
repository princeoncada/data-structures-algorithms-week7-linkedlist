package MyLinkedList;

import javax.swing.*;

public class Student_LNode implements StudentLinkedList{
    private Student student;
    private Student_LNode next;
    private Student_LNode head;

    public Student_LNode(Student student) {
        this.student = student;
        next = head = null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void addAtFirst(String name, int age, String course) {
        Student_LNode newNode = new Student_LNode(new Student(name, age, course));
        if (isEmpty()) {
            newNode.next = null;
        }else {
            newNode.next = head;
        }
        head = newNode;
    }

    @Override
    public void addAtLast(String name, int age, String course) {
        Student_LNode newNode = new Student_LNode(new Student(name, age, course));
        if (isEmpty()) {
            addAtFirst(name, age, course);
        }else {
            Student_LNode link = head;
            while(link.next != null) {
                link = link.next;
            }
            newNode.next = null;
            link.next = newNode;
        }
    }

    @Override
    public void addAtPosition(String name, int age, String course, int position) {
        Student_LNode newNode = new Student_LNode(new Student(name, age, course));
        if (isEmpty() || position == 1) {
            addAtFirst(name, age, course);
        } else if (position < 0 || position > currentSize() + 1) {
            error_message(position + " is NOT valid");
        }else {
            Student_LNode visit, link;
            link = visit = head;
            int ctr = 1;
            while (ctr != position) {
                visit = visit.next;
                ctr++;
            }
            while (link.next != visit) {
                link = link.next;
            }
            newNode.next = visit;
            link.next = newNode;
        }
    }

    @Override
    public void deleteAtFirst() {
        if (isEmpty()) {
            error_message("Deleting Not Allowed. Linked List is empty.");
        }else {
            Student_LNode link = head;
            head = link.next;
        }
    }

    @Override
    public void deleteAtLast() {
        if (isEmpty()) {
            error_message("Deleting Not Allowed. Linked List is empty.");
        }else {
            Student_LNode link, visit;
            link = visit = head;
            while (visit.next != null) {
                visit = visit.next;
            }
            while (link.next != visit) {
                link = link.next;
            }
            link.next = null;
        }
    }

    @Override
    public void deleteAtPosition(int position) {
        if (isEmpty()) {
            error_message("The list empty. Try to add a value");
        } else if (position == 1) {
            deleteAtFirst();
        } else if (position < 0 || position > currentSize()) {
            error_message("Position is NOT valid");
        }else {
            Student_LNode visit, link, pointer;
            visit = link = pointer = head;
            int ctr = 0;
            while (ctr != position-1) {
                visit = visit.next;
                ctr++;
            }
            while (link.next != visit) {
                link = link.next;
            }
            ctr = 0;
            while (ctr != position) {
                pointer = pointer.next;
                ctr++;
            }
            link.next = pointer;
        }
    }

    @Override
    public Student getFirst() {
        return head.student;
    }

    @Override
    public Student getLast() {
        Student_LNode link = head;
        while(link.next != null) {
            link = link.next;
        }return link.student;
    }

    @Override
    public Student getAtPosition(int position) {
        Student_LNode link = head;
        int ctr = 0;
        while (ctr != position - 1) {
            link = link.next;
            ctr++;
        }return link.student;
    }

    @Override
    public int currentSize() {
        int counter = 0;
        if (isEmpty()) {
            System.out.println("empty");
        }else {
            Student_LNode link = head;
            while(link != null) {
                link = link.next;
                counter++;
            }
        }return counter;
    }

    @Override
    public String traverse() {
        if (isEmpty()) {
            return "empty";
        }else {
            String hold = "";
            Student_LNode link = head;
            while (link != null) {
                hold += link.student.getName() + " | " + link.student.getAge() + " | " + link.student.getCourse() + "\n";
                link = link.next;
            }return hold;
        }
    }

    @Override
    public void addInMiddle(String name, int age, String course) {
        addAtPosition(name, age, course, (int) Math.ceil((double) currentSize()/2) + 1);
    }

    @Override
    public void deleteInMiddle() {
        deleteAtPosition((int) Math.ceil((double) currentSize()/2));
    }

    @Override
    public void deleteValue(String name, int age, String course) {
        deleteAtPosition(indexAt(name, age, course));
    }

    @Override
    public int indexAt(String name, int age, String course) {
        Student student = new Student(name, age, course);
        Student_LNode link = head;
        int ctr = 1;
        while(!(link.student.getName().equals(student.getName()) && link.student.getAge() == student.getAge() &&
                link.student.getCourse().equals(student.getCourse()))) {
            ctr++;
            link = link.next;
        }
        return ctr;
    }

    public void error_message(String msg){
        JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
