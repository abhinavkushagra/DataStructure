import java.util.Stack;
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
}