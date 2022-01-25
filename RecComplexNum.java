package Q1;

public class RecComplexNum {
    /**********************************************************************************************************
     James Morales
     251136192
     March 12th 2021
     Part B focuses creating constructors and methods in order to eventually convert a RecComplexNum type reference
     variable with values passed into it into a PolarComplexNum type reference variable named polForm1. Then, I create a
     method named displayRecForm that will intake the passed imaginary and real values and present it into the correct format.
     ************************************************************************************************************/
    //Here I am declaring my private data fields.
    private double real;
    private double imaginary;

    public double getReal()
    {
        return real;
    }

    public double getImaginary()
    {
        return imaginary;
    }


    // then I create a default constructor which pulls the private data fields into it in order to give them default values of 0
    public RecComplexNum()
    {
        real = 0;
        imaginary = 0;
    }
    //Then, with this constructor. I am able to give values to the private data fields which will allow me to use these data fields in the driver method.
    public RecComplexNum(double re, double im)
    {
        real = re;
        imaginary = im;
    }

    //Here I am creating my PolarComplexNum type method named getPolarFromRec that will utilize the myPow helper method
    //created in the MyMethod class. With the information and equation provided, I calculated magnitude and angle variables
    //Then, I passed those values into the polForm1 object that will be a converted version of my object1
    public PolarComplexNum getPolarFromRec()
    {
        RecComplexNum object1 = new RecComplexNum();

        double mag = MyMethod.mySqrt((MyMethod.myPow(real,2)+ MyMethod.myPow(imaginary,2)));
        double angle = Math.toDegrees(Math.atan(imaginary/ real));

        PolarComplexNum polForm1 = new PolarComplexNum(mag, angle);
        return polForm1;
    }
    //Here I created my displayRecForm method that will take real and imaginary values passed to an object created in my driver class
    // and present them in the wanted format.
    public void displayRecForm()
    {
        if (imaginary < 0)
            System.out.printf("%.2f - %.2fi", real, imaginary * -1);
        else
            System.out.printf("%.2f + %.2fi", real, imaginary);

    }

}
