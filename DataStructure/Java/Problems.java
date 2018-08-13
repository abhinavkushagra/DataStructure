import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
class Problems{
    public static void main(String[] args){
        Tree tree = Tree.createTree();   
        System.out.println("Solution 1 : "+ problem1(tree)); 
        System.out.println("Solution 2 : "+ problem2(tree));
        System.out.println("Solution 3 : "+ problem3(tree, 8));
        System.out.println("Solution 4 : "+ problem4(tree, 1));
        Traversal t = new Traversal();
        t.levelOrderTraversing(tree);
        problem5(tree, 8);
        System.out.println("\nSolution 5 : "+ "Added");
        t.levelOrderTraversing(tree);
        System.out.println("\nSolution 6 : "+ problem6(tree));
        System.out.println("Solution 7 : "+ problem7(tree));
        System.out.println("Solution 8 : " );
        problem8(tree);
        System.out.println("\nSolution 10 : " + problem10(tree));
        System.out.println("Solution 11 : " + problem11(tree));
        System.out.println("Solution 12 : "+ problem12(tree).data);
       // problem13(tree, 14);
        //System.out.println("Solution 13 : ");
        //t.levelOrderTraversing(tree);
        System.out.println("Solution 14 : No. of leaf Nodes = "+ problem14(tree));
        System.out.println("Solution 14 : No. of full Nodes = "+ problem15(tree));
        

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
    public static void problem5(Tree tree, int value){
        //Problem 5: Give an algorithm for inserting an element into binary tree
        Tree temp = new Tree();
        temp.data = value;
        if(tree == null){
            tree = temp;
            return;
        }
        else{
            Queue<Tree> queue = new LinkedList<>();
            queue.add(tree);
            while(!queue.isEmpty()){
                Tree node = queue.poll();
                if(node.left == null){
                    node.left = temp;
                    return;
                }
                else
                    queue.add(node.left);
                if(node.right == null){
                    node.right = temp;
                    return;
                }
                else
                    queue.add(node.right);
            }
        }
    }
    public static int problem6(Tree tree){
        //Problem 6 : Give an algorithm for finding the size of binary tree
        if(tree == null)
            return 0;
        return problem6(tree.left) + problem6(tree.right) + 1;
    } 
    public static int problem7(Tree tree){
        //Problem 7 : Give an algorithm for finding the size of binary tree without recursion
        int count = 1;
        if(tree == null)
            return 0;
        Queue<Tree> queue = new LinkedList<>();
        queue.add(tree);
        while(!queue.isEmpty()){
            Tree temp = queue.poll();
            if(temp.left != null){
                count++;
                queue.add(temp.left);
            }
            if(temp.right != null){
                count++;
                queue.add(temp.right);
            }
        }
        return count;

    }
    public static void problem8(Tree tree){
        //Problem 8 : Give an algorithm for printing the level order data in reverse order
        if(tree == null)
            return;
        List<Integer> nodes = new ArrayList<>();
        Queue<Tree> queue = new LinkedList<>();
        int index = 0;
        queue.add(tree);
        while(!queue.isEmpty()){
            Tree temp = queue.poll();
                nodes.add(temp.data);
            if(temp.right != null)
                queue.add(temp.right);
            if(temp.left != null)
                queue.add(temp.left);
        }
        for(int i = nodes.size() - 1; i >= 0; i--)
            System.out.print(nodes.get(i)+" ");
    }

    public static int problem10(Tree tree){
        //Problem 10 : Give an algorithm for finding the height (or depth) of the binary tree.
        if(tree == null)
            return 0;
        int left = problem10(tree.left) + 1;
        int right = problem10(tree.right) + 1;
        if(left > right)
            return left;
        else
            return right;
    }

    public static int problem11(Tree tree){
        //Problem 11 : Can we solve Problem-10 without recursion?
        int height = 0;
        if(tree == null)
            return height;
        Queue<Tree> queue = new LinkedList<>();
        queue.add(tree);
        while(!queue.isEmpty()){
            int count = queue.size();
            while(count-- != 0){
                Tree temp = queue.poll();
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
            height++;
        }
        return height;
    }

    public static Tree problem12(Tree tree){
        //Problem 12 : Give an algorithm for finding the deepest node of the binary tree
        if(tree == null)
            return null;
        Queue<Tree> queue = new LinkedList<>();
        queue.add(tree);
        Tree temp = null;
        while(!queue.isEmpty()){
            temp = queue.poll();
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }
        return temp;
    }
    public static void problem13(Tree tree, int value){
        //Problem 13 : Give an algorithm for deleting an element(assuming data is given) from binary tree.
        if(tree == null){
            System.out.println("Tree Empty");
            return;
        }
        Queue<Tree> queue = new LinkedList<>();
        queue.add(tree);
        Tree deepestNode = problem12(tree);
        Tree temp = null;
        boolean check = false;
        while(!queue.isEmpty()){
            temp = queue.poll();
            if(temp.data == value){
                check = true;
                break;
            }
            if(temp.left != null){
                queue.add(temp.left);
            }
            if(temp.right != null){
                queue.add(temp.right);
            }
        }
        if(check){
            temp.data = deepestNode.data;
            Tree toBeDeletedNode = null;
            queue.clear();
            queue.add(tree);
            while(!queue.isEmpty()){
                toBeDeletedNode = queue.poll();
                if(toBeDeletedNode.left != null){
                    if(toBeDeletedNode.left == deepestNode){
                        toBeDeletedNode.left = null;
                        System.out.println("Deleted");
                        return;
                    }
                    queue.add(toBeDeletedNode.left);
                }
                if(toBeDeletedNode.right != null){
                    if(toBeDeletedNode.right == deepestNode){
                        toBeDeletedNode.right = null;
                        System.out.println("Deleted");
                        return;
                    }
                    queue.add(toBeDeletedNode.right);
                }

            }

        }
        else
            System.out.println("Node Not FOUND!");
        
        
    }
    public static int problem14(Tree tree){
        //Problem 14 : Give an algorithm for finding the number of leaves in the binary tree without using recursion
        int leaf = 0;
        if(tree == null)
            return leaf;
        Queue<Tree> queue = new LinkedList<>();
        queue.add(tree);
        while(!queue.isEmpty()){
            Tree temp = queue.poll();
            if(temp.left == null && temp.right == null)
                leaf++;
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }
        return leaf;
    }
    public static int problem15(Tree tree){
        //Problem 15 : Give an algorithm for finding the number of full nodes in the binary tree without using recursion
        int fullnode = 0;
        if(tree == null)
            return fullnode;
        Queue<Tree> queue = new LinkedList<>();
        queue.add(tree);
        while(!queue.isEmpty()){
            Tree temp = queue.poll();
            if(temp.left != null && temp.right != null)
                fullnode++;
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }
        return fullnode;
    }
}
