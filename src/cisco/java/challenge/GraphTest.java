package cisco.java.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;


class GraphTest {
    GNode node;
    Graph graph;


    @BeforeEach
    private void  initNodes(){
        graph = new Graph();


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



        node = nodeA;

    }
    @Test
    void testWalkGraph() {
        assertEquals(9, graph.walkGraph(node).size());
    }

    @org.junit.jupiter.api.Test
    void testPaths() {

        assertEquals(6, graph.paths(node,new ArrayList(), new Stack(), new HashSet()).size()
        );
    }

    @Test
    void pathsShouldAvoidCycles(){

        Node nodeA = new Node("A",new GNode[0]);
        Node nodeB = new Node("B",new GNode[0]);

        nodeA.setChildren(new GNode[]{nodeB});
        nodeB.setChildren(new GNode[]{nodeA});

        ArrayList<ArrayList<GNode>> paths = graph.paths(nodeA, new ArrayList(), new Stack(), new HashSet());

        assertEquals(0, paths.size());



    }

    @Test
    void pathsShouldReturnListOfItemOnSingleGNode(){

        assertEquals(1, graph.paths(new Node("A", new GNode[0]),new ArrayList(), new Stack(), new HashSet()).size());

    }

    @Test
    void walkGraphShouldAvoidCycles(){
        Node nodeA = new Node("A", new GNode[0]);
        Node nodeB = new Node("B", new GNode[0]);

        nodeA.setChildren(new GNode[]{nodeB});
        nodeB.setChildren(new GNode[]{nodeA});

        assertEquals(2, graph.walkGraph(nodeA).size());


    }
}