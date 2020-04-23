
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class TreeFromInorderAndPostOrder {
    public TreeNode buildTree(int[] postorder, int[] inorder) {
        return makeBTree(postorder,inorder,0,postorder.length-1,0,inorder.length-1);
  
    }
	public TreeNode makeBTree(int[] inOrder, int[] postOrder, int iStart, int iEnd,
			int postStart, int postEnd) {
		if (iStart > iEnd) {
			return null;
		}

            int linS=0;
        int linE=0;
        int lpreS=0;
        int lpreE=0;
        int RinS=0;
        int RinE=0;
        int RpreS=0;
        int RpreE=0;
		int data = postOrder[postEnd];
		TreeNode root = new TreeNode(data);
		 
		int index =-1;
		for(int i=iStart;i<=iEnd;++i)
        {
            if(inOrder[i]==data)
            {
                index=i;
                break;
            }
        }
		linS=iStart;
        linE=index-1;
        
        RinS=index+1;
        RinE=iEnd;
       
        RpreE=postEnd-1;
         RpreS=RpreE-(RinE-RinS);
        lpreS=postStart;
        lpreE=RpreS-1;
		 root.left=makeBTree(inOrder,postOrder,linS,linE,lpreS,lpreE);
        root.right=makeBTree(inOrder,postOrder,RinS,RinE,RpreS,RpreE);
		// }
		return root;
	}

}