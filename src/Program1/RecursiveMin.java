package Program1;


import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;

public class RecursiveMin {

    public static void main(String[] args) {
        int size = 20;
        int max = 1000;
        Random gen = new Random();
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = gen.nextInt(max);
        }
        printArray(data);
        int minDat = minRec(data);
        System.out.println("Min is " + minDat);


        // Check that the proper minimum value is found.
        Arrays.sort(data);
        if(minDat != data[0]) {
            System.out.println("Minimum should be " + data[0] +  "  but " + minDat
                    + "  was computed by minRec");
        }

        // The method is supposed to throw an exception when given an empty
        //      array
        // This part of the program will check that the exception is thrown
        //    properly.
        try {
            int min2Data = minRec(new int[0]);
            System.out.println("Exception should have been thrown for empty list");
        } catch(IllegalArgumentException iae) {
            // there should be an exception thrown for min of an empty list
            // nothing to do here
        }
    }

    /**
     * Returns the minimum of the elements values[0] through values[last-1].
     * Throws an IllegalArgumentException if the array values is empty.
     *
     * @param values Should be non-empty.
     * @param last Should be in the range 1 through values.length-1, inclusive
     * @return the minimum of the elements values[0] through values[length-1]
     */

    public static int minRec(int[] values, int last) {
        int min=1000;
        // fill in your code here
        // if last is negative or 0, throw an IllegalArgumentException
        if(last==0|| last<0){
            throw new IllegalArgumentException("Last cannot equal 0 or less than 0: " + last);
        }
        // if last is 1, there is only one element to check, so just return it
        if(last == 1){
            return values[0];
        }
        // otherwise, get the minimum of the elements with index 0 through last-2,
        // compare that with values[last-1] and return the smaller
        else {
            for (int i = 0; i < last-2; i++) {
                if(values[i]<min){
                    min = values[i];
                }
            }

        }
        if(values[last-1]<min){
            min =values[last-1];
        }
        return min;
    }

    public static int minRec(int[] values) {
        return minRec(values,20);
    }

    public static void printArray(int[] values) {
        for (int v : values) {
            System.out.print(v + " " );
        }
        System.out.println();
    }
}