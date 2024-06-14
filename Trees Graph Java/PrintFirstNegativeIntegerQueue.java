import java.util.*;

class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        long[] res=new long[N-K+1];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<N;i++){
            if(A[i]<0){
                q.add(i);
            }
        }
        for(int i=0;i<N-K+1;i++){
            if(q.size()>0 && q.peek()<i){
                q.remove();
            }
            if(q.size()>0 && q.peek()<=i+K-1){
                res[i]=A[q.peek()];
            }
            else if(q.size()==0){
                res[i]=0;
            }
            else{
                res[i]=0;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        Compute compute = new Compute();
        long[] A = {-8, 2, 3, -6, 10};
        int N = A.length;
        int K = 2;
        long[] result = compute.printFirstNegativeInteger(A, N, K);
        System.out.println("First negative integers in each window of size " + K + ":");
        for (long num : result) {
            System.out.print(num + " ");
        }
    }
}
