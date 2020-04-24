/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class MirrorTree {
    public TreeNode invertTree(TreeNode root) {
        TreeNode temp=null;
        if(root==null)
            return root;
        if(root.left==null && root.right==null)
            return root;
        if(root.left!=null || root.right!=null )
        {
            temp=root.left;
            root.left=root.right;
            root.right=temp;
        }
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}