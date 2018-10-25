package node;

public abstract class Node {

    protected final NodeScript c;

    public Node(NodeScript main){
        this.c = main;
    }
    public abstract boolean validate();
    public abstract int execute();
}
