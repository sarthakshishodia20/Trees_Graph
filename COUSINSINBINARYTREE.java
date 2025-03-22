class Solution {
    public static void assignParents(TreeNode root, HashMap<Integer, Integer> parentMap) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode currNode = q.poll();
            if (currNode.left != null) {
                q.add(currNode.left);
                parentMap.put(currNode.left.val, currNode.val); 
            }
            if (currNode.right != null) {
                q.add(currNode.right);
                parentMap.put(currNode.right.val, currNode.val);
            }
        }
    }
    public static int getLevel(TreeNode root, int key) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode currNode = q.poll();
                if (currNode.val == key) {
                    return level;
                }
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
            level++;
        }
        return -1; 
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        HashMap<Integer, Integer> parentMap = new HashMap<>();
        assignParents(root, parentMap);
        int levelOfX = getLevel(root, x);
        int levelOfY = getLevel(root, y);
        if (levelOfX != levelOfY) return false; 
        return parentMap.get(x) != parentMap.get(y); 
    }
}
