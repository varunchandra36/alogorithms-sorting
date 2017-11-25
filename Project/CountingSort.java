

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class CountingSort {
	
	
public static void main(String[] args) {
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
			list=ReadFileToList(args[0]); 
			// list values are assigned in array named inputArr
			Integer[] inputArr=(Integer[]) list.toArray(new Integer[list.size()]);
			long startTime = System.currentTimeMillis();			
			//Counting Sort
			CountingSort c=new CountingSort();
			Integer[] Res =c.sort(inputArr);
											
			  // list values are assigned into Counting-answer.txt
			  long endTime = System.currentTimeMillis();
	        PrintWriter writer = new PrintWriter("Counting-answer.txt", "UTF-8");
			writer.print("size of input list is "+Res.length+"\n");
			writer.print("It took " + (endTime - startTime) + " milliseconds to run the program"+ "\n");
			writer.print("elements in sorted order: ");
	       // System.out.println("end time"+endTime);
	        //System.out.println("start time"+endTime);
	        //System.out.println("it took "+(endTime-startTime));
	        for (int i=1;i<Res.length;i++)
			{
				writer.print(Res[i]);
				if(i!=Res.length-1)
				writer.print(", ");
					    	
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
public static void WriteArrayToFile(Integer[] array,String filename){
	try{
	PrintWriter writer = new PrintWriter(filename, "UTF-8");
	
	for (int i=1; i< array.length; i++)
	{
		writer.print(array[i]);
		if(i != array.length - 1)
		{
			writer.print(", ");
		}		    	
	}
	writer.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	
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
public static void SortFile(String inputFilename,String outputFilename){
	ArrayList<Integer> inputList=ReadFileToList(inputFilename);
	Integer[] inputArr=(Integer[]) inputList.toArray(new Integer[inputList.size()]);
	Integer[] result=new CountingSort().sort(inputArr);
	WriteArrayToFile(result,outputFilename);
 }

private Integer[] sort(Integer[] A) {
	// TODO Auto-generated method stub
	Integer[] Result = new Integer[A.length + 1];
	int[] Count = new int[10000000];
	for (int i = 0; i < Count.length; i++) {
		Count[i] = 0; // put count for every element as 0
	}
	// Count[] will store the counts of each integer in the given array
			for (int i = 0; i < A.length; i++) {
				int x = Count[A[i]];
				x++;
				Count[A[i]] = x;
			}
			// • Update the Count[] so that each index will store the sum till
			// previous step. (Count[i]=Count[i] + Count[i-1]).
			// Now updated Count[] array will reflect the actual position of each
			// integer in Result[].
	
			for (int i = 1; i < Count.length; i++) {
				Count[i] = Count[i] + Count[i - 1];
			}
			// • Now navigate the input array taking one element at a time,
			// Count[input[i]] will tell you the index position of input[i] in
			// Result[]. When you do that, decrease the count in Count[input[i]] by
			// 1.
			
			for (int i = A.length - 1; i >= 0; i--) {
				int x = Count[A[i]];
				Result[x] = A[i];
				x--;
				Count[A[i]] = x;
			}
			
			return Result;
	
}

}


