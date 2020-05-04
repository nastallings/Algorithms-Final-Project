package Hashing;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.LinearProbingHashST;

public class Hashing_Test {

	public static void main(String[] args) {
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
        for(int i=0; i<4; i++) {
            LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>();
        	long start = System.currentTimeMillis();
        	for(int j=0; j<(int)(English_Dict_Array.length/(Math.pow(2,i))); j++) {
        		st.put(English_Dict_Array[j], 1);
        	}
        	long finish= System.currentTimeMillis();
        	long TimeToCreate= (finish-start);
        	timeToPut[i]=TimeToCreate;
   
        	long startGet = System.currentTimeMillis();
        	for(int j=0; j<(int)(English_Dict_Array.length/(Math.pow(2,i))); j++) {
        		st.get(English_Dict_Array[j]);
        	}
        	long finishGet= System.currentTimeMillis(); 
        	long TimeToGet=finishGet-startGet;
        	timeToGet[i]=TimeToGet;
        }
        
        double[] mf = {8,4,2,1.5, 1.25, 1.125};
        long[] timeToPutStatic = new long[6];
        long[] timeToGetStatic = new long[6];
        
        for(int i = 0; i< mf.length; i++) {
            LinearProbingHashST<String, Integer> StaticHash = new LinearProbingHashST<String, Integer>((int)(mf[i]*321165));
            long start = System.currentTimeMillis();
        	for(int j=0; j<English_Dict_Array.length; j++) {
        		StaticHash.put(English_Dict_Array[j], 1);
        	}
        	long finish= System.currentTimeMillis();
        	long TimeToCreate= finish-start;
        	timeToPutStatic[i]=TimeToCreate;
   
        	start = System.currentTimeMillis();
        	for(int j=0; j<English_Dict_Array.length; j++) {
        		StaticHash.get(English_Dict_Array[j]);
        	}
        	finish= System.currentTimeMillis();        
        	long TimeToGet=finish-start;
        	timeToGetStatic[i]=TimeToGet;
        }
       
        
		System.out.println("N	 Time to Put(ms)		Time to Get(ms)");
         for(int i=0; i<4; i++) {
      		System.out.print(String.format("%4d,", (int)(English_Dict_Array.length/(Math.pow(2,i)))));
     		System.out.print(String.format("%8d,", timeToPut[i]));
    		System.out.print(String.format("%26d,", timeToGet[i]));
    		System.out.println();
         }
         
         System.out.println("Size	 Time to Put Constant Size(ms)		Time to Get Constant Size(ms)");
         for(int i=0; i<6; i++) {
      		System.out.print(String.format("%4d,", (int)(mf[i]*321165)));
     		System.out.print(String.format("%16d,", timeToPutStatic[i]));
    		System.out.print(String.format("%48d,", timeToGetStatic[i]));
    		System.out.println();
         }
        
	}

}
