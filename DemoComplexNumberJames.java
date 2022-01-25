package Q1;

import java.util.Scanner;

/**********************************************************************************************************
 James Morales
 251136192
 March 12th 2021
 Part D focuses on displaying a menu along with a header that will then allow the user to chose between 3 different alternatives.
 Depending on the alternative chosen, the user will have to input asked values and pre-created methods will be used in order to
 deliver the alternative chosen by the user. This will be done by using an infinite loop that will have a Switch statement inside of it.
 ************************************************************************************************************/
public class DemoComplexNumberJames {
    public static void main(String[] args) {
        //Here I reuse my header from lab 04 and pass values as arguments
        //MyMethod.printHeader("James Morales", 6, 1);

        //Here I am creating the reference variables and variables that I was told to create
        RecComplexNum recNum = new RecComplexNum();
        PolarComplexNum polNum = new PolarComplexNum();
        double real;
        double imaginary;
        double magnitude;
        double angle;

        Scanner input = new Scanner(System.in);
        int choice;
//Here I am creating my infinite loop that will continuously play until I break out of the loop with my exit option
        while (true) {
            //Here, I display the menu as well as a space in which the user will be able to input their choice of operation
            System.out.println("\n**** Complex Number Conversion *****");
            System.out.println("************************************");
            System.out.println("1)\tRectangular/Cartesian to Polar");
            System.out.println("2)\tPolar to Rectangular/Cartesian");
            System.out.println("3)\tExit!");
            System.out.println("************************************");
            System.out.print("What conversion would you like to perform? ");
            //The user's choice is then stored into this choice variable
            choice = input.nextInt();

            //Now, I evaluate the variable "choice" into its menu options 1), 2), 3) and 4 (default)
            switch (choice) {
                //case 1 converts a rectangular form complex number into its polar form
                case 1 -> {
                    //Here I am allowing the user to input the real part of a complex number
                    //as well as the imaginary and store them into their respected variables
                    System.out.println("\nConverting Rectangular/Cartesian To Polar: ");
                    System.out.print("Enter real value: ");
                    real = input.nextDouble();
                    System.out.print("Enter imaginary value: ");
                    imaginary = input.nextDouble();

                    //Here I output the result
                    System.out.println("\nResult in Polar Form\n--------------------");
                    //The object created in the beginning gets the inputted values passed into it (real and imaginary)
                    recNum = new RecComplexNum(real, imaginary);
                    //Here I use my RecComplexNum type reference variable named recNum and display its rectangular form
                    //with the displayRecForm
                    System.out.print("Given Rectangular Form ");recNum.displayRecForm();
                    //Here I am using my getPolarFromRec() method to convert my recNum into polar form by calculating its
                    //magnitude and angle and then I display it into its polar form format
                    System.out.print("In Polar Form ");recNum.getPolarFromRec().displayPolarForm();


                }
                //case 2 converts a polar form complex number into its rectangular form
                case 2 -> {
                    //Here I am allowing the user to input the magnitude part of a polar form of a complex number
                    //as well as the angle and store them into their respected variables
                    System.out.println("\nConverting Polar to Rectangular/Cartesian form: ");
                    System.out.print("Enter magnitude value: ");
                    magnitude = input.nextDouble();
                    System.out.print("Enter angle value in degree: ");
                    angle = input.nextDouble();

                    System.out.println("\nResult in Rectangular Form\n---------------------------------");
                    //The object created in the beginning gets the inputted values passed into it (magnitude and angle)
                    polNum = new PolarComplexNum(magnitude, angle);
                    //Here I use my PolarComplexNum type reference variable named polNum and display its polar form
                    //with the displayPolarForm
                    System.out.print("Given Polar Form "); polNum.displayPolarForm();
                    //Here I am using my getRecFromRec() method to convert my polNum into rectangular form by calculating its
                    //real and imaginary values and then I display it into its rectangular form format with displayRecForm()
                    System.out.print("In Rectangular Form ");polNum.getRecFromPolar().displayRecForm();

                }
                //case 3 simply breaks out of its loop. Once its out, it evaluated the if statement and breaks out of the while loop
                //To finally display the footer provided by the myFooter method in the MyMethod class
                case 3 -> {
                    break;
                }
                //case 4 acts as my default method and tells the user that their input was invalid and to input a value between 1 and 3
                case 4 -> {
                    System.out.println("Invalid Choice! Enter any choice between 1 and 3.");
                    break;
                }
            }
            if (choice == 3)
                break;
        }
        MyMethod.printFooter("Goodbye from James Morales");
    }
}
