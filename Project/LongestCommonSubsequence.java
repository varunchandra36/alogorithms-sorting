import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;


public class LongestCommonSubsequence {

	public static ArrayList<Integer> LCSFinder(ArrayList<Integer> list1,ArrayList<Integer> list2,ArrayList<Integer> list3){
		ArrayList<Integer> result=new ArrayList<Integer>();
		try{
			
		Integer memoized[][][]=new Integer[list1.size()+1][list2.size()+1][list3.size()+1];
        for(int i=0;i<=list1.size();i++){
        	for(int j=0;j<=list2.size();j++){
        		for(int k=0;k<=list3.size();k++){
        			if (i == 0 || j == 0||k==0){
        		         memoized[i][j][k] = 0;
        		         }
        			else if (list1.get(i-1).equals(list2.get(j-1))&&list3.get(k-1).equals(list1.get(i-1))){
        				memoized[i][j][k]=memoized[i-1][j-1][k-1]+1;
        			}
        			else {
        				memoized[i][j][k]=Math.max(Math.max(memoized[i-1][j][k],memoized[i][j-1][k]),memoized[i][j][k-1]);
        			}
        		}
       
        		
        	}
        }
        
        int i=list1.size(),j=list2.size(),k=list3.size();
        
        while(i>0&&j>0&&k>0){
        	if(list1.get(i-1).equals(list2.get(j-1))&&list1.get(i-1).equals(list3.get(k-1))){
        		
        		result.add(list1.get(i-1));
        		
        		i--;j--;k--;
        	}
        	else if(memoized[i-1][j][k]>=memoized[i][j-1][k]&&memoized[i-1][j][k]>=memoized[i][j][k-1]){
        		
        		i--;
        	}
        	else if(memoized[i][j-1][k]>=memoized[i-1][j][k]&&memoized[i][j-1][k]>=memoized[i][j][k-1]){
        		
        		j--;
        	}
        	else{
        		
        		k--;
        	}
        }
        Collections.reverse(result);
		}catch(Exception e){System.out.println("Exception"+e.getMessage());}
		return result;
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
		}catch(Exception e){System.out.println("error");e.printStackTrace();}
	}
	public static void main(String args[]) throws Exception{
		if(args.length != 3)
		{
			System.out.println("Please enter three InputFile names");
			System.out.println("Usage: java (FileName) (Input File)");
			return;
		}
		
		else
		{
			ArrayList<Integer> list1=ReadFileToList(args[0]);
			ArrayList<Integer> list2=ReadFileToList(args[1]);
			ArrayList<Integer> list3=ReadFileToList(args[2]);
			ArrayList<Integer> result=LCSFinder(list1,list2,list3);
			WriteListToFile(result,"LCS_in.txt");
			
			InsertionSort.SortFile(args[0],"n2SORT.txt");
			MergeSort.SortFile(args[1],"nlgnSORT.txt");
			CountingSort.SortFile(args[2],"nSORT.txt");
			
			list1=ReadFileToList("n2SORT.txt");
			list2=ReadFileToList("nlgnSORT.txt");
			list3=ReadFileToList("nSORT.txt");
			result=LCSFinder(list1,list2,list3);
			
			WriteListToFile(result,"LCS_out.txt");
			
		}
	}
	
}
