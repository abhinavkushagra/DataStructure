import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

class Node{
    Node left;
    int data;
    Node right;
    Node(int data){
        this.data = data;
    }
}

class Main{
    static TreeMap<Integer, Integer> column_sum = new TreeMap<>();
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.left = node2;
        node1.right = node3;
        node1.left.left = node4;
        node1.left.right = node5;
        node1.right.left = node6;
        node1.right.right = node7;
        node1.left.left.left = null;
        node1.left.right.left = null;
        node1.right.left.left = null;
        node1.right.right.left = null;
        node1.left.left.right = null;
        node1.left.right.right = null;
        node1.right.left.right = null;
        node1.right.right.right = null;
        verticalSum(node1, 0);
        for(Integer x : column_sum.keySet()){
            System.out.println(column_sum.get(x) + " ");
        }
        Node root = problem33("ILILL".toCharArray() , 0);
        printZigZag(root);
    }

    public static Node problem33(char[] node, int index){
        //Problem 33: Given a tree with a special property where leaves are represented with 'L' and internal node with 'I'.
        //Also, asssume that each node has either 0 or 2 children. Given preorder traversal of this tree, construct the tree.
        if(index == node.length)
            return null;
        Node new_node = new Node(node[index]);
        if(node[index] == 'L')  
            return new_node;
        index++;
        new_node.left = problem33(node, index);
        index++;
        new_node.right = problem33(node, index);
        return new_node;
    }

    public static void verticalSum(Node root, int column){
        if(root == null)
            return;
        verticalSum(root.left, column - 1);
        int sum = column_sum.containsKey(column)? column_sum.get(column) : 0;
        column_sum.put(column, sum + root.data);
        verticalSum(root.right, column + 1);
    }
    static void printZigZag(Node root){
        Stack<Node> current = new Stack<Node>();
        Stack<Node> next = new Stack<Node>();
        current.push(root);
        boolean flag = true;
        while(!current.isEmpty()){
            Node node = current.pop();
            Node first_node = !flag ? node.right: node.left;
            Node second_node = flag ? node.right: node.left;  
            System.out.print(((char) node.data) + " ");
            if(first_node != null){
                next.push(first_node);
            }
            if(second_node != null){
                next.push(second_node);
            }
            if(current.isEmpty()){
                Stack<Node> temp = current;
                current = next;
                next = temp;
                next.clear();
                flag = !flag;
            }
        }
    }
    

    static boolean printAncestors(Node root, Node node){
        if(root == null)
            return false;
        if(root.left == node || root.right == node || printAncestors(root.left, node) || printAncestors(root.right, node)){
            System.out.print(root.data + " ");
            return true;
        }
        return false;
    }
    static int findMaxEle(Node root){
        if(root == null)
            return Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        int left = findMaxEle(root.left);
        int right = findMaxEle(root.right);
        max = left > right ? left : right;
        max = max > root.data ? max : root.data;
        return max;
    }

    static boolean searchEle(Node root, int ele){
        if(root == null)
            return false;
        if(root.data == ele)
            return true;
        else{
            if(searchEle(root.left, ele))
                return true;
            if(searchEle(root.right, ele))
                return true;
        }
        return false;
    }

    static void insertEle(Node root, int ele){
        Node node = new Node(ele);
        if(root == null){
            root = node;
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.left != null)
                queue.add(temp.left);
            else{
                temp.left = node;
                return;
            }
            if(temp.right != null)
                queue.add(temp.right);
            else{
                temp.right = node;
                return;
            } 
        }
    }
    static int size(Node root){
        if(root == null)
            return 0;
        return(size(root.left) + size(root.right) + 1 );
    }
    static int sizewr(Node root){
        if(root == null)
            return 0;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        int count = 0;
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            count++;
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right!= null)
                queue.add(temp.right);
        }
        return count;
    }
    static void printRev(Node root){
        if(root == null)
            return;
        Queue<Node> queue = new LinkedList<Node>();
        Stack<Node> stack = new Stack<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.right != null)
                queue.add(temp.right);
            if(temp.left != null)
                queue.add(temp.left);
            stack.push(temp);
        }
        while(!stack.empty()){
            System.out.print(stack.pop().data + " ");
        }
    }
    static int findDeepest(Node root){
        Node prev = null;
        if(root == null)
            return -1;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            prev = queue.poll();
            if(prev.left != null)
                queue.add(prev.left);
            if(prev.right != null)
                queue.add(prev.right);
        }
        return prev.data;
    }

    static int noOfLeaves(Node root){
        Node temp = null;
        int count = 0;
        if(root == null)
            return count;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            temp = queue.poll();
            if(temp.left == null && temp.right == null)
                count++;
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }
        return count;
    }
    static boolean symmetryTree(Node node1, Node node2){
        if(node1 == null && node2 == null)
            return true;
        if(node1 == null || node2 == null)
            return false;
        return (node1.data == node2.data && symmetryTree(node1.left, node2.left) && symmetryTree(node1.right, node2.right));

    }
}