
// Author: Violette Augustin Similien
// Class: CS342
// Assignement 3
// Subject: Binary Tree
// Due date: 5/7/2019
// Prof: Vic Berry
// BinaryT 
public class BinaryT {

    // Declare variables and initize them to zero
    private Node root = null;
    private int size = 0;
    int totalCopies = 0;
    int countTwentyPre = 0;
    int countTwentyPost = 0;
    int countTwentyIn = 0;
    private int depthTest = 0;

    Node foundNode = new Node();

    /**
     * First method to add node to the tree
     */
    public void add(String data) {

        // See if the data already exists in the tree
        if (root == null) {
            // Add root to the tree
            root = new Node();
            //countDist++;
            root.setData(data);
        } else {
            internalAdd(root, data);
        }
    }

    /**
     * Internal method to add node to the tree
     */
    private void internalAdd(Node root, String data) {
        if (root == null) {
            return;
        }
        if (root.getData().compareTo(data) == 0) {
            root.copies += 1;
            // totalCopies+=1;
            if (root.getlChild() == null) {
                // add it here to the left
                Node n = new Node();
                n.setData(data);
                root.setlChild(n);
            }
        }
        if (root.getData().compareTo(data) > 0) { // if less than current root
            if (root.getlChild() == null) {
                // add it here to the left
                Node n = new Node();
                n.setData(data);
                root.setlChild(n);
                size++;
            } else {
                // recurse
                internalAdd(root.getlChild(), data);
            }
        } else {
            if (root.getrChild() == null) {
                // add it here to the right
                Node n = new Node();
                n.copies = 0;
                n.setData(data);
                root.setrChild(n);
                size++;

            } else {
                internalAdd(root.getrChild(), data);
            }
        }
    }

    /**
     * Method to get the word in the root of the tree
     */
    public String wordInRoot() {
        return root.getData();
    }

    /**
     * First "Search" method of the tree
     */
    public boolean search(String data) {
        foundNode = search(root, data);
        return (foundNode != null);
    }

    /**
     * Internal "Search" method of the tree
     */
    private Node search(Node root, String data) {

        if (root == null) {
            return null;
        }

        if (root.getData().equals(data)) {
            return root;
        }

        if (root.getData().compareTo(data) > 0) {
            return search(root.getlChild(), data);
        } else {
            return search(root.getrChild(), data);
        }
    }

    /**
     * First "preOrder traversal" method of the tree
     */
    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    /**
     * Internal "preOrder traversal" method of the tree
     */
    private void preOrder(Node root) {
        if (root == null) {
            return;
        }

        countTwentyPre++;
        if (countTwentyPre <= 20) {
            System.out.print(root.getData() + " ");
            preOrder(root.getlChild());
            preOrder(root.getrChild());
        }
    }

    /**
     * First "inOrder traversal" method of the tree
     */
    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    /**
     * Internal "inOrder traversal" method of the tree
     */
    private void inOrder(Node root) {
        if (root == null) {
            return;
        }

        countTwentyIn++;
        if (countTwentyIn <= 20) {
            inOrder(root.getlChild());
            System.out.print(root.getData() + " ");
            inOrder(root.getrChild());
        }
    }

    /**
     * First "postOrder traversal" method of the tree
     */
    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    /**
     * Internal "postOrder traversal" method of the tree
     */
    private void postOrder(Node root) {
        if (root == null) {
            return;
        }

        countTwentyPost++;
        if (countTwentyPost <= 20) {
            postOrder(root.getlChild());
            postOrder(root.getrChild());
            System.out.print(root.getData() + " ");
        }
    }

    /**
     * Internal class to find the deepest word and the depth of the tree
     */
    public class NDepth {

        public NDepth(Node root, int depth) {
            this.node = root;
            this.depth = depth;
        }
        Node node;
        int depth;
    }

    /**
     * First "deepest node" method of the tree
     */
    public String deepestNode() {
        NDepth deepestNode = deepestNode(root, 0);
        return deepestNode.node.getData();
    }

    /**
     * Internal "deepest node" method of the tree
     */
    private NDepth deepestNode(Node root, int depth) {
        if (root == null) {
            return null;
        }
        depth++;
        depthTest = depth;
        NDepth leftChild = deepestNode(root.getlChild(), depth);
        NDepth rightChild = deepestNode(root.getrChild(), depth);
        int leftChildCount = leftChild == null ? 0 : leftChild.depth;
        int rightChildCount = rightChild == null ? 0 : rightChild.depth;
        if (leftChildCount > rightChildCount) {
            return leftChild;
        }

        if (rightChildCount > 0) {
            return rightChild;
        }

        NDepth rootDepth = new NDepth(root, depth);

        return rootDepth;
    }

    /**
     * Method to get the depth of the tree
     */
    public int getDepth() {
        return depthTest;
    }

    /**
     * Method to get the size of the tree
     */
    public int getSize() {
        return size;
    }

    /**
     * Method to identify a node with maximum copies
     */
    private Node maxNCount(Node root) {
        if (root == null) {
            return null;
        }

        Node maxLeftNode = maxNCount(root.getlChild());
        Node maxRightNode = maxNCount(root.getrChild());
        int leftCount = maxLeftNode == null ? 0 : maxLeftNode.copies;
        int rightCount = maxRightNode == null ? 0 : maxRightNode.copies;

        if (leftCount > rightCount && leftCount > root.copies) {
            return maxLeftNode;
        }

        if (rightCount > leftCount && rightCount > root.copies) {
            return maxRightNode;
        }

        return root;
    }

    // Method to display the most frequent word.
    public String mostFrequent() {
        Node mostFrequentNode = maxNCount(root);
        return "\'" + mostFrequentNode.getData() + "\'" + " occuring " + (mostFrequentNode.copies + 1) + " times.";
    }

}
