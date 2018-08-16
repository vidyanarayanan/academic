package alg;

/**
 * Created by Vidya on 12/20/16.
 */
public class TreeInversion {


    public TreeNode invertTree(TreeNode root) {

        if (root != null) {
            invertTree(root.left);
            invertTree(root.right);
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }
}
