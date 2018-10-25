package node;

import node.nodes.BankNode;
import node.nodes.CutNode;
import node.nodes.WalkNode;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;

@ScriptManifest(category = Category.FISHING, name = "Node WoodCutter", author = "Barancet", version = 0)

public class NodeScript extends AbstractScript {

    private Node[] nodes;

    //order of the nodes matter... check bank (Inventory) first before going to cut more trees
    @Override
    public void onStart() {
        nodes = new Node[]{
                new BankNode(this),
                new WalkNode(this),
                new CutNode(this),

        };
    }

    @Override
    public int onLoop() {
        for(Node node : nodes){
            if(node.validate()){
                return node.execute();
            }
        }
        //cannot create instance of node because node is an abstract class
        log("No nodes (Error)"); //shouldn't reach this unless problem in node validation
        return 1000;
    }
}

