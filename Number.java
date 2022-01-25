package Q1;

public class Number {
    private double[] arr;

    //This method will accept an array reference variable
    public Number(double[] arr) {
        this.arr = arr;
    }
// This getter method will sift through the array, continuously updating the "result" variable until it equates
    //the value for the highest double type value found in the array
    public double getMax() {
        double result = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > result)
                result = arr[i];
        return result;
    }
    // This getter method will sift through the array, continuously updating the "result" variable until it equates
    //the value for the lowest double type value found in the array
    public double getMin() {
        double result = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] < result)
                result = arr[i];
        return result;
    }
    // This getter method will sift through the array, continuously updating the "sum" variable until it equates
    //the summation of all the double type values found in the array. Then, the sum value will be divided by the amount
    //of elements found in the array
    public double getAverage() {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];}
        return sum / arr.length;
        }
    // This method will sift through the array, continuously printing a string value that will indicate the index position
    // as well as its actual value found at that position in the array
        public void printArray()
        {
            for (int i = 0; i < arr.length; i++)
                System.out.printf("arr[%d] = %.2f\n",i, arr[i]);
        }

        public static void printHeader (String name,int labNum, int quesNum)
        {
            System.out.printf("*************************\n\t%s\n\tLab #%d, Question %d\n*************************\n", name, labNum, quesNum);
        }
        //This method is recycled from Lab04 in which it will accept an ending message
        // as argument and print out the message with asterisks
        //Here I created a footer that can be called back when inserting a string/message as an argument
        public static void printFooter (String anyValidName)
        {
            System.out.printf("\n*** %s ***", anyValidName);
        }
    }
