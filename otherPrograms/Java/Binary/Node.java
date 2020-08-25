
// Author: Violette Augustin Similien
// Class: CS342
// Assignement 3
// Subject: Binary Tree
// Due date: 5/7/2019
// Prof: Vic Berry
// Node class
public class Node {

    // Declare variables
    private String data;
    private Node lChild;
    private Node rChild;
    int copies = 0;

    // "Get" and "Set" methods for left & right children nodes and their data
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getlChild() {
        return lChild;
    }

    public void setlChild(Node lChild) {
        this.lChild = lChild;
    }

    public Node getrChild() {
        return rChild;
    }

    public void setrChild(Node rChild) {
        this.rChild = rChild;
    }
}
