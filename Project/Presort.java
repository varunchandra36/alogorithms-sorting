import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;


public class Presort {

	public Presort() {
	}

	public static void main(String[] args) 
	{
		if(args.length == 0)
		{
			System.out.println("Please enter InputFile name");
			System.out.println("Usage: java (FileName) (Input File)");
			return;
		}
		else if(args.length > 1)
		{
			System.out.println("Please enter only 1 argument");
			return;
		}
		else
		{
			ArrayList<Integer> list = null;
			BufferedReader reader = null;
			

			try {
				//reading contents from input.txt and storing it in ArrayList
				String text = null;
				String inputFile = args[0];
				reader = new BufferedReader(new FileReader(inputFile));
				list = new ArrayList<Integer>();
				
				while ((text = reader.readLine()) != null) 
				{
					String[] resultingTokens = text.split(",");
					for (int i = 0; i < resultingTokens.length; i++)
					{
						list.add(Integer.parseInt(resultingTokens[i].trim()));
					}
				}
                               Collections.sort(list);
                               

				
				
				//Print sorted data into answer.txt file
				PrintWriter writer = new PrintWriter("presort.txt", "UTF-8");
				
				for (int i=0; i< list.size(); i++)
				{
					writer.print(list.get(i));
					if(i != list.size() - 1)
					{
						writer.print(", ");
					}		    	
				}
				writer.close();
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			} 
			
		}
	}

}
