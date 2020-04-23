/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class TreeFromInorderAndPreOrder {
    public TreeNode helper(int[] preorder,int[] inorder,int preS,int preE,int inS,int inE){
        if(inS>inE)
            return null;
        int data=preorder[preS];
        int linS=0;
        int linE=0;
        int lpreS=0;
        int lpreE=0;
        int RinS=0;
        int RinE=0;
        int RpreS=0;
        int RpreE=0;
        int index=-1;
        for(int i=inS;i<=inE;++i)
        {
            if(inorder[i]==data)
            {
                index=i;
                break;
            }
        }
        linS=inS;
        linE=index-1;
        lpreS=preS+1;
        lpreE=(linE-linS)+lpreS;
        RinS=index+1;
        RinE=inE;
        RpreS=lpreE+1;
        RpreE=preE;
        TreeNode root=new TreeNode(data);
        root.left=helper(preorder,inorder,lpreS,lpreE,linS,linE);
        root.right=helper(preorder,inorder,RpreS,RpreE,RinS,RinE);

        return root;
        
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
  
    }
}