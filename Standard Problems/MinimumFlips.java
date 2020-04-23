/*Minimum No. Flips required to balance the expression
Input:  exp = "}{"
Output: 2
We need to change '}' to '{' and '{' to
'}' so that the expression becomes balanced, 
the balanced expression is '{}'

Input:  exp = "{{{"
Output: Can't be made balanced using reversals

Input:  exp = "{{{{"
Output: 2 

Input:  exp = "{{{{}}"
Output: 1 

Input:  exp = "}{{}}{{{"
Output: 3
*/
import java.util.*;


class  MinimumFlips
{
    static int count(String s){
        if(s.length()%2!=0)
		return -1;
		Stack<Character> st=new Stack<Character>();
		for(int i=0;i<s.length();++i)
		{
		   char c=s.charAt(i);
		   if(c=='{')
		   st.push(c);
		   else if(c=='}' && st.empty()!=true)
		   st.pop();
		   else 
		   st.push(c);
		}
		if(st.empty()==true)
		return 0;
		int sizeOpen=0;
		int sizeClose=0;
		while(st.empty()!=true){
		        char ct=st.pop();
		        if(ct=='{')
		        ++sizeOpen;
		        else
		        ++sizeClose;
		}
		return (sizeOpen/2)+(2*sizeClose);
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
	    System.out.println(count(s));
	}
}
