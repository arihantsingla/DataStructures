/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new LinkedList<Integer>();
       Stack<TreeNode> st=new Stack<TreeNode>();
            TreeNode temp=root;
        while(temp!=null || st.size()>0){
            while(temp!=null){
                st.push(temp);
                st.push(temp);
                temp=temp.left;
            }
            temp=st.pop();
            
            if(st.empty()!=true && st.peek()==temp){
                temp=temp.right;
            }
            else{
                list.add(temp.val);
                temp=null;
            }
        }
        return list;
    }
}