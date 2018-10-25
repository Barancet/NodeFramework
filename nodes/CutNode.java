package node.nodes;

import node.Node;
import node.NodeScript;

public class CutNode extends Node {
    public CutNode(NodeScript main) {
        super(main);
    }

    @Override
    public boolean validate() {
        return !c.getLocalPlayer().isAnimating();
    }
    //if not animating then not chopping aka... chop down the tree

    @Override
    public int execute() {
        c.getGameObjects().closest("Tree").interact("Cut Down");
        return 1000;
    }
    //this will be sent to the onLoop in main script class
}
