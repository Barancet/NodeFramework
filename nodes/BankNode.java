package node.nodes;

import node.Node;
import node.NodeScript;

public class BankNode extends Node {
    public BankNode(NodeScript main) {
        super(main);
    }

    @Override
    public boolean validate() {
        return c.getInventory().isFull();
    }

    @Override
    public int execute() {
        if(c.getBank().isOpen()){
            c.getBank().depositAllExcept(item -> item != null && !item.getName().contains(" axe"));
        }else {
            c.getBank().openClosest();
        }
        return 1000;
    }
    //if inventory is full or bank is open, deposit all except anything that has axe in it
    //if the bank is not open then opens closest bank
    //if inventory isn't full then check walk node
}
