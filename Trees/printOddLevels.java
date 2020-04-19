import java.util.*;
class Node
{
  int data; // data used as key value
  Node leftChild;
  Node rightChild;
  public Node()
  {
    data=0;
  }
  public Node(int d)
  {
    data=d;
  }
}

class printOddLevels
{
  static void printOdd(Node root) {
    if(root!=null){
java.util.Queue<Node> q=new java.util.LinkedList<>();
    q.add(root);
    for(int i=1;q.isEmpty()==false;++i){
      int s=q.size();
      while(s!=0){
        Node x=q.poll();
        if(i%2!=0)
        System.out.print(x.data+" ");
        if(x.leftChild!=null)
          q.add(x.leftChild);
        if(x.rightChild!=null)
          q.add(x.rightChild);
        --s;
      }
    }
    
  }
  }
  static void inOrder(Node root)
  {
    if (root != null)
    {
      inOrder(root.leftChild);
      System.out.print(root.data + " ");
      inOrder(root.rightChild);
    }
  }
  static Node insertLevelOrder(int arr[], Node root, int i, int n)
  {
    if (i < n)
    {
      Node temp = new Node(arr[i]);
      root = temp;
      root.leftChild = insertLevelOrder(arr, root.leftChild, 2 * i + 1, n);
      root.rightChild = insertLevelOrder(arr, root.rightChild, 2 * i + 2, n);
    }
    return root;
  }

  static Node buildTree(int t[], int n)
  {
    Node node = null;
    node = insertLevelOrder(t, node, 0, n);
    return node;
  }
  public static void main(String[] args)
  {
      Scanner sc=new Scanner(System.in);
      System.out.print("Enter No. of Nodes: ");
      int n=sc.nextInt();
    int a[]=new int[n];
    System.out.print("Enter Nodes to insert Level wise: ");
    for(int i=0;i<n;++i)
      a[i]=sc.nextInt();
    Node root = null;
    root = buildTree(a,n);
   printOdd(root);
  }
}