public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            TreeNode currNode = q.poll();
            
            if (currNode == null) {
                sb.append("null,");
                continue; // Avoid adding children of null nodes
            }
            
            sb.append(currNode.val).append(",");
            q.add(currNode.left);
            q.add(currNode.right);
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            
            if (!values[i].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(values[i]));
                q.add(curr.left);
            }
            i++;
            
            if (!values[i].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(values[i]));
                q.add(curr.right);
            }
            i++;
        }
        
        return root;
    }
}
