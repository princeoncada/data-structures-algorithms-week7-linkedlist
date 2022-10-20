import javax.swing.*;

/**
 * LinkedList is an algorithm that stores data dynamically as it uses memory address. Storing may happen at the beginning,
 * in the middle, and at the last. Same goes to deletion. It does NOT store the data in sequential manner, instead it uses
 * the Node(data, address) that link between them to forming a chain or link list.
 * @author Prince Oncada
 */

public class LNode {
    private Object data;
    private LNode next;
    private LNode head;

    public LNode() {
        next=head=null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addAtFirst(Object value) {
        LNode newNode = new LNode();
        if (isEmpty()) {
            newNode.data = value;
            newNode.next = null;
            head = newNode;
        }else {
            newNode.data = value;
            newNode.next = head;
            head = newNode;
        }
    }

    public void addAtLast(Object value) {
        if (isEmpty()) {
           addAtFirst(value);
        }else {
            LNode link = head;
            while(link.next != null) {
                link = link.next;
            }
            LNode newNode = new LNode();
            newNode.data = value;
            newNode.next = null;
            link.next = newNode;
        }
    }

    public void addAtPosition(Object value, int position) {
        if(isEmpty()) {
            error_message("List is EMPTY. Node is added at the Beginning");
            addAtFirst(value);
        }else if(position == 1) {
            addAtFirst(value);
        }else if(position < 0 || position > currentSize() + 1) {
            error_message(position + " is NOT valid");
        }else {
            LNode visit, link;
            link = visit = head;
            int ctr = 1;
            while (ctr != position) {
                visit = visit.next;
                ctr++;
            }
            while (link.next != visit){
                link = link.next;
            }
            LNode newNode = new LNode();
            newNode.data = value;
            newNode.next = visit;
            link.next = newNode;

        }
    }

    public void deleteAtFirst() {
        if (isEmpty()) {
            error_message("Deleting Not Allowed. Linked List is empty.");
        }else {
            LNode link = head;
            head = link.next;
            System.out.println("Deleting is Successful!");
        }
    }

    public void deleteAtLast() {
        if (isEmpty()) {
            error_message("Deleting Not Allowed. Linked List is empty.");
        }else {
            LNode link, visit;
            link = visit = head;
            while (visit.next != null) {
                visit = visit.next;
            }
            while (link.next != visit) {
                link = link.next;
            }
            link.next = null;
            System.out.println("Deleting is Successful");
        }
    }

    public void deleteAtPosition(int position) {
        if (isEmpty()) {
            error_message("The list empty. Try to add a value");
        } else if (position == 1) {
            deleteAtFirst();
        } else if (position < 0 || position > currentSize()) {
            error_message("Position is NOT valid");
        }else {
            LNode visit, link, pointer;
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

    public Object getFirst() {
        return head.data;
    }

    public Object getLast() {
        LNode link = head;
        while(link.next != null) {
            link = link.next;
        }return link.data;
    }

    public Object get(int position) {
        LNode link = head;
        int ctr = 0;
        while (ctr != position - 1) {
            link = link.next;
            ctr++;
        }return link.data;
    }

    public int currentSize() {
        int counter = 1;
        if (isEmpty()) {
            System.out.println("empty");
        }else {
            LNode link = head;
            while(link.next != null) {
                link = link.next;
                counter++;
            }
        }return counter;
    }

    public String traverse1() {
        if (isEmpty()) {
            return "List is empty";
        }else {
            String hold = "";
            LNode link = head;
            while (link != null) {
                hold += "|" + link.data + "|" + link.next + "|\n";
                link = link.next;
            }return "head Node|" + head + "\n" + hold;
        }
    }

    public String traverse() {
        if (isEmpty()) {
            return "empty";
        }else {
            String hold = "";
            LNode link = head;
            while (link != null) {
                hold += link.data + " > ";
                link = link.next;
            }return hold;
        }
    }

    public void addInMiddle(Object value) {
        addAtPosition(value, currentSize()/2);
    }

    public void deleteInMiddle() {
        deleteAtPosition(currentSize()/2);
    }

    public void error_message(String msg){
        JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
