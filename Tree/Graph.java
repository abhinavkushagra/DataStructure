import java.util.Scanner;
import java.util.*;

class Graph{
    private HashMap<Integer, Node> nodeLookUp = new HashMap<Integer, Node>();
    public static class Node{
        private int id;
        LinkedList<Node> adjacent = new LinkedList<Node>();
        private Node(int id){
            this.id = id;
        }
    }
    private void addNode(Node node){
        nodeLookUp.put(node.id, node);
    }

    private Node getNode(int id){
        return nodeLookUp.get(id);
    }

    public static void addEdge(Node source, Node destintion){
        source.adjacent.add(destintion);
    }

    public boolean hasPathDFS(int source, int destintion){
        Node s = getNode(source);
        Node d = getNode(destintion);
        HashSet<Integer> visited = new HashSet<Integer>();
        return hasPathDFS(s, d, visited);
    }
    private boolean hasPathDFS(Node source, Node destintion, HashSet<Integer> visited){
        if(visited.contains(source.id))
            return false;
        visited.add(source.id);
        if(source == destintion)
            return true;
        for(Node child: source.adjacent){
            if(hasPathDFS(child, destintion, visited))
                return true;
        }
        return false;
    }

    public boolean hasPathBFS(int source, int destintion){
        Node s = getNode(source);
        Node d = getNode(destintion);
        LinkedList<Node> nextToVisit = new LinkedList<Node>();
        HashSet<Integer> visited = new HashSet<Integer>();
        return hasPathBFS(s, d, visited, nextToVisit);
    }

    private boolean hasPathBFS(Node source, Node destintion, HashSet<Integer> visited, LinkedList<Node> nextToVisit){
        nextToVisit.add(source);
        while(!nextToVisit.isEmpty()){
            Node node = nextToVisit.remove();
            if(node == destintion)
                return true;
            if(visited.contains(node.id))
                continue;
            visited.add(node.id);

            for(Node child : node.adjacent){
                nextToVisit.add(child);
            }
        }
        return false;
    }

    public static void main(String... args){
        Graph g = new Graph();
        Node A = new Node(1);
        g.addNode(A);
        Node B = new Node(2);
        g.addNode(B);
        Node C = new Node(3);
        g.addNode(C);
        Node D = new Node(4);
        g.addNode(D);
        Node E = new Node(5);
        g.addNode(E);
        Node F = new Node(6);
        g.addNode(F);
        Node G = new Node(7);
        g.addNode(G);
        Node H = new Node(8);
        g.addNode(H);
        g.addEdge(A, B);
        g.addEdge(A, D);
        g.addEdge(B, A);
        g.addEdge(B, E);
        g.addEdge(B, F);
        g.addEdge(C, F);
        g.addEdge(C, H);
        g.addEdge(D, A);
        g.addEdge(D, F);
        g.addEdge(E, B);
        g.addEdge(E, G);
        g.addEdge(F, B);
        g.addEdge(F, C);
        g.addEdge(G, A);
        g.addEdge(G, E);
        g.addEdge(H, C);
        System.out.println(g.hasPathDFS(1, 8));
    }

}