package Q1;


import java.util.Scanner;

/**********************************************************************************************************
 James Morales
 251136192
 April 9th 2021
 Q1 focuses on completing the calculator from lab 8 by displaying a menu along with a header that will then allow the user to
 chose between 5 different alternatives. Depending on the alternative chosen, the user will have to input asked values and pre-created
 methods will be used in order to deliver the alternative chosen by the user.
 This will be done by using an infinite loop that will have a Switch statement inside of it.
 ************************************************************************************************************/

public class    ComplexNumCalcByJames
{
    public static Scanner input = new Scanner(System.in);//Instantiate a Scanner type object to allow the input from a user

    public static ComplexAddSubClass [] recArray = new ComplexAddSubClass[2];//A ComplexAddSubClass array is instantiated of size 2

    public static ComplexAddSubClass result = new ComplexAddSubClass();//A ComplexAddSubClass object is instantiated named result

    public static ComplexMultiDivideClass [] polarArray = new ComplexMultiDivideClass[2];//A ComplexMultiDivide Class array is instantiated of size 2

    public static ComplexMultiDivideClass mdResult = new ComplexMultiDivideClass();//A ComplexMultiDivide object is instantiated named mdResult

    public static PolarComplexNum pcn = new PolarComplexNum();

    public static void main(String[] args)//driver method
    {
        MyMethod.printHeader("none", "none", "James Morales", 8, 2);//Recycled header

        int choice;

        //Here I am creating my infinite loop that will continuously play until I break out of the loop with my exit option
        while (true) {
            //Here, I display the menu as well as a space in which the user will be able to input their choice of operation
            System.out.println("\n**** Complex Number Adder / Substractor *****");
            System.out.println("************************************");
            System.out.println("1)\tAdder");
            System.out.println("2)\tSubstractor");
            System.out.println("3)\tMultiplier");
            System.out.println("4)\tDivider");
            System.out.println("5)\tExit!");
            System.out.println("************************************");
            System.out.print("What operation would you like to perform: ");
            //The user's choice is then stored into this choice variable
            choice = input.nextInt();

            //Now, I evaluate the variable "choice" into its menu options 1), 2), 3) and 4 (default)
            switch (choice) {
                //case 1 performs the addition operation on 2 user inputted complex numbers
                case 1 -> {
                    //Here I am allowing the user to input the real and imaginary part of a complex number by calling dataEntry()
                    dataEntry();
                    System.out.println("Here is your result (a + b)");
                    System.out.println("---------------------------------");

                    System.out.printf("a = %s", recArray[0].toString());//Here I show the user the first complex number they created
                    System.out.printf("\nb = %s", recArray[1].toString());//Here I show the user the second complex number they created
                    result = result.adder(recArray[0],recArray[1]);//Here I am making result object equal to the addition of the first and second element in the array (both user inputted complex numbers)

                    System.out.printf("\na + b = %s\n", result.toString());//Here I am printing out the result value formatted with the toString() method

                }
                //case 2 performs the subtraction operation on 2 user inputted complex numbers
                case 2 -> {
                    //Here I am allowing the user to input the real and imaginary part of a complex number by calling dataEntry()
                    dataEntry();
                    System.out.println("Here is your result (a - b)");
                    System.out.println("----------------------------------");

                    System.out.printf("a = %s", recArray[0].toString());//Here I show the user the first complex number they created
                    System.out.printf("\nb = %s", recArray[1].toString());//Here I show the user the second complex number they created

                    result = result.substractor(recArray[0],recArray[1]);//Here I am making result object equal to the addition of the first and second element in the array (both user inputted complex numbers)

                    System.out.printf("\na + b = %s\n", result.toString());//Here I am printing out the result value formatted with the toString() method


                }
                //case 3 performs the multiplication operation on 2 user inputted complex numbers
                case 3 -> {
                    //Here I am allowing the user to input the real and imaginary part of a complex number by calling dataEntry()
                    dataEntry();
                    for (int i = 0; i<recArray.length; i++)
                    {
                        pcn = recArray[i].getPolarFromRec();
                        ComplexMultiDivideClass holder = new ComplexMultiDivideClass(pcn.getMagnitude(), pcn.getAngle());//Here I created an object in order to insert the pcn magnitude and angle
                        polarArray[i] = holder;
                    }

                    System.out.println("Here is your result (a x b)");
                    System.out.println("----------------------------------");

                    System.out.printf("a = %s; In Polar Form=> %s", recArray[0].toString(), polarArray[0].toString());//Here I show the user the first complex number they created
                    System.out.printf("\nb = %s; In Polar Form=> %s", recArray[1].toString(), polarArray[1].toString());//Here I show the user the second complex number they created

                    mdResult = ComplexMultiDivideClass.multiply(polarArray[0], polarArray[1]);//Here I am making mdResult object equal to the multiplication of the first and second element in the array (both user inputted complex numbers)

                    System.out.printf("\na x b = (In Polar) %s\n", mdResult.toString());//Here I am printing out the result value formatted with the toString() method in polar form
                    if (mdResult.getRecFromPolar().getImaginary()<0)
                        System.out.printf("a x b = (In Rectangle) %.2f - %.2fi\n", mdResult.getRecFromPolar().getReal(), mdResult.getRecFromPolar().getImaginary()*-1);//Here I am printing out the result value formatted with the toString() method in rectangular form
                    else
                        System.out.printf("a x b = (In Rectangle) %.2f + %.2fi\n", mdResult.getRecFromPolar().getReal(), mdResult.getRecFromPolar().getImaginary());//Here I am printing out the result value formatted with the toString() method in rectangular form

                }
                //case 4 performs the division operation on 2 user inputted complex numbers
                case 4 -> {
                    //Here I am allowing the user to input the real and imaginary part of a complex number by calling dataEntry()
                    dataEntry();
                    for (int i = 0; i<recArray.length; i++)
                    {
                        pcn = recArray[i].getPolarFromRec();
                        ComplexMultiDivideClass holder = new ComplexMultiDivideClass(pcn.getMagnitude(), pcn.getAngle());
                        polarArray[i] = holder;
                    }

                    System.out.println("Here is your result (a / b)");
                    System.out.println("----------------------------------");

                    System.out.printf("a = %s; In Polar Form=> %s", recArray[0].toString(), polarArray[0].toString());//Here I show the user the first complex number they created
                    System.out.printf("\nb = %s; In Polar Form=> %s", recArray[1].toString(), polarArray[1].toString());//Here I show the user the second complex number they created

                    mdResult = ComplexMultiDivideClass.divide(polarArray[0], polarArray[1]);//Here I am making mdResult object equal to the division of the first and second element in the array (both user inputted complex numbers)

                    System.out.printf("\na / b = (In Polar) %s\n", mdResult.toString());//Here I am printing out the result value formatted with the toString() method in polar form

                    if (mdResult.getRecFromPolar().getImaginary()<0)
                        System.out.printf("a / b = (In Rectangle) %.2f - %.2fi\n", mdResult.getRecFromPolar().getReal(), mdResult.getRecFromPolar().getImaginary()*-1);//Here I am printing out the result value formatted with the toString() method in rectangular form
                    else
                        System.out.printf("a / b = (In Rectangle) %.2f + %.2fi\n", mdResult.getRecFromPolar().getReal(), mdResult.getRecFromPolar().getImaginary());//Here I am printing out the result value formatted with the toString() method in rectangular form

                }

                //case 5 simply breaks out of its loop while printing out a statement indicating how many objects have been instantiated. Once its out, it evaluated the if statement and breaks out of the while loop
                //To finally display the footer provided by the myFooter method in the MyMethod class
                case 5 -> {
                    System.out.printf("%d ComplexAddSubClass Objects have been instantiated in this program.\n",result.getCounter());
                    System.out.printf("%d ComplexMultiDivideClass Objects have been instantiated in this program.\n", ComplexMultiDivideClass.getPolarCounter());

                    break;
                }
                //case 6 acts as my default method and tells the user that their input was invalid and to input a value between 1 and 3
                case 6 -> {
                    System.out.println("Invalid Choice! Enter any choice between 1 and 5.");
                    break;
                }
            }
            if (choice == 5)
                break;
        }
        MyMethod.printFooter("Goodbye from James Morales");//recycled footer

    }

    private static void dataEntry()
    {
        for (int i = 0; i< recArray.length; i++) //This loop repeats 2 times in order to allow the user to eventually create and store 2 complex numbers by firstly inputting their real parts followed by their imaginary part.
        {
            System.out.printf("Enter real value %d: ", (i+1));//asks the user to input the real part of the complex number
            double real = input.nextDouble();//real value is then stored into real
            System.out.printf("Enter imaginary value %d: ", (i+1));//asks the user to input the imaginary part of the complex number
            double imaginary = input.nextDouble();//imaginary value is then stored into imaginary

            ComplexAddSubClass recNum = new ComplexAddSubClass(real, imaginary);//ComplexAddSubClass object is created and stored its respected real and imaginary values
            recArray[i] = recNum;//The ComplexAddSubClass is then stored into its index value (0 or 1)
        }
    }
}
