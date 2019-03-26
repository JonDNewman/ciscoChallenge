package cisco.java.challenge;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Graph {



    public ArrayList paths(GNode node){
        return getPaths(node, new ArrayList(), new Stack(), new HashSet());
    }

    private ArrayList getPaths(GNode source, ArrayList paths, Stack path, Set onPath){
        //functional approach
        path.push(source);
        onPath.add(source);

        if(source.getChildren().length==0){
            paths.add(new ArrayList<>(path));

        }
        else {
            for (GNode node : source.getChildren()) {
                if (!onPath.contains(node)) getPaths(node, paths, path, onPath);
            }
        }
        path.pop();
        onPath.remove(source);
        return paths;

    }

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

}


