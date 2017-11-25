import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * InsertionSort Program reads the input data, preferably any number(integer,float,double etc..) from file through command line argument.
 * Sorts the data and stores the result into answer.txt.
 * Delimiter should be ","
 */
//Second Commit
public class InsertionSort {

	public InsertionSort() {
	}

	public static ArrayList<Integer> ReadFileToList(String filename){
		String text = null;
		ArrayList<Integer> list = new ArrayList<Integer>();
		BufferedReader reader;
		try{
			reader = new BufferedReader(new FileReader(filename));
		
		
		
		while ((text = reader.readLine()) != null) 
		{
			String[] resultingTokens = text.split(",");
			for (int i = 0; i < resultingTokens.length; i++)
			{
				list.add(Integer.parseInt(resultingTokens[i].trim()));
			}
		}
		reader.close();
		}catch(Exception e){e.printStackTrace();}
		return list;
	}
	public static ArrayList<Integer> SortList(ArrayList<Integer> list){
		for (int i=1; i< list.size(); i++)
		{
			Integer key = list.get(i);
			int j;
			//Using ParseDouble to make string comparisons
			for (j = i - 1; j >= 0 && (list.get(j)>key) ; j--)
			{
				list.set(j+1, list.get(j));
			}
			list.set(j+1, key);
		}
		return list;
	}
	public static void SortFile(String inputFileName,String outputFileName){
		ArrayList<Integer> inputList=ReadFileToList(inputFileName);
		ArrayList<Integer> outputList=SortList(inputList);
		WriteListToFile(outputList,outputFileName);
	}
	public static void WriteListToFile(ArrayList<Integer> list,String fileName){
		try{
		PrintWriter writer = new PrintWriter(fileName, "UTF-8");
		
		for (int i=0; i< list.size(); i++)
		{
			writer.print(list.get(i));
			if(i != list.size() - 1)
			{
				writer.print(", ");
			}		    	
		}
		writer.close();
		}catch(Exception e){e.printStackTrace();}
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
			
			

			try {
				//reading contents from input.txt and storing it in ArrayList
				list=ReadFileToList(args[0]);
                long startTime = System.currentTimeMillis();
                //System.out.println("start time"+startTime);
				//Insertion Sort
				list=SortList(list);

				long endTime = System.currentTimeMillis();
				//System.out.println("end time"+endTime);
				//System.out.println(" time "+ (endTime-startTime));
				//Print sorted data into Insertion-answer.txt file
				
				PrintWriter writer = new PrintWriter("Insertion-answer.txt", "UTF-8");
				writer.print("size of input list is "+list.size()+"\n");
				writer.print("It took " + (endTime - startTime) + " milliseconds to run the program"+ "\n");
				writer.print("elements in sorted order: ");
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
