import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
class Traversal{
    public static void main(String[] args){
        Tree tree = Tree.createTree();
        System.out.println("PreOrder Recursion :");
        preOrderRecursion(tree);
        System.out.println("\nPreOrder Iteration :");
        preOrderIteration(tree);
        System.out.println("\nInOrder Recursion :");
        inOrderRecursion(tree);
        System.out.println("\nInOrder Iteration :");
        inOrderIteration(tree);
        System.out.println("\nPostOrder Recursion :");
        postOrderRecursion(tree);
        System.out.println("\nPostOrder Iteration :");
        postOrderIteration(tree);
        System.out.println("\nLevel Order Traversing :");
        levelOrderTraversing(tree);
    }
    private static void preOrderRecursion(Tree tree){
        if(tree == null)
            return;
        System.out.print(tree.data+" ");
        preOrderRecursion(tree.left);
        preOrderRecursion(tree.right);
    }
    private static void preOrderIteration(Tree tree){
        Stack stack = new Stack();
        while(true){
            while(tree != null){
                System.out.print(tree.data+" ");
                stack.push(tree);
                tree = tree.left;
            }
            if(stack.empty())
                break;
            tree = (Tree)stack.pop();
            tree = tree.right;
        }
    }

    private static void inOrderRecursion(Tree tree){
        if(tree == null)
            return;
        inOrderRecursion(tree.left);
        System.out.print(tree.data + " ");
        inOrderRecursion(tree.right);
    }
    private static void inOrderIteration(Tree tree){
        Stack stack = new Stack();
        while(true){
            while(tree != null){
                stack.push(tree);
                tree = tree.left;
            }
            if(stack.empty())
                break;
            tree = (Tree)stack.pop();
            System.out.print(tree.data + " ");
            tree = tree.right;
        }
    }

    private static void postOrderRecursion(Tree tree){
        if(tree == null)
            return;
        postOrderRecursion(tree.left);
        postOrderRecursion(tree.right);
        System.out.print(tree.data + " ");
    }

    private static void postOrderIteration(Tree tree){
        if(tree == null)
            return;
        Stack stack = new Stack();
        Tree current = tree;
        Tree previous = tree;
        while(true){    
            while(current.left != null){
                stack.push(current);
                current = current.left;
            }
            while(current.right == null || current.right == previous ){
                System.out.print(current.data + " ");
                previous = current;
                if(stack.empty())
                    return;
                current = (Tree)stack.pop();
            }
            stack.push(current);
            current = current.right;
        }
    }

    private static  void levelOrderTraversing(Tree tree){
        if(tree == null)
            return;
        Queue<Tree> queue = new LinkedList<>();
        queue.add(tree);
        while(!queue.isEmpty()){
            Tree current = queue.poll();
            System.out.print(current.data + " ");
            if(current.left != null )
                queue.add(current.left);
            if(current.right != null)
                queue.add(current.right);
        }
    }