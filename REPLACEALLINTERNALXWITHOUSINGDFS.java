
public class Solution{

    public static void replaceOWithX(char matrix[][]) {
        // write your code here
        int[][] visited=new int[matrix.length][matrix[0].length];
        int[] dx={-1,0,+1,0};
        int[] dy={0,+1,0,-1};
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            if(matrix[i][0]=='O' && visited[i][0]==0){
            dfs(i,0,matrix,visited,dx,dy);
            }
        }
        for(int j=0;j<m;j++){
            if(matrix[0][j]=='O' && visited[0][j]==0){
            dfs(0,j,matrix,visited,dx,dy);
            }
        }
        for(int j=0;j<m;j++){
            if(matrix[n-1][j]=='O' && visited[n-1][j]==0){
            dfs(n-1,j,matrix,visited,dx,dy);
            }
        }
        for(int i=0;i<n;i++){
            if(matrix[i][m-1]=='O' && visited[i][m-1]==0){
            dfs(i,m-1,matrix,visited,dx,dy);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='O' && visited[i][j]==0){
                    matrix[i][j]='X';
                }
            }
        }
        return;
    }
    public static void dfs(int row,int col,char[][] matrix,int[][] visited,int[] dx,int[] dy){
        visited[row][col]=1;
        for(int k=0;k<4;k++){
            int nrow=row+dx[k];
            int ncol=col+dy[k];
            if(nrow>=0 && nrow<matrix.length && ncol>=0 && ncol<matrix[0].length && visited[nrow][ncol]==0 && matrix[nrow][ncol]=='O'){
                dfs(nrow,ncol,matrix,visited,dx,dy);
            }
        }
        return;
    }
}
