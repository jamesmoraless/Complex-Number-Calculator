package Q1;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DemoFileJames {
    public static void main(String[] args) throws IOException {
        //MyMethod.printHeader("James Morales", 7, 2);

        //Here, I am creating a RecComplexNum type array named recArr
        RecComplexNum[] recArr = new RecComplexNum[3];

        Scanner input = new Scanner((System.in));
        System.out.println();

        //Here I am populating the real and imaginary parts of the array and then updating the recArr[i] value with its real and imaginary parts
        for (int i=0; i<recArr.length; i++)
        {
            double real;
            double imaginary;

            System.out.printf("Enter real part for RecArr[%d]: ", i);
            real = input.nextDouble();
            System.out.printf("Enter imaginary part for RecArr[%d]: ", i);
            imaginary = input.nextDouble();
            recArr [i] = new RecComplexNum(real, imaginary);
        }
        //After having the populated array, I simply print it out to demonstrate the array to the user by calling the displayRecForm method
        System.out.print("\nArray of Rectangular Complex numbers is: ");
        for (int i=0; i<recArr.length; i++)
        {
            System.out.print("\nRecArr ["+i+"]: "); recArr[i].displayRecForm();
        }

        //Then, I create a PolarComplexNum type array named polArr that will hold the polar form of the values inputted into recArr by
        //having the recArr passed into the returnPolarForm method
        PolarComplexNum[] polArr = new PolarComplexNum[3];
        polArr = returnPolarForm(recArr);

        //Here I am simply outputting the polar form ot the array by calling the displayPolarForm method
        System.out.println("\n\nCorresponding Array of Polar Complex numbers is: ");
        for (int i=0; i<polArr.length; i++)
        {
            System.out.print("PolarArr ["+i+"]: "); polArr[i].displayPolarForm();
        }
        //Here I am creating a text file called DataFileJames.txt. Then, I present both forms of the arrays (Rectangular form
        //followed by Polar form) on each line inside the file.
        PrintWriter printerFile = new PrintWriter("DataFileJames.txt");
        for (int i = 0; i < polArr.length; i++)
        {
            if (recArr[i].getImaginary() < 0)
                printerFile.printf("%.2f - %.2fi = Magnitude: %.2f, Angle: %.2f deg.\n", recArr[i].getReal(),recArr[i].getImaginary()*-1, polArr[i].getMagnitude(), polArr[i].getAngle());
            else
                printerFile.printf("%.2f + %.2fi = Magnitude: %.2f, Angle: %.2f deg.\n", recArr[i].getReal(),recArr[i].getImaginary(), polArr[i].getMagnitude(), polArr[i].getAngle());;
        }
        printerFile.close();//closed file

        MyMethod.printFooter("Goodbye from James Morales");
    }

    //Here I am creating a method that will accept a RecComplexNum type reference variable array and pass it into its body
    public static PolarComplexNum [] returnPolarForm(RecComplexNum [] array)
    {
        //Here I am creating a PolarComplexNum type reference variable array of size 3
        PolarComplexNum[] recToPolar = new PolarComplexNum[3];
        //Then, I convert the values found in the passed array into their polar form and they are stored into the PolarComplexNum array created
        for (int i = 0; i<recToPolar.length; i++)
        {
            recToPolar[i] = array[i].getPolarFromRec();
        }
        return recToPolar;
    }

}
