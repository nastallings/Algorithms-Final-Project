package sppradhan.FinalProject;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.LinearProbingHashST;

public class Hashing_Test {
    private static String[] English_Dict_Array = new String[321165];
    // all the times are in ms
    // for dynamically sized
    private static double[] timeToPut = new double[4];
    private static double[] timeToGet = new double[4];
    private static double[] timeToPutSD = new double[4];
    private static double[] timeToGetSD = new double[4];

    // for fixed sized
    private static double[] timeToPutFixed = new double[6];
    private static double[] timeToGetFixed = new double[6];
    private static double[] timeToPutFixedSD = new double[6];
    private static double[] timeToGetFixedSD = new double[6];
    private static double[] timeToDeleteFixed = new double[6];
    private static double[] timeToDeleteFixedSD = new double[6];

    // for putAndDelete
    private static double timeToPutAndDelete;
    private static double timeToPutAndDeleteSD;



    /**
     * @param T number of independent tests to run
     * @return
     */
    private static void timeToGetAndPutDynamic(int T) {
        double[] timeToPutLocal = new double[4];
        double[] timeToGetLocal = new double[4];
        int[] size = new int[] {321165, 160582, 80291,  40145};  // dont want to waste time calculating this in the time frame
        for (int i = 0; i < 4; i++) {
            double[] tempTimeToPut = new double[T];
            double[] tempTimeToGet = new double[T];

            for (int t = 0; t < T; t++) {
                System.gc();
                int k = size[i];
                LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>();
                double start = System.currentTimeMillis();
                for (int j = 0; j < k; j++) {
                    st.put(English_Dict_Array[j], 1);
                }
                double finish = System.currentTimeMillis();
                double TimeToCreate = (finish - start);
                timeToPutLocal[i] += TimeToCreate;    // total time to put (Sum of the total time to put)
                tempTimeToPut[t] = TimeToCreate;   // times to put (T in total)

                double startGet = System.currentTimeMillis();
                for (int j = 0; j < k; j++) {
                    st.get(English_Dict_Array[j]);
                }
                double finishGet = System.currentTimeMillis();
                double TimeToGet = finishGet - startGet;
                timeToGetLocal[i] += TimeToGet;
                tempTimeToGet[t] = TimeToGet;

            }
            timeToPut[i] = timeToPutLocal[i] / (double) T;  //average in milliseconds
            timeToGet[i] = timeToGetLocal[i] / (double) T;  //average in milliseconds

            // for sd
            double sumOfDiffPut = 0.0;
            double sumOfDiffGet = 0.0;
            for (int k = 0; k < T; k++){  //loop T times for the summation
                sumOfDiffPut += Math.pow(tempTimeToPut[k] - timeToPut[i],2); //squaring the diff (x - mean)^2
                sumOfDiffGet += Math.pow(tempTimeToGet[k] - timeToGet[i],2); //squaring the diff
            }
            timeToPutSD[i] = Math.sqrt(sumOfDiffPut / (double) T) ;  // Divide by N-1 because it is sample
            timeToGetSD[i] = Math.sqrt(sumOfDiffGet / (double) T) ;  // Divide by N-1 because it is sample
        }
    }

    private static boolean timeStatic(int T) {

        double[] mf = {8, 4, 2, 1.5, 1.25, 1.125};
        double[] timeToPutLocal = new double[6];
        double[] timeToGetLocal = new double[6];
        double[] timeToDeleteLocal = new double[6];
        boolean isEmpty = true;
        for (int i = 0; i < mf.length; i++) {
            double[] tempTimeToPut = new double[T];
            double[] tempTimeToGet = new double[T];
            double[] tempTimeToDelete = new double[T];
            for (int t = 0; t < T; t++) {
                System.gc();

                LinearProbingHashST<String, Integer> StaticHash = new LinearProbingHashST<String, Integer>((int) (mf[i] * 321165));

                // put
                double start = System.currentTimeMillis();
                for (int j = 0; j < English_Dict_Array.length; j++) {
                    StaticHash.put(English_Dict_Array[j], 1);
                }
                double finish = System.currentTimeMillis();
                double TimeToCreate = finish - start;
                timeToPutLocal[i] += TimeToCreate;    // total time to put (Sum of the total time to put)
                tempTimeToPut[t] = TimeToCreate;   // times to put (T in total)

                // get
                start = System.currentTimeMillis();
                for (int j = 0; j < English_Dict_Array.length; j++) {
                    StaticHash.get(English_Dict_Array[j]);
                }
                finish = System.currentTimeMillis();
                double TimeToGet = finish - start;
                timeToGetLocal[i] += TimeToGet;    // total time to put (Sum of the total time to put)
                tempTimeToGet[t] = TimeToGet;   // times to put (T in total)

                // delete
                start = System.currentTimeMillis();
                for (String word: English_Dict_Array){
                    StaticHash.delete(word);
                }
                finish = System.currentTimeMillis();
                if (isEmpty)  isEmpty = StaticHash.isEmpty();   // if true then can be updated, once false cant change
                double TimeToDelete = finish - start;
                timeToDeleteLocal[i] += TimeToDelete;    // total time to put (Sum of the total time to put)
                tempTimeToDelete[t] = TimeToDelete;   // times to put (T in total)


            }
            timeToPutFixed[i] = timeToPutLocal[i] / (double) T;  //average in milliseconds
            timeToGetFixed[i] = timeToGetLocal[i] / (double) T;
            timeToDeleteFixed[i] = timeToDeleteLocal[i] / (double) T;

            // for sd
            double sumOfDiffPut = 0.0;
            double sumOfDiffGet = 0.0;
            double sumOfDiffDelete = 0.0;
            for (int k = 0; k < T; k++){  //loop T times for the summation
                sumOfDiffPut += Math.pow(tempTimeToPut[k] - timeToPutFixed[i],2); //squaring the diff (x - mean)^2
                sumOfDiffGet += Math.pow(tempTimeToGet[k] - timeToGetFixed[i],2); //squaring the diff
                sumOfDiffDelete += Math.pow(tempTimeToDelete[k] - timeToDeleteFixed[i],2); //squaring the diff
            }
            timeToPutFixedSD[i] = Math.sqrt(sumOfDiffPut / (double) T) ;
            timeToGetFixedSD[i] = Math.sqrt(sumOfDiffGet / (double) T) ;
            timeToDeleteFixedSD[i] = Math.sqrt(sumOfDiffDelete / (double) T) ;
        }
        return isEmpty;
    }


    private static boolean timeToFillAndDelete(int T) {
        double[] timeToAddAndDelete = new double[T];
        double sum = 0.0;
        boolean isEmpty = true;
        for (int t = 0; t < T; t++) {
            System.gc();
            LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>();

            double start = System.currentTimeMillis();
            for (int j = 0; j < English_Dict_Array.length; j++) {
                st.put(English_Dict_Array[j], 1);
            }

            for (String word: English_Dict_Array){
                st.delete(word);
            }
            double finish = System.currentTimeMillis();
            double TimeToCreate = (finish - start);
            sum+=TimeToCreate;
            timeToAddAndDelete[t] = TimeToCreate;
            if (isEmpty)  isEmpty = st.isEmpty();   // if true then can be updated, once false cant change

        }
        double avg = sum / (double) T;
        timeToPutAndDelete = avg;
        double diff = 0.0;
        for (int j = 0; j < T;  j++){
            diff += Math.pow(timeToAddAndDelete[j] - avg,2);
        }
        timeToPutAndDeleteSD = Math.sqrt(diff / (double) T);
        return isEmpty;
    }



    public static void main(String[] args) {

        // Create the file object, the Scanner, and an array to hold words


        In myDict = new In("words.english.txt");
        int index = 0;
        //Fill the English_Dict_Array and close the reader
        while (myDict.hasNextLine()) {
            English_Dict_Array[index++] = myDict.readLine();
        }


        int T = 20;     // Number of T independent tests

        timeToGetAndPutDynamic(T);
        boolean deleteSuccessStatic = timeStatic(T);
        boolean deleteSuccess = timeToFillAndDelete(T);

        System.out.println("Time to Add And Get Dynamic");
        System.out.println("N	       Time to Put(ms)	Time to Get(ms)      SDPut(ms)    SDGet(ms)");
        for (int i = 0; i < 4; i++) {
            System.out.print(String.format("%4d,       ", (int) (English_Dict_Array.length / (Math.pow(2, i)))));
            System.out.print(String.format("%3.3f,        ", timeToPut[i]));
            System.out.print(String.format("%3.3f              ", timeToGet[i]));
            System.out.print(String.format("%3.3f      ", timeToPutSD[i]));
            System.out.print(String.format("%3.3f  ", timeToGetSD[i]));
            System.out.println();
        }


        double[] mf = {8, 4, 2, 1.5, 1.25, 1.125};
        System.out.println();
        System.out.println("Time to Add , Get and Delete Fixed  (With mF)");
        if (deleteSuccessStatic){
            System.out.println("Everything deleted successfully");
        } else {
            System.out.println("WARNING: Some of the values were not deleted");
        }
        System.out.println("mf     Size	        Time to Put Constant Size(ms)		  Time to Get Constant Size(ms)        SDPut(ms)    SDGet(ms)      TimeToDelete       DeleteSD");
        for (int i = 0; i < 6; i++) {
            System.out.print("(" + mf[i] +")   " + String.format("%4d,             ", (int) (mf[i] * 321165)));
            System.out.print(String.format("%3f,                       ", timeToPutFixed[i]));
            System.out.print(String.format("%3f,                       ", timeToGetFixed[i]));
            System.out.print(String.format("%3.3f        ", timeToPutFixedSD[i]));
            System.out.print(String.format("%3.3f         ", timeToGetFixedSD[i]));
            System.out.print(String.format("%3f,              ", timeToDeleteFixed[i]));
            System.out.print(String.format("%3.3f        ", timeToDeleteFixedSD[i]));
            System.out.println();
        }

        System.out.println();
        System.out.println("Time for adding and deleting the whole dictionary");
        if (deleteSuccess){
            System.out.println("Everything deleted successfully");
        } else {
            System.out.println("WARNING: Some of the values were not deleted");
        }
        System.out.println("TimeToPutAndDelete       TimeToPutAndDeleteSD");
        System.out.print(String.format("%3f,                       ", timeToPutAndDelete));
        System.out.print(String.format("%3f,                       ", timeToPutAndDeleteSD));


    }

}
