
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class MergeSort {
	
	 private Integer[] array;
	 private Integer[] tempMergArr;
	 private int length;
public static void main(String[] args) {
	if(args.length == 0)
	{
		System.out.println("Please enter InputFile name");
		System.out.println("Usage: java (FileName) (Input File)");
		return;
	}
	else if(args.length > 1)
	{
		System.out.println("Please enter only one argument");
		return;
	}
	else
	{
		ArrayList<Integer> list = null;
		
		
		try {
			//reading contents from input.txt and storing it in ArrayList
			list=ReadFileToList(args[0]);
			// list values are assigned in array named inputArr
			Integer[] inputArr=(Integer[]) list.toArray(new Integer[list.size()]);
			
			//merge sort
			long startTime = System.currentTimeMillis();
			MergeSort mms = new MergeSort();
	        mms.sort(inputArr);
	        
	        long endTime = System.currentTimeMillis();
	      // array values are assigned into file named Merge-answer.txt
	        PrintWriter writer = new PrintWriter("Merge-answer.txt", "UTF-8");
			writer.print("size of input list is "+inputArr.length+"\n");
				writer.print("It took " + (endTime - startTime) + " milliseconds to run the program"+ "\n");
				writer.print("elements in sorted order: ");
				//System.out.println("end time"+endTime);
				//System.out.println("start Time"+startTime);
			//System.out.println("it took "+(endTime-startTime));	
	        for (Integer i:inputArr)
			{
				writer.print(i);
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
public static void SortFile(String inputFileName,String outputFileName){
	ArrayList<Integer> inputList=ReadFileToList(inputFileName);
	Integer[] inputArr=(Integer[]) inputList.toArray(new Integer[inputList.size()]);
	MergeSort mms = new MergeSort();
    mms.sort(inputArr);
    WriteArrayToFile(inputArr,outputFileName);
	
}
public static void WriteArrayToFile(Integer[] array,String filename){
	try{
	PrintWriter writer = new PrintWriter(filename, "UTF-8");
	
	for (int i=0; i< array.length; i++)
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
private void sort(Integer[] inputArr) {
	// TODO Auto-generated method stub
    this.array = inputArr;
    this.length = inputArr.length;
    this.tempMergArr = new Integer[length];
    doMergeSort(0, length - 1);
	
}

private void doMergeSort(int lowerIndex, int higherIndex) {
	// TODO Auto-generated method stub
	 if (lowerIndex < higherIndex) {
         int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
         // Below step sorts the left side of the array
         doMergeSort(lowerIndex, middle);
         // Below step sorts the right side of the array
         doMergeSort(middle + 1, higherIndex);
         // Now merge both sides
         mergeParts(lowerIndex, middle, higherIndex);
     }
	
}

private void mergeParts(int lowerIndex, int middle, int higherIndex) {
	// TODO Auto-generated method stub
	  for (int i = lowerIndex; i <= higherIndex; i++) {
          tempMergArr[i] = array[i];
      }
      int i = lowerIndex;
      int j = middle + 1;
      int k = lowerIndex;
      while (i <= middle && j <= higherIndex) {
          if (tempMergArr[i] <tempMergArr[j]) {
              array[k] = tempMergArr[i];
              i++;
          } else {
              array[k] = tempMergArr[j];
              j++;
          }
          k++;
      }
      while (i <= middle) {
          array[k] = tempMergArr[i];
          k++;
          i++;
      }
	
}
}
