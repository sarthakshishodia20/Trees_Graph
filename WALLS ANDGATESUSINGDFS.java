import java.util.* ;
import java.io.*; 
public class Solution {
    public static int[][] wallsAndGates(int[][] a, int n, int m) {
        // Write you code here
        int[] dx={-1,0,+1,0};
        int[] dy={0,+1,0,-1};
        int[][] grid=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j]=a[i][j];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    dfs(i,j,dx,dy,grid,0);
                }
            }
        }
        return grid;
    }
    public static void dfs(int row,int col,int[] dx,int[] dy,int[][] grid,int distance){
        if(grid[row][col]<distance){
            return;
        }
        grid[row][col]=distance;
        for(int k=0;k<4;k++){
            int nrow=row+dx[k];
            int ncol=col+dy[k];
            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && grid[nrow][ncol]>distance+1){
                dfs(nrow,ncol,dx,dy,grid,distance+1);
            }
        }
        return;
    }
}
