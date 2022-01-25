package Q1;
/**********************************************************************************************************
 James Morales
 251136192
 March 12th 2021
 Part C focuses creating constructors and methods in order to eventually convert a PolarComplexNum type reference
 variable with values passed into it into a RecComplexNum type reference variable named recNum11. Then, I create a
 method named displayPolarForm that will intake the passed magnitude and angle values and present it into the correct format.
 ************************************************************************************************************/
public class PolarComplexNum {
    //Here I declare my private data fields such as magnitude and angle
    private double magnitude;
    private double angle;

    public double getMagnitude()
    {
        return magnitude;
    }

    public double getAngle()
    {
        return angle;
    }

    //Here I create my default constructor method that declares the magnitude and angle values as 0
    public PolarComplexNum()
    {
        magnitude = 0;
        angle = 0;
    }

    //Here I create my constructor with arguments that passes values into the magnitude and angle variables.
    public PolarComplexNum (double mag, double ang)
    {
        magnitude = mag;
        angle = ang;
    }

    //Here I am creating my RecComplexNum type method named getRecFromPolar that will utilize the myCos and mySin methods
    //created in the MyMethod class. With the information and equation provided, I calculated real and imaginary variables
    //Then, I passed those values into the recNum1 object that will be a converted version of my object1
    public RecComplexNum getRecFromPolar()
    {
        PolarComplexNum object1 = new PolarComplexNum();
        double real = magnitude* MyMethod.myCos(Math.toRadians(angle));
        double imaginary = magnitude* MyMethod.mySin(Math.toRadians(angle));

        RecComplexNum recNum1 = new RecComplexNum(real, imaginary);
        return recNum1;
    }

    //Here I created my displayPolarForm method that will take magnitude and angle values passed to an object created in my driver class
    // and present them in the wanted format.
    public void displayPolarForm()
    {
        System.out.printf("Magnitude: %.2f, Angle: %.2f deg.\n", magnitude, angle);
    }
}
