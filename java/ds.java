
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
        Graph graph = new Graph(6); 

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        
        graph.bfs(0);
    }
}



import java.util.*;

class Graph {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

  
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

   
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
    }

   
    public void bfs(int startVertex) {
        Queue<Integer> queue = new LinkedList<>(); 

      
        visited[startVertex] = true;
        queue.add(startVertex);

        System.out.println("BFS traversal starting from vertex " + startVertex + ":");

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

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
        Graph graph = new Graph(6); 

       
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        graph.bfs(0);
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

    
    public static TreeInfo calculateDiameter(TreeNode root) {
        if (root == null) {
            return new TreeInfo(0, 0); 
        }

        
        TreeInfo leftInfo = calculateDiameter(root.left);
        TreeInfo rightInfo = calculateDiameter(root.right);

      
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

  
        int diameter = Math.max(leftInfo.diameter, Math.max(rightInfo.diameter, leftInfo.height + rightInfo.height));

        return new TreeInfo(height, diameter);
    }

    public static int getDiameter(TreeNode root) {
        return calculateDiameter(root).diameter;
    }
}

public class TreeDiameter {
    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);

        
        System.out.println("The diameter of the tree is: " + Tree.getDiameter(root));
    }
}


 Evaluate Reverse Polish Notation

     class Solution {
    long resolves(long a, long b, char Operator) {
        if (Operator == '+')
            return a + b;
        else if (Operator == '-')
            return a - b;
        else if (Operator == '*')
            return a * b;
        return a / b;
    }

    public int evalRPN(String[] tokens) {
        Stack<Long> stack = new Stack<>();
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            if (tokens[i].length() == 1 && tokens[i].charAt(0) < 48) {
                long integer2 = stack.pop();
                long integer1 = stack.pop();
                char operator = tokens[i].charAt(0);
                long resolvedAns = resolves(integer1, integer2, operator);
                stack.push(resolvedAns);
            } else {
                stack.push(Long.parseLong(tokens[i]));
            }
        }
        return stack.pop().intValue();
    }
}


         Largest Rectangle in Histogram

             import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int height = heights[stack.pop()];
            int width = heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}

    25. Reverse Nodes in k-Group

        class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, curr = head;

        
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

       
        while (count >= k) {
            curr = prev.next;
            ListNode next = curr.next;


            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }

            prev = curr;
            count -= k;
        }

        return dummy.next;
    }
}

    328. Odd Even Linked List 

        class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = head, even = head.next, evenHead = even;
        while(even!=null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}

    3507. Minimum Pair Removal to Sort Array I

        class Solution {
    public void operation(int[] nums,int n){
        int min_index=0;
        int minsum=nums[0]+nums[1];
        for(int i=0;i<n-1;i++){
            if(nums[i]+nums[i+1]<minsum){
                min_index=i;
                minsum=nums[i]+nums[i+1];
            }
        }
        nums[min_index]=minsum;
        for(int i=min_index+1; i<n-1;i++){
            nums[i]=nums[i+1];
        }
        
    }
    public int minimumPairRemoval(int[] nums) {
        int n=nums.length;
        int[] pairsum=new int[n-1];
        int count=0;
        for(int i=0; i<n-1;i++){
            if(nums[i]>nums[i+1]){
                count++;
                operation(nums,n);
                i=-1;
                n--;
            }
        }
        return count;
    }
}

    
1475. Final Prices With a Special Discount in a Shop

    class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            result[i] = prices[i];
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    result[i] -= prices[j];
                    break;
                }
            }
        }
        
        return result;
    }
}

    1171. Remove Zero Sum Consecutive Nodes fromLinkedList

   
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        int prefixSum = 0;

        Map<Integer, ListNode> map = new HashMap<>();
        map.put(0, dummy);

        while(curr != null) {
            prefixSum += curr.val;
            map.put(prefixSum, curr);
            curr = curr.next;
        }

        prefixSum = 0;
        curr = dummy;

        while(curr != null) {
            prefixSum += curr.val;
            curr.next = map.get(prefixSum).next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
