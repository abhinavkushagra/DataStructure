import java.util.Scanner;

class Node{
    int data;
    Node f_child;
    Node n_sibling;
    Node(int data){
        this.data = data;
        this.f_child = null;
        this.n_sibling = null;
    }
}
class Main{
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        Node node13 = new Node(13);
        Node node14 = new Node(14);
        node1.f_child = node2;
        node2.n_sibling = node3;
        node3.n_sibling = node4;
        node4.f_child = node8;
        node4.n_sibling = node5;
        node5.f_child = node9;
        node5.n_sibling = node6;
        node6.f_child = node11;
        node6.n_sibling = node7;
        node7.f_child = node14;
        node9.n_sibling = node10;
        node11.n_sibling = node12;
        node12.n_sibling = node13;
        System.out.println("\n"+problem36(node1));
    }

    public static int problem36(Node root){
        //Given a tree, give an algorithm for finding the sum of all the elements of the tree
        if(root == null){
            return 0;
        }
        System.out.print(root.data + "+");
        return root.data + problem36(root.f_child) + problem36(root.n_sibling);
    }

}