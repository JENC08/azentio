
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class FloydCycleDetection {
   
    public static boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false; 

        Node tortoise = head;
        Node hare = head; 

        while (hare.next != null && hare.next.next != null) {
            tortoise = tortoise.next; 
            hare = hare.next.next; 

            if (tortoise == hare) {
                return true;
            }
        }

        return false; 

    public static void main(String[] args) {x
        
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; 

        System.out.println("Does the linked list contain a cycle? " + hasCycle(node1)); 

       
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node5.next = node6;
        node6.next = node7;

        System.out.println("Does the linked list contain a cycle? " + hasCycle(node5)); 
    }
}




import java.util.*;

class Graph {
    private int vertices; // Number of vertices
    private LinkedList<Integer>[] adjacencyList; // Adjacency list

    // Constructor
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Add an edge to the graph
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
    }

    // BFS algorithm
    public void bfs(int startVertex) {
        boolean[] visited = new boolean[vertices]; // Track visited vertices
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS

        // Start with the given vertex
        visited[startVertex] = true;
        queue.add(startVertex);

        System.out.println("BFS traversal starting from vertex " + startVertex + ":");

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            // Visit all adjacent vertices
            for (int neighbor : adjacencyList[currentVertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}

public class BFS {
    public static void main(String[] args) {
        Graph graph = new Graph(6); // Create a graph with 6 vertices

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        // Perform BFS traversal
        graph.bfs(0); // Start BFS from vertex 0
    }
}



import java.util.*;

class Graph {
    private int vertices; // Number of vertices
    private LinkedList<Integer>[] adjacencyList; // Adjacency list

    // Constructor
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Add an edge to the graph
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
    }

    // BFS algorithm
    public void bfs(int startVertex) {
        boolean[] visited = new boolean[vertices]; // Track visited vertices
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS

        // Start with the given vertex
        visited[startVertex] = true;
        queue.add(startVertex);

        System.out.println("BFS traversal starting from vertex " + startVertex + ":");

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            // Visit all adjacent vertices
            for (int neighbor : adjacencyList[currentVertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}

public class BFS {
    public static void main(String[] args) {
        Graph graph = new Graph(6); // Create a graph with 6 vertices

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        // Perform BFS traversal
        graph.bfs(0); // Start BFS from vertex 0
    }
}





class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Tree {
    static class TreeInfo {
        int height;
        int diameter;

        public TreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    // Recursive function to calculate the diameter of the tree
    public static TreeInfo calculateDiameter(TreeNode root) {
        if (root == null) {
            return new TreeInfo(0, 0); // Base case: height and diameter are 0
        }

        // Recursively calculate the height and diameter of the left and right subtrees
        TreeInfo leftInfo = calculateDiameter(root.left);
        TreeInfo rightInfo = calculateDiameter(root.right);

        // Height of the current node
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        // Diameter of the current node
        int diameter = Math.max(leftInfo.diameter, Math.max(rightInfo.diameter, leftInfo.height + rightInfo.height));

        return new TreeInfo(height, diameter);
    }

    public static int getDiameter(TreeNode root) {
        return calculateDiameter(root).diameter;
    }
}

public class TreeDiameter {
    public static void main(String[] args) {
        // Create a sample tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);

        // Find and print the diameter of the tree
        System.out.println("The diameter of the tree is: " + Tree.getDiameter(root));
    }
}



