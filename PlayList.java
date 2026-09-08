import java.util.*;
class Node{
    String data;
    Node next;
    Node prev;
    Node(String data){
        this.data = data;
        next = null;
        prev = null;
    }
}

public class PlayList {
    Node head;
    void insertAtBeg(String song){
        Node newNode = new Node(song);
        newNode.next = head;
        if(head != null){
            head.prev = newNode;
        }
        head = newNode;
    }
    void insertAtEnd(String song){
        Node newNode = new Node(song);
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }
    void deleteAtBeg(){
        if(head == null){
            System.out.println("The playlist is empty!");
            return;
        }
        if(head.next == null){
            head = null;
            return;
        }
        System.out.println(head.data + " was deleted.");
        head.next.prev = null;
        head = head.next;

    }
    void deleteAtLast(){
        if(head == null){
            System.out.println("The playlist is empty!");
            return;
        }
        if(head.next == null){
            head = null;
            return;
        }
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        System.out.println(temp.next.data + " was deleted.");
        temp.next.prev = null;
        temp.next = null;
    }
    void traverseFrontToLast(){
        if(head == null){
            System.out.println("PlayList is empty!");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("Null");
    }
    void traverseLastToFront(){
        if(head == null){
            System.out.println("PlayList is empty!");
            return;
        }
        Node temp = head;

        while(temp.next != null){
            temp = temp.next;
        }
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.prev;
        }
        System.out.println("Null");
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        PlayList L = new PlayList();

        while (true) {

            System.out.println("\n===== PLAYLIST MENU =====");
            System.out.println("1. Insert song at first position");
            System.out.println("2. Insert song at last position");
            System.out.println("3. Delete song at first position");
            System.out.println("4. Delete song at last position");
            System.out.println("5. Traverse playlist from top to bottom");
            System.out.println("6. Traverse playlist from bottom to top");
            System.out.println("7. Exit");

            System.out.print("Enter your choice (1 to 7): ");
            int choice = sc.nextInt();

            String name;

            switch (choice) {

                case 1:
                    sc.nextLine(); // consume leftover newline
                    System.out.print("Enter the song name to insert: ");
                    name = sc.nextLine();
                    L.insertAtBeg(name);
                    break;

                case 2:
                    sc.nextLine(); // consume leftover newline
                    System.out.print("Enter the song name to insert: ");
                    name = sc.nextLine();
                    L.insertAtEnd(name);
                    break;

                case 3:
                    L.deleteAtBeg();
                    break;

                case 4:
                    L.deleteAtLast();
                    break;

                case 5:
                    L.traverseFrontToLast();
                    break;

                case 6:
                    L.traverseLastToFront();
                    break;

                case 7:
                    System.out.println("Exited playlist.");
                    return;

                default:
                    System.out.println("Invalid choice! Please enter 1 to 7.");
            }
        }
    }
}
