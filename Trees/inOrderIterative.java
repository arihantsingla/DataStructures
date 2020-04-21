/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class inOrderIteravtive {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new LinkedList<Integer>();
       Stack<TreeNode> st=new Stack<TreeNode>();
        TreeNode temp=root;
        while(temp!=null || st.empty()!=true){
            while(temp!=null){
                st.push(temp);
                temp=temp.left;
            }
            temp=st.pop();
            list.add(temp.val);
            temp=temp.right;        
        }
        return list;
}
    
}
    
