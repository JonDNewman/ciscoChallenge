package cisco.java.challenge;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Graph {

    public ArrayList walkGraph(GNode node){
        //DFS
        if(node.getChildren().length==0)
            return null;

        ArrayList<GNode> nodeList = new ArrayList<>();
        Stack<GNode> s = new Stack<>();
        Set<GNode> isVisited= new HashSet<>();

        s.push(node);
        while(!s.empty()){

            node = s.peek();
            s.pop();

            if(!isVisited.contains(node)){
                nodeList.add(node);
                isVisited.add(node);
            }
            for(GNode child: node.getChildren()){
                if(!isVisited.contains(child)){
                    s.push(child);
                }
            }
        }
        return nodeList;
    }
    public ArrayList paths(GNode node){
        GraphUtil gu = new GraphUtil();
        return gu.findPaths(node).getPaths();
    }

}

class GraphUtil {

    private final ArrayList<ArrayList<GNode>> paths = new ArrayList<>();
    private final Stack<GNode> path = new Stack<>();
    private final Set<GNode> onPath= new HashSet<>();

    public ArrayList getPaths() {
        return paths;
    }

    public GraphUtil findPaths(GNode source){
        findAllPaths(source);
        return this;
    }
    private void findAllPaths(GNode source){
        path.push(source);
        onPath.add(source);

        if(source.getChildren().length==0){
            paths.add(new ArrayList<>(path));

        }
        else {
            for (GNode node : source.getChildren()) {
                if (!onPath.contains(node)) findAllPaths(node);
            }
        }
        path.pop();
        onPath.remove(source);

    }


}

