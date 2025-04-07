class Solution{
    public static void dfs(TreeMap<Integer,Integer> map,int hd,Node root){
        if(root==null){
            return ;
        }
        dfs(map,hd-1,root.left);
        map.put(hd,map.getOrDefault(hd,0)+root.data);
        dfs(map,hd+1,root.right);
    }
    public ArrayList <Integer> verticalSum(Node root) {
        // add your code hereT
        TreeMap<Integer,Integer> map=new TreeMap<>();
        dfs(map,0,root);
        ArrayList<Integer> ans=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}
