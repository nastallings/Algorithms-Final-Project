package Hashing;

import edu.princeton.cs.algs4.LinearProbingHashST;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.File; // Import the File class
import java.util.Scanner; // Import the Scanner class to read text files

public class Hashing_Test {

	public static void main(String[] args) {
        LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>();
        long[] timeToPut = new long[5];
        long[] timeToGet = new long[5];
        
        //Create the file object, the Scanner, and an array to hold words
        String[] English_Dict_Array= new String[321165];

        try {
        File myDict = new File("words.english.txt");
        Scanner myReader = new Scanner(myDict);
        int index = 0;
        //Fill the English_Dict_Array and close the reader
        while(myReader.hasNextLine()) {
        	English_Dict_Array[index++] = myReader.nextLine();
        }
        myReader.close();
       }catch(FileNotFoundException e) {
    	   System.out.println("The desired file was not found.");
       }
        
        //Run the test 4 times for the 4 different Dictionary sizes
        for(int i=1; i<=4; i++) {
        	long start = System.currentTimeMillis();
        	for(int j=0; j<English_Dict_Array.length/i; j++) {
        		st.put(English_Dict_Array[j], 1);
        	}
        	long finish= System.currentTimeMillis();
        	long TimeToCreate= finish-start;
        	timeToPut[i]=TimeToCreate;
   
        	start = System.currentTimeMillis();
        	for(int j=0; j<English_Dict_Array.length/i; j++) {
        		st.get(English_Dict_Array[j]);
        	}
        	finish= System.currentTimeMillis();        
        	long TimeToGet=finish-start;
        	timeToGet[i]=TimeToGet;
        }
        
        LinearProbingHashST<String, Integer> st_eight = new LinearProbingHashST<String, Integer>(8*321165);
        LinearProbingHashST<String, Integer> st_four = new LinearProbingHashST<String, Integer>(4*321165);
        LinearProbingHashST<String, Integer> st_two = new LinearProbingHashST<String, Integer>(2*321165);
        LinearProbingHashST<String, Integer> st_one_half = new LinearProbingHashST<String, Integer>((int)1.5*321165);
        LinearProbingHashST<String, Integer> st_one_quarter = new LinearProbingHashST<String, Integer>((int)1.25*321165);
        LinearProbingHashST<String, Integer> st_one_eigth = new LinearProbingHashST<String, Integer>((int)1.125*321165);

        
        
        
	}

}
