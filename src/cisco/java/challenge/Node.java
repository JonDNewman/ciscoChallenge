package cisco.java.challenge;

public class Node implements GNode {

    private String name;
    private GNode[] children;
    public Node(String label, GNode[] children){
        this.name = label;
        this.children = children;
    }


    public String getName() {
        return name;
    }


    public GNode[] getChildren() {
        return children;
    }

    public void setChildren(GNode[] children) {
        this.children = children;
    }

    @Override
    public String toString(){
        return name;
    }
}
