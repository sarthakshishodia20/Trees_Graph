import java.util.*;
public class PathFromSourceToTargetDirected {
    static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void createGraph(ArrayList<Edge> [] graph){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 3));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }
    public static void printAllPaths(ArrayList<Edge>[] graph,int src, int dest,String path){
        int currNode=src;
        if(currNode==dest){
            System.out.print(path+dest);
            System.out.println();
            return;
        }
        for(int i=0;i<graph[currNode].size();i++){
            Edge e=graph[currNode].get(i);
            printAllPaths(graph, e.dest, dest, path+currNode);

        }
    }
    public static void main(String[] args) {
        int V=6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph=new ArrayList[V];
        createGraph(graph);
        printAllPaths(graph, 5, 1, "");

    }
    
}
