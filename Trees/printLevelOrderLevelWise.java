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

class printLevelOrderLevelWise
{
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
static void printLevelWise(Node root)
{
	java.util.Queue<Node> n=new java.util.LinkedList<>();
 		n.add(root);
  	while(n.isEmpty()!=true){
     	int s=n.size();
      while(s!=0){
        Node x=n.peek();
         System.out.print(x.data+" ");
         if(x.leftChild!=null)
        n.add(x.leftChild);
        if(x.rightChild!=null)
        n.add(x.rightChild);
        n.remove();
        --s;
      }
      System.out.println();
    }
}
public static void main(String[] args)
  {
    Scanner sc=new Scanner(System.in);
 		System.out.print("Enter no. of Nodes in Trees: ");
      int n=sc.nextInt();
      	System.out.print("Enter Nodes to insert level wise: ");
    int a[]=new int[n];
    for(int i=0;i<n;++i)
      a[i]=sc.nextInt();
    Node root = null;
    root = buildTree(a,n);
    printLevelWise(root);
  }
}