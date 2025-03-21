class Solution {
    public static void assignParents(TreeNode root, HashMap<TreeNode, TreeNode> map) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode currNode = q.poll();
            if (currNode.left != null) {
                q.add(currNode.left);
                map.put(currNode.left, currNode);
            }
            if (currNode.right != null) {
                q.add(currNode.right);
                map.put(currNode.right, currNode);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        assignParents(root, parentMap);

        HashSet<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        visited.add(target);
        int currLevel = 0;

        while (!q.isEmpty()) {
            if (currLevel == k) break;
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode currNode = q.poll();

                if (currNode.left != null && !visited.contains(currNode.left)) {
                    q.add(currNode.left);
                    visited.add(currNode.left);
                }
                if (currNode.right != null && !visited.contains(currNode.right)) {
                    q.add(currNode.right);
                    visited.add(currNode.right);
                }
                if (parentMap.containsKey(currNode) && !visited.contains(parentMap.get(currNode))) {
                    q.add(parentMap.get(currNode));
                    visited.add(parentMap.get(currNode));
                }
            }
            currLevel++;
        }

        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            list.add(q.poll().val);
        }
        return list;
    }
}
