********************************************************************************
***************************** Run Commands **************************
********************************************************************************
			Extract the Project.zip file.
********************************************************************************
******************************* STEPS TO SOLVE THE PROBLEM ****************************
********************************************************************************
PART A:
The steps that are followed to implement the three sorts are as follows:

Step1: First, we have generated Random input numbers into a text file (name of the text file can be anything), using a RandomInputgenerator file. Considering the input file name as input.txt,
we can genearte randome numbers with any given range.

Syntax for compiling and running the RandomInputgenerator:

javac RandomInputgenerator.java
java RandomInputgenerator <filename into which the generated randome numbers are to be written>  <number of random numbers>

Suppose, if we want to generate 10000 numbers into input.txt file, run it as, java RandomInputgenerator input.txt 10000 



Step2: Now, we have implemented our sorting algorithms on list of integers (generated in step 1). The sorted output is written into another text file.

Presort.java: 

This file sorts the given list of numbers

Syntax for compiling and running:
javac Presort.java
java Presort input.txt

The output will be in presort.txt, containing the sorted order of those elements in input.txt

ReverseSort.java

This file sorts the given list of numbers

Syntax for compiling and running:
javac ReverseSort.java
java ReverseSort input.txt

The output will be in reverse.txt, containing the reverse sorted order of those elements in input.txt


		- For the average case, take the input file as input.txt, the one generated from RandomInputgenerator.java
		- For best case, take the input file as presort.txt, the one generated from PreSort.java
		- For worst case, take the input as reverse.txt, the one generated from ReverseSort.java

- For insertion sort, the sorted output is written into Insertion-answer.txt


Syntax for compiling and running:

javac InsertionSort.java
java insertionSort input.txt  ------- average case
java insertionSort presort.txt   ---- best case
java insertionSort reverse.txt   ---- worst case

- For Merge sort, the sorted output is written into Merge-answer.txt
Syntax for compiling and running:

javac MergeSort.java
java MergeSort input.txt  ------- average case
java MergeSort presort.txt   ---- best case
java MergeSort reverse.txt   ---- worst case

- for counting sort,  the sorted output is written into Counting-answer.txt
Syntax for compiling and running:

javac CountingSort.java
java CountingSort input.txt  ------- average case
java CountingSort presort.txt   ---- best case
java CountingSort reverse.txt   ---- worst case

Step3: The sorted outputs along with input size and running time are stored in the output text file.
	Insertion-answer.txt for insertion sort.
	Merge-answer.txt for merge sort.
	Counting-answer.txt for counting sort.

PART B:
The steps that are followed to implement the Longest Common Subsequence are as follows:

Syntax for compiling and running the LongestCommonSubsequence:

javac LongestCommonSubsequence.java
java LongestCommonSubsequence <file1.txt> <file2.txt> <file3.txt>

- The LCS of given 3 files i.e, file1.txt, file2.txt, file3.txt is stored in LCS_in.txt
- The 3 files (file1.txt, file2.txt, file3.txt) are sorted and the LCS of all 3 sorted files is stored in LCS_out.txt

Step 1: We have taken three input text files xyz.txt, pqr.txt, abc.txt containing comma seperated numbers from user
Step 2:	After that,we called LCSFinder() method, to find the Longest common subsequence.
Step 3: The longest common subsequence that is generated from three input files is stored in "LCS_in.txt" file.
Step 4: Now, we implemented our sorting algorithms by calling their respective functions as,SortFile() method.
Step 5: The sorted outputs are exported into text files n2SORT.txt, nlgnSORT.txt, nSORT.txt.
Step 6: The three text files containing soted outputs are again used to find Longest common subsequence.
Step 7: The longest common subsequence that is generated from sorted files(n2SORT.txt, nlgnSORT.txt, nSORT.txt) is stored in "LCS_out.txt" file.

********************************************************************************
******************************** DIRECTORY FILES ****************************
********************************************************************************
1. RandomInputgenerator.java
	This file takes input as the number of random numbers to be generated and to which file, those numbers are to be written.
2. InsertionSort.java
	
	1) Using BufferedReader, input file contents are read.
	2) Now, the numbers are stored into a list.
	3) In SortList() method, insertion sort algorithm is implemented.
	4) In PrintWriter, the sorted output along with run time and input size are stored in "Insertion-answer.txt" file.

3. MergeSort.java
	
	1) Using BufferedReader, input file contents are read.
	2) Now, the numbers are stored into a list.
	3) In SortList() method, merge sort algorithm is implemented.
	4) In PrintWriter, the sorted output along with run time and input size are stored in "Merge-answer.txt" file.

	
4. CountingSort.java

	1) Using BufferedReader, input file contents are read.
	2) Now, the numbers are stored into a list.
	3) In SortList() method, counting sort algorithm is implemented.
	4) In PrintWriter, the sorted output along with run time and input size are stored in "Counting-answer.txt" file.

5. LCS.java
	This file contains implementation of Longest common subsequence.
	
	1) LCSFinder() method is used to find the LCS for the any given three text files.
	2) Using BufferedReader, input file contents are read.
	3) ReadFileToList() method reads the file from commandprompt arguments and converts in to list.
	4) In PrintWriter, the contenst are writen into a file.
	5) WriteListToFile() method writes the output into the given file.
	6) The three files are taken as arguments from command prompt, LCS of those 3 is stored in LCS_in.txt, those 3 files are sorted and the LCS of the sorted 3 files is stored in LCS_out.txt.

6. ReverseSort.java
	This file takes an input file and generates the reverse sort of the list of numbers in the given input. This is used to reverse sort a list of numbers and then,
 call any of the sorting algorithms to find the worst case scenario of each algorithm.

The output is written into reverse.txt

7. Presort.java
	This file takes an input file and generates a sorted list of numbers for the given input. This is used to presort a list of numbers and then,
 call any of the sorting algorithms to find the best case scenario of each algorithm.

The output is written into presort.txt


********************************************************************************
****************************** COMPATIBILITY ***********************************
********************************************************************************

This code is executed on jdk1.8.0.
It is complied and executed in command prompt.

*********************************************************************************
************************PACKAGES AND LIBRARIES***********************************
*********************************************************************************
We have used the default java libraries.
The packages used are :
java.io.BufferedReader;
java.io.FileNotFoundException;
java.io.FileReader;
java.io.PrintWriter;
java.io.UnsupportedEncodingException;
java.util.ArrayList;
java.util.Collections;








