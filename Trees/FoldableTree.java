static int FoldableTree(Node root) {
	if(root==null)
            return 1;
        else if(root.leftChild!=null && root.rightChild!=null){
            java.util.Queue<Node> q1=new java.util.LinkedList<>();
            java.util.Queue<Node> q2=new java.util.LinkedList<>();
            Node root1=root.leftChild;
            Node root2=root.rightChild;
                q1.add(root1);
            q2.add(root2);
            while(q1.isEmpty()!=true && q2.isEmpty()!=true)
            {
              	int size=q1.size();
                while(size>0){
                  root1=q1.poll();
                  root2=q2.poll();
                  if(root1.leftChild!=null && root1.rightChild!=null){
                    if(root2.rightChild==null)
                      return 0;
                    else if(root2.leftChild==null)
                      return 0;
                    else{
                      q1.add(root1.leftChild);
                      q1.add(root1.rightChild);
                      q2.add(root2.leftChild);
                      q2.add(root2.rightChild);
                    }
                  }
                  else if(root1.leftChild!=null && root1.rightChild==null){
                    if(root2.leftChild!=null && root2.rightChild==null)
                      return 0;
                    else{
                      q1.add(root1.leftChild);
                      q2.add(root2.leftChild);
                    }
                  }
                  else if(root1.leftChild==null && root1.rightChild!=null){
                    if(root2.leftChild==null && root2.rightChild!=null)
                      return 0;
                    else{
                      q1.add(root1.rightChild);
                      q2.add(root2.rightChild);
                    }
                  }
                  --size;
                }
            }
        
        }
      return 1;
  }
