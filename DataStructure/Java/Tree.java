class Tree{
    Tree left;
    int data;
    Tree right;

    public static Tree createTree(){
        Tree node1 = new Tree();
        Tree node2 = new Tree();
        Tree node3 = new Tree();
        Tree node4 = new Tree();
        Tree node5 = new Tree();
        Tree node6 = new Tree();
        Tree node7 = new Tree();
        node1.data = 1;
        node2.data = 2;
        node3.data = 3;
        node4.data = 4;
        node5.data = 5;
        node6.data = 6;
        node7.data = 7;
        node1.left = node2;
        node1.right= node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        return node1;
    }
}

