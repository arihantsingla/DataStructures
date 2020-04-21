/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class preOrderIterative {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new LinkedList<Integer>();
       Stack<TreeNode> st=new Stack<TreeNode>();
        st.push(root);
        if(root!=null){
        TreeNode temp=root;
        while(st.empty()!=true){
            temp=st.pop();
            list.add(temp.val);
            if(temp.right!=null){
                st.push(temp.right);
            }
            if(temp.left!=null){
                st.push(temp.left);
                temp=temp.left;
            }
        }
        }
        return list;
    }
}