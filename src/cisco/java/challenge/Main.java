package cisco.java.challenge;


import java.util.ArrayList;

public class Main {

    private static GNode initNodes(){

        Node nodeA = new Node("A",new GNode[0]);
        Node nodeB = new Node("B",new GNode[0]);
        Node nodeC = new Node("C",new GNode[0]);
        Node nodeD = new Node("D",new GNode[0]);
        Node nodeE = new Node("E",new GNode[0]);
        Node nodeF = new Node("F",new GNode[0]);
        Node nodeG = new Node("G",new GNode[0]);
        Node nodeH = new Node("H",new GNode[0]);
        Node nodeI = new Node("I",new GNode[0]);

        ArrayList<GNode> neighborsList = new ArrayList<>();
        neighborsList.add(nodeB);
        neighborsList.add(nodeC);
        neighborsList.add(nodeD);

        nodeA.setChildren(neighborsList.toArray(new GNode[neighborsList.size()]));
        neighborsList.clear();

        neighborsList.add(nodeE);
        neighborsList.add(nodeF);
        nodeB.setChildren(neighborsList.toArray(new GNode[neighborsList.size()]));

        neighborsList.clear();

        neighborsList.add(nodeG);
        neighborsList.add(nodeH);
        neighborsList.add(nodeI);
        nodeC.setChildren(neighborsList.toArray(new GNode[neighborsList.size()]));

        return nodeA;

    }

    public static void main(String[] args) {

        Graph graph = new Graph();
        GNode node =  initNodes();
        System.out.print("Testing the walkGraph method: ");
        System.out.println(graph.walkGraph(node));
        System.out.print("Testing the paths method:     ");
        System.out.println(graph.paths(node));

    }

}




