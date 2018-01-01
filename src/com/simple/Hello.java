/* Program to append and print strings inputted through command prompt*/

public class Hello
{
 public static void main(String args[])
  {
		
	String allnames = "";
	
	for(int i=0; i<args.length; i++){
		allnames = allnames +  "\n" + args[i];
	}
    
	System.out.println(" Hello world "+allnames);
	
  }
 
 
}