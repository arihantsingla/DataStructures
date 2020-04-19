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
class BinaryTreeFromArray
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
  static Node buildTree(int t[], int x)
{
  Node node = new Node(t[0]);
  java.util.Queue<Node> n = new java.util.LinkedList<>();
  n.add(node);
  for(int i=1;i<t.length;++i){
     Node nn=new Node(t[i]);
      Node q=n.peek();
      if(q.leftChild==null){
        q.leftChild=nn;
        n.add(q.leftChild);
      }
      
      else if(q.rightChild==null) { 
        q.rightChild=nn;
        n.remove();
        n.add(q.rightChild);
      }
    }
  return node;
}
public static void main(String[] args)
  {
      Scanner sc=new Scanner(System.in);
      System.out.print("Enter No. of elements: ");
      int n=sc.nextInt();
    int a[]=new int[n];
    System.out.print("Enter Array elements: ");
    for(int i=0;i<n;++i)
      a[i]=sc.nextInt();
    Node root = null;
    root = buildTree(a,n);
   inOrder(root);
  }
}