import java.util.*;
public class KruskalAlgorithmGraph {
    static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int wt;
        public Edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
        @Override
        public int compareTo(Edge e2){
            return this.wt-e2.wt;
        }
    }
    static void createGraph(ArrayList<Edge> edge){
        edge.add(new Edge(0, 1, 10));
        edge.add(new Edge(0, 2, 15));
        edge.add(new Edge(0, 3, 30));
        edge.add(new Edge(1,3,40));
        edge.add(new Edge(2, 3, 50));
    }
    static int n=4;
    static int[] par=new int[n];
    static int [] rank=new int[n];

    public static void init(){
        for(int i=0;i<n;i++){
            par[i]=i;
        }
    }

    public static int find(int x){
        if(x==par[x]){
            return x;
        }
        return par[x]=find(par[x]);
    }
    public static void union(int a,int b){
        int parA=find(a);
        int parB=find(b);
        if(rank[parA]==rank[parB]){
            par[parB]=parA;
            rank[parA]++;
        }
        else if(rank[parA]<rank[parB]){
            par[parA]=parB;
        }
        else{
            par[parB]=parA;
        }
    }
    public static void KruskalAlgoMST(ArrayList<Edge> edge,int V){
        init();
        Collections.sort(edge);
        int MSTcost=0;
        int count=0;
        for(int i=0;count<V-1;i++){
            Edge e=edge.get(i);
            int parA=find(e.src);
            int parB=find(e.dest);
            if(parA!=parB){
                union(e.src,e.dest);
                MSTcost+=e.wt;
                count++;
            }
        }
        System.out.println(MSTcost);
    }

    public static void main(String[] args) {
        int V=4;
        ArrayList<Edge> edge=new ArrayList<>();
        createGraph(edge);
        KruskalAlgoMST(edge,V);
    }
    
}
