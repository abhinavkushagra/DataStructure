import java.util.Scanner;

class Node{
    Node left = null;
    int ltag = 0;
    int data;
    int rtag = 0;
    Node right = null;
    Node(int data){
        this.data = data;
    }
}

class Main{
    public static void main(String... args) {
        Node node1 = new Node(1);
        Node node3 = new Node(3);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node11 = new Node(11);
        Node node13 = new Node(13);
        node6.ltag = 1;
        node6.left = node3;
        node6.rtag = 1;
        node6.right = node8;
        node3.ltag = 1;
        node3.left = node1;
        node3.rtag = 5;
        node3.right = node5;
        node1.ltag = 
    }
}