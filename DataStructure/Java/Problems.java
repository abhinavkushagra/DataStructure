import java.util.Queue;
import java.util.LinkedList;
class Problems{
    public static void main(String[] args){
        Tree tree = Tree.createTree();   
        System.out.println("Solution 1 : "+ problem1(tree)); 
        System.out.println("Solution 2 : "+ problem2(tree));
        System.out.println("Solution 3 : "+ problem3(tree, 8));
        System.out.println("Solution 4 : "+ problem4(tree, 1));

    }

    public static int problem1(Tree tree){
        //Problem 1: Give an algorithm for finding maximum element in binary tree;
        int max = Integer.MIN_VALUE;
        if(tree != null){
            int root = tree.data;
            int left = problem1(tree.left);
            int right = problem1(tree.right);
            max = Math.max(max, Math.max(root, Math.max(left, right)));
        }
        return max;
    }

    public static int problem2(Tree tree){
        //Problem 2: Give an algorithm for finding maximum element in binary tree without recursion;
        int max = Integer.MIN_VALUE;
        if(tree != null){
            Queue<Tree> queue = new LinkedList<Tree>();
            queue.add(tree);
            while(!queue.isEmpty()){
                Tree node = queue.poll();
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
                if(node.data > max)
                    max = node.data;
            }
        }
        return max;
    }

    public static boolean problem3(Tree tree, int value){
        //Problem 3: Give an algorithm for searching an element in binary tree.
        boolean search = false;
        if(tree != null){
            int node = tree.data;
            if(node == value)
                search = true;
            else{
                search = problem3(tree.left, value);
                if(search == true)
                    return true;
                else
                    search = problem3(tree.right, value);
            }
        }
        return search;
    }

    public static boolean problem4(Tree tree,int value){
        //Problem 4: Give an algorithm for searching an element in binary tree without recursion.
        if(tree != null){
            Queue<Tree> queue = new LinkedList<>();
            queue.add(tree);
            while(!queue.isEmpty()){
                Tree node = queue.poll();
                if(node.data == value)
                    return true;
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            } 
        }
        return false;
    }
}