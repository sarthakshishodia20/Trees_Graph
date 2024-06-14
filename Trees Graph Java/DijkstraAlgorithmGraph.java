import java.util.*;
public class DijkstraAlgorithmGraph {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 1, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }
    static class Pair implements Comparable<Pair>{
        int node;
        int path;
        public Pair(int node,int path){
            this.node=node;
            this.path=path;
        }
        @Override
        public int compareTo(Pair p2){
            return this.path-p2.path;
        }
    }
    public static void DijkstraAlgo(ArrayList<Edge>[] graph,int src){
        boolean[] vis=new boolean[graph.length];
        int[] dist=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(!vis[curr.node]){
                vis[curr.node]=true;
                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e=graph[curr.node].get(i);
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;
                    if((dist[u]+wt)<dist[v]){
                        dist[v]=dist[u]+wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");

        
    }
    
    System.out.println();
        
    }
    public static void main(String[] args) {
        int V=6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph=new ArrayList[V];
        createGraph(graph);
        int src=0;
        DijkstraAlgo(graph, src);
    }
    
}
