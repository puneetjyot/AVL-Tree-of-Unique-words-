import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Problem2  {
	
	private static LinkedList<String> FileLine(String fileName) throws FileNotFoundException
	{		
		LinkedList<String> linel = new LinkedList<String>();
			File name = new File(fileName);
		try 
		{
			Scanner Readable = new Scanner(name);
			int count= 0;
			
			
			while (Readable.hasNextLine()) 
			{
				String line = Readable.nextLine();
				count++;
				//System.out.println(line);
				linel.add(line);
				
				
			}
		}
			catch(FileNotFoundException E) 
			{
	        	System.out.println("Sorry file not found");
	        }
			
		return linel;
		}
	
	public static void main(String[] args) throws FileNotFoundException {
		if (args.length == 1) {
		LinkedList<String> linel = FileLine(args[0]);
		AvlTree<String> wordTree = readLine(linel);
		
			} 
		else 
		{
		System.out.println("Input file not properly specified. Please try again!");
		System.exit(1);
		}
	}
	
	private  static AvlTree<String> readLine(LinkedList<String> Lines) {
		AvlTree<String> Tree1 = new AvlTree<String>();
		int count = 1;
		String delims=" ";
		Iterator<String> ilines = Lines.iterator();
		while (ilines.hasNext()) {
			//System.out.println(count);

			String line = ilines.next();
			String line2 = line.replaceAll("[-+.^:,?!'; / () & \"]", " ").toLowerCase();
			StringTokenizer twords = new StringTokenizer(line2,delims);
			
			
			while (twords.hasMoreTokens()) {
				String nword = twords.nextToken();
				
					
					if (nword.matches(".*[a-zA-Z]+.*")) 
					{
						
						Tree1.insert(nword,count);
						//Tree1.insertLL(nword, count);
					}
				else if (Tree1.contains(nword))
				{
						//Tree1.insertLL(nword, count);
				}
				
			}
			
			count++;
			
			//System.out.println(twords);
		}
		//System.out.println(Tree1);
		Tree1.printTree();
		return Tree1;
		
		
	}
	
}