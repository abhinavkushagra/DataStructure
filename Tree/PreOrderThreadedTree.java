
class Node{
    Node left = null;
    int ltag = 0;
    int data;
    int rtag = 0;
    Node right = null;
    Node(){

    }
    Node(int data){
        this.data = data;
    }
}

class Main{
    public static void main(String... args) {
        Node head = new Node();
        Node node1 = new Node(1);
        Node node3 = new Node(3);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node11 = new Node(11);
        Node node13 = new Node(13);
        head.ltag = 1;
        head.left = node6;
        head.rtag = 1;
        head.right = head;
        node6.ltag = 1;
        node6.left = node3;
        node6.rtag = 1;
        node6.right = node8;
        node3.ltag = 1;
        node3.left = node1;
        node3.rtag = 1;
        node3.right = node5;
        node1.ltag = 0;
        node1.left = node3;
        node1.rtag = 0;
        node1.right = node5;
        node5.ltag = 0;
        node5.left = node1;
        node5.rtag = 0;
        node5.right = node8;
        node8.ltag = 1;
        node8.left = node7;
        node8.rtag = 1;
        node8.right = node11;
        node7.ltag = 0;
        node7.left = node8;
        node7.rtag = 0;
        node7.right = node11;
        node11.ltag = 1;
        node11.left = node9;
        node11.rtag = 1;
        node11.right = node13;
        node9.ltag = 0;
        node9.left = node11;
        node9.rtag = 0;
        node9.right = node13;
        node13.ltag = 0;
        node13.left = node9;
        node13.rtag = 0;
        node13.right = head;
        preorderTraversal(head);
    }

    public static Node preorderSuccessor(Node node){
        Node temp;
        if(node.ltag == 1)
            return node.left;
        else{
            temp = node;
            while(temp.rtag == 0){
                node = temp.right;
            }
            return temp.right; 
        }
    }
    
    public static void preorderTraversal(Node root){
        Node temp = preorderSuccessor(root);
        while(temp != root){
            temp = preorderSuccessor(temp);
            System.out.print(temp.data + "->");
        }
    }
}