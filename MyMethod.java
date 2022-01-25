package Q1;
/**********************************************************************************************************
 James Morales
 251136192
 March 12th 2021
 Part A focuses creating constructors and methods in order to access use them in other methods. To elaborate, this part focused
 on being able to reproduce existing Math type methods such as pow(), Sin() and Cos() through the use of loops in order to
 reproduce summation equations
 ************************************************************************************************************/
public class MyMethod {
    public static double myPow(double x, int y) {
        //Here I am creating a loop that will repeat y number of times.
        double sum = 1;
        //With these if statements, I am accounting for a negative exponential
        if (y > 0) {
            //Then, I create a loop to x multiply itself y number of times and create the variable sum to hold the summation of each product
            while (y > 0) {
                sum *= x;
                y--;
            }
        } else if (y < 0) {
            while (y < 0) {
                sum /= x;
                y++;
            }
        }
        return sum;
    }

    //Here I am creating the mySin helper method
        public static double mySin ( double x)
        {
            //Firstly, I declare data-fields and make it so that my outer for loop continues up to 20
            double y = 0;
            int N = 20;
            for (int n = 0; n <= N; n++) {
                //inner loop 1: calculate first part (-1)^n with a variable part1 which acts as the summation of all products
                double part1 = 1;
                for (int i = 1; i <= n; i++)
                    part1 = part1 * (-1);


                // inner loop 2: calculate second part (2n+1)! with part2 which acts as the summation of all products
                double part2 = 1;
                for (int j = 1; j <= 2 * n + 1; j++)
                    part2 *= j;

                //inner loop 3: calculate third part (x^(2n+1)) with part3 which acts as the summation of all products
                double part3 = 1;
                for (int k = 1; k <= 2 * n + 1; k++)
                    part3 *= x;
// Finally, I do the final calculation with the formula provided and make sure that the y variable continuously gets updated after every loop
                y = y+(part1 / part2) * part3;
            }
            return y;
        }
    //Here I am creating the myCos helper method
    public static double myCos ( double x)
    {
        double w = 0;
        int N = 20;
        for (int n = 0; n <= N; n++) {
            //inner loop 1: calculate first part -1^n with a variable part1 which acts as the summation of all products
            double part1 = 1;
            for (int i = 1; i <= n; i++)
                part1 = part1 * (-1);


            // inner loop 2: calculate second part (2n+1)! with part2 which acts as the summation of all products
            double part2 = 1;
            for (int j = 1; j <= 2 * n ; j++)
                part2 *= j;

            //inner loop 3: calculate third part (x^(2n+1)) with part3 which acts as the summation of all products
            double part3 = 1;
            for (int k = 1; k <= 2 * n ; k++)
                part3 *= x;
// Finally, I do the final calculation with the formula provided and make sure that the w variable continuously gets updated after every loop
            w = w+(part1 / part2) * part3;
        }
        return w;
    }

    public static double mySqrt (double x) {
        double lastGuess = 1, nextGuess =1, tolerance = 1E-4;

        while (true) {
            nextGuess = (lastGuess+(x/lastGuess))/2;
            if (Math.abs(nextGuess-lastGuess)<=tolerance)
            {
                return nextGuess;
            }
            else
                lastGuess = nextGuess;
        }
    }

    public static void printHeader(String name1, String name2, String name3, int labNum, int quesNum)
    {
        System.out.printf("--------------------------\nMember Name(s):\n%s\n%s\n%s\nLab No.:%d, Question No.%d\n--------------------------\n", name1, name2, name3, labNum, quesNum);
    }
    //This method is recycled from Lab04 in which it will accept an ending message
    // as argument and print out the message with asterisks
    public static void printFooter (String anyValidName)//Here I created a footer that can be called back when inserting a string/message as an argument.
    {
        System.out.printf("\n*** %s ***", anyValidName);
    }

}