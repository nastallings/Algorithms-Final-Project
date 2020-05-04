package Hashing;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.LinearProbingHashST;


public class Hashing_Test {

	public static void main(String[] args) {
        LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>();
        long[] timeToPut = new long[5];
        long[] timeToGet = new long[5];
        
        //Create the file object, the Scanner, and an array to hold words
        String[] English_Dict_Array= new String[321165];

        In myDict = new In("words.english.txt");
        int index = 0;
        //Fill the English_Dict_Array and close the reader
        while(myDict.hasNextLine()) {
        	English_Dict_Array[index++] = myDict.readLine();
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
        
        double[] mf = {8,4,2,1.5, 1.25, 1.125};
        long[] timeToPutStatic = new long[6];
        long[] timeToGetStatic = new long[6];
        
        for(int i = 0; i< mf.length; i++) {
            LinearProbingHashST<String, Integer> StaticHash = new LinearProbingHashST<String, Integer>((int)mf[i]*321165);
            long start = System.currentTimeMillis();
        	for(int j=0; j<English_Dict_Array.length; j++) {
        		st.put(English_Dict_Array[j], 1);
        	}
        	long finish= System.currentTimeMillis();
        	long TimeToCreate= finish-start;
        	timeToPutStatic[i]=TimeToCreate;
   
        	start = System.currentTimeMillis();
        	for(int j=0; j<English_Dict_Array.length; j++) {
        		st.get(English_Dict_Array[j]);
        	}
        	finish= System.currentTimeMillis();        
        	long TimeToGet=finish-start;
        	timeToGetStatic[i]=TimeToGet;
        }
       
        
      System.out.println(English_Dict_Array.length);
        
        
	}

}
