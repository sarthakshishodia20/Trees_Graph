import java.util.ArrayList;

class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int item) {
        data = item;
        left = right = null;
    }
}

public class TwoSumInBST {
    public static void inOrder(TreeNode root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }
        inOrder(root.left, ans);
        ans.add(root.data);
        inOrder(root.right, ans);
    }

    public static boolean isTwoSum(TreeNode root, int target) {
        ArrayList<Integer> ans = new ArrayList<>();
        inOrder(root, ans);
        int i = 0;
        int j = ans.size() - 1;
        while (i < j) {
            int sum = ans.get(i) + ans.get(j);
            if (sum == target) {
                return true;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Create a sample binary search tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        int target = 9;
        boolean isTwoSumExists = isTwoSum(root, target);
        if (isTwoSumExists) {
            System.out.println("There exists two elements in the BST that sum up to " + target);
        } else {
            System.out.println("There doesn't exist two elements in the BST that sum up to " + target);
        }
    }
}
