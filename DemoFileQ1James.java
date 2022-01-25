package Q1;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.Scanner;
/**********************************************************************************************************
 James Morales
 251136192
 April 3rd 2021
 Q1 focuses on reading the provided file and inserting its double type values into a 2D array. Then, the 2D array will be
 'squished' into a 1D array with the use of objects. Then, the 1D array will be passed through a polar complex converter
 in which every value (rectangular complex numbers) inside the array will be converted into its polar form. Finally, the
 file will be updated and a new section that will be appended would be added with the results of the rectangular number's
 polar forms.
 ************************************************************************************************************/

public class DemoFileQ1James {
    public static void main(String[] args) throws IOException
    {

        //MyMethod.printHeader("James Morales", 8, 1);//Recycled header

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name of the file to read from: ");//The user is expected to input DataFile.txt
        String fileName = input.nextLine();

        File givenFile = new File(fileName);//Then the file will be named with the user input


        if (!(givenFile.exists()))//Here we are checking if the file exists or not
        {
            System.out.printf("Error - The file %s does not exist", fileName);//If file does not exist,this is the output
        }

        int n = 3;//row number
        int m = 2;//column number
        double [][] fileArray = new double [n][m];//the array size is instantiated by using the n x m sizing

        Scanner fileScanner = new Scanner(givenFile); //The file will be scanned and sifted through in order to store its values into an array

        for (int i = 0; i<n; i++)
        {
            for (int j = 0; j<m && fileScanner.hasNext(); j++)
            {
            fileArray[i][j] = fileScanner.nextDouble();//Here every scanned double type value will be stored into the 2D double type array
            }
        }
        fileScanner.close();//the file is closed.

        print2DArray(fileArray);//Here we pass the array created by the file and pass it to the print2DArray method and it will print the array

        RecComplexNum [] oneDimArray = new RecComplexNum[3];// here we created a RecComplexNum 1D array that will hold the 'squished' values of the 2D array

        oneDimArray = squishTo1DRecComplexNUmArray(fileArray);//Here I pass the 2D array into the squish method in order to convert it into a 1D array


        PolarComplexNum [] polarArray = returnPolarForm(oneDimArray); //Here I am passed the 1D array into the returnPolarForm in order to convert its values to polar form
        System.out.println("Corresponding Array of Polar Complex numbers is: ");

        for (int i = 0; i< polarArray.length; i++)//loop will repeat until every value (3 values) will be displayed as polar form
        {
            System.out.printf("PolarArr[%d]: ", i);
            polarArray[i].displayPolarForm();//recycled display polar form
        }
        System.out.println("Updating the "+fileName+"....");

        FileWriter fileWrite = new FileWriter(fileName,true);
        PrintWriter printWrite = new PrintWriter(fileWrite);//This allows for us to "write" into the file that the user initially inputs/names
        printWrite.println("\nRectangle to Polar Conversion:");
        for (int i=0; i<polarArray.length; i++)
        {
            if(oneDimArray[i].getImaginary()<0)//for formatting reasons an if statement is introduced
            {
                printWrite.printf("%.2f - %.2fi = Magnitude: %.2f, Angle: %.2f deg\n",oneDimArray[i].getReal(),oneDimArray[i].getImaginary()*-1,polarArray[i].getMagnitude(),polarArray[i].getAngle());
            }
            else
                {
                printWrite.printf("%.2f + %.2fi = Magnitude: %.2f, Angle: %.2f deg\n",oneDimArray[i].getReal(),oneDimArray[i].getImaginary(),polarArray[i].getMagnitude(),polarArray[i].getAngle());
            }
        }
        printWrite.close();//file is closed

        System.out.println("Done");

        MyMethod.printFooter("Good bye from James Morales");//Goodbye!

    }
    //This method prints a 2D array
    public static void print2DArray(double[][] arr)
    {
        System.out.println("\nContents of 2D Rectangular Array read from the ");
        //The outer loop will repeat the same amount of times as the passed array's row number is
        for(int i = 0; i<arr.length; i++)
        {
            //The inner loop will repeat the same amount of times as the passed array's column number is
            for(int j = 0; j<arr[i].length; j++)
            {
                //The formatting here indicates that there will be 7 spaces before the system prints and 2 decimal places
                System.out.printf("%7.2fi", arr[i][j]);
            }
            System.out.println();//This is simply an enter
        }
    }

    //This method will store a created object with its respected real and imaginary values into an array named createdArray.
    public static RecComplexNum [] squishTo1DRecComplexNUmArray(double [][] recArr2D)
    {
        RecComplexNum [] createdArray = new RecComplexNum[3];
        double real = 0;
        double imaginary = 0;

        //This outer loop will repeat 3 times
        for (int i = 0; i < recArr2D.length; i++)
        {
            //This inner loop will repeat 2 times
            for (int d = 0; d < recArr2D[i].length; d++)
            {
                if (d==0)
                    real = recArr2D[i][d];
                else
                    imaginary = recArr2D[i][d];
                //This recNum object will be used as a rectangular complex number with its respected real and imaginary values
                RecComplexNum recNum = new RecComplexNum(real, imaginary);
                //Now the created array will store in each of its indexes a unique recNum object
                createdArray[i] = recNum;

            }
        }
        //This method will now return the 1D array composed of rectangular form complex numbers.
        return createdArray;
    }


    public static PolarComplexNum[] returnPolarForm(RecComplexNum[] recArray)
    {
        //Here I am creating a PolarComplexNum type reference variable array of size 3
        PolarComplexNum[] recToPolar = new PolarComplexNum[3];
        //Then, I convert the values found in the passed array into their polar form and they are stored into the PolarComplexNum array created
        for (int i = 0; i<recToPolar.length; i++)
        {
            recToPolar[i] = recArray[i].getPolarFromRec();
        }
        return recToPolar;
    }

}
