package node.nodes;

import node.Node;
import node.NodeScript;
import org.dreambot.api.methods.map.Area;

public class WalkNode extends Node {

    private static final Area TREE_AREA = new Area();
    public WalkNode(NodeScript main) {
        super(main);
    }

    @Override
    public boolean validate() {
        return !TREE_AREA.contains(c.getLocalPlayer());
    }
    //if not in the tree area then it will return true and walk there

    @Override
    public int execute() {

        c.getWalking().walk(TREE_AREA.getRandomTile());
        return 1000;
    }
}
